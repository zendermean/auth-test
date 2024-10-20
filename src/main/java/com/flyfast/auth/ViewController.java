package com.flyfast.auth;

import java.util.Map;

import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

	@GetMapping("/profile")
	public String getProfile(OAuth2AuthenticationToken token, Model model) {
		model.addAllAttributes(Map.of(
				"name", token.getPrincipal().getAttribute("name"),
				"email", token.getPrincipal().getAttribute("email"),
				"photo", token.getPrincipal().getAttribute("picture")
		));
		return "profile";
	}

	@GetMapping("/")
	public String login() {
		return "google_login";
	}
}
