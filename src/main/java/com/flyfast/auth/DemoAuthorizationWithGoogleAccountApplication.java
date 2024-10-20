package com.flyfast.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@SpringBootApplication
public class DemoAuthorizationWithGoogleAccountApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoAuthorizationWithGoogleAccountApplication.class, args);
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		return http
				.authorizeHttpRequests(registry -> {
					registry.requestMatchers("/", "/login", "/google-login").permitAll();
					registry.anyRequest().authenticated();
				})
				.oauth2Login(oAuth2Login ->
						oAuth2Login
								.loginPage("/google-login")
								.successHandler((request, response, authentication) -> response.sendRedirect("/profile")))
				.formLogin(Customizer.withDefaults())
				.build();
	}
}
