package com.fun7.backend.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.joda.time.*;

import com.fun7.backend.users.*;
import com.fun7.backend.ads.*;

@RestController
public class ServiceController {

  private final UserRepository repository;
  private final List<String> MULTIPLAYER_COUNTRIES = new ArrayList<String>();
  public ServiceController(UserRepository repository) {
    this.repository = repository;
    MULTIPLAYER_COUNTRIES.add("US");
  }
  
  @PostMapping("/services/")
  Service result(@RequestParam(name = "timezone") String zone, @RequestParam(name = "userId") String uid, @RequestParam(name = "cc") String cc) {
	  Service result = new Service("disabled", "disabled", "disabled");
	  Optional<User> user = repository.findById(uid);
	  
	  if (user.isPresent()) {
		  //Checking Time in Ljubljana
		  result.setUser_support(checkUserSupport());
		  //Checking User Experience
		  User temp = user.get();
		  temp.addExperience();
		  repository.save(temp);
		  int exp = temp.getExperience();
		  if ( exp > 5 && MULTIPLAYER_COUNTRIES.contains(cc)) {
			  result.setMultiplayer("enabled");
		  }
		  //Getting ads response
		  result.setAds(checkAds(cc));
	  }
	  
	  return result;
	  
  }
  
  public String checkUserSupport() {
	  DateTimeZone Ljubljana = DateTimeZone.forID("Europe/London");
	  DateTime now = new DateTime(Ljubljana);
	  if ( now.getDayOfWeek() < 6 ) {
		  if ( now.getHourOfDay() >= 9 && now.getHourOfDay() < 15) {
			  return "enabled";
		  }
	  }
	  return "disabled";
  }
  
  public String checkAds(String cc) {
	  String response = AdsClient.get(cc);
	  Ads ad = new Ads(response);
	  response = ad.enabled();
	  return response;
  }
}