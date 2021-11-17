package com.fun7.backend.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.fun7.backend.users.*;

@RestController
class UserController {

  private final UserRepository repository;
  private static final List<String> MULTIPLAYER_COUNTRIES = new ArrayList<String>();
  UserController(UserRepository repository) {
    this.repository = repository;
    MULTIPLAYER_COUNTRIES.add("US");
  }
  
  @PostMapping("/services/")
  Service result(@RequestParam(name = "timezone") String zone, @RequestParam(name = "userId") String uid, @RequestParam(name = "cc") String cc) {
	  Service result = new Service("disabled", "disabled", "disabled");
	  Optional<User> user = repository.findById(uid);
	  if (user.isPresent()) {
		  User temp = user.get();
		  temp.addExperience();
		  repository.save(temp);
	  }
	  return result;
	  
  }
}
