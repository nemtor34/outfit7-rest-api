package com.fun7.backend.unit;

import static org.junit.jupiter.api.Assertions.*;
import com.fun7.backend.controllers.*;
import com.fun7.backend.users.UserRepository;

import org.junit.jupiter.api.Test;

class ServiceControllerTest {
	
	private UserRepository userRepository;
	
	ServiceController cont = new ServiceController(userRepository);

	@Test
	void testCheckUserSupport() {
		String usersup = cont.checkUserSupport();
		assertTrue(usersup.equals("enabled") || usersup.equals("disabled"));
	}

	@Test
	void testCheckAds() {
		String res = cont.checkAds("US");
		assertTrue(res.equals("enabled") || res.equals("disabled"));
	}

}
