package com.fun7.backend.ads;

import java.nio.charset.Charset;
import java.util.Arrays;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.apache.commons.codec.binary.Base64;
import org.json.*;

public class AdsClient{

	public static final String USER_NAME = "fun7user";
	public static final String PASSWORD = "fun7pass";

	static final String URL = "https://us-central1-o7tools.cloudfunctions.net/fun7-ad-partner?countryCode=";

	public static String get(String cc) {

		// HttpHeaders
		HttpHeaders headers = new HttpHeaders();
		final String URL_ADS = URL + cc; 
		String result = "";

		// 
		// Authentication
		// 
		String auth = USER_NAME + ":" + PASSWORD;
		byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
		String authHeader = "Basic " + new String(encodedAuth);
		headers.set("Authorization", authHeader);
		// 
		headers.setAccept(Arrays.asList(new MediaType[] { MediaType.APPLICATION_JSON }));
		// Request to return JSON format
		headers.setContentType(MediaType.APPLICATION_JSON);

		// HttpEntity<String>: To get result as String.
		HttpEntity<String> entity = new HttpEntity<String>(headers);

		// RestTemplate
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setErrorHandler(new MyErrorHandler());

		// Send request with GET method, and Headers.
		ResponseEntity<String> response = restTemplate.exchange(URL_ADS, //
				HttpMethod.GET, entity, String.class);
		if (response.getStatusCode().is2xxSuccessful()) {
			result = response.getBody();
			JSONObject json = new JSONObject(result);
			result = json.get("ads").toString();
		} else {
			result = "None";
		}
		return result;
	}

}