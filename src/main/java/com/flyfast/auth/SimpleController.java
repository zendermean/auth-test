package com.flyfast.auth;

import java.security.Principal;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleController {

	@RequestMapping("/user")
	public Principal getUser(Principal principal) {
		return principal;
	}
}
