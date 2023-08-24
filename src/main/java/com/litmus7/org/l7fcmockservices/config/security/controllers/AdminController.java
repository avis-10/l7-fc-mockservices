package com.litmus7.org.l7fcmockservices.config.security.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("admin")
public class AdminController {

	@GetMapping("/greet")
	public String welcomeAd() {
		return "Welcome Admin";
	}
	@GetMapping("/greetAdmin")
	public String welcome() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		System.out.println(auth.getAuthorities());
		return "Welcome Admin";
	}
	@GetMapping("/tellmesecurity")
	public String welcome2() {
		return "Welcome user";
	}
	@GetMapping("/greet/{username}")
	public String welcome(@PathVariable String username) {
		return "Welcome "+username;
	}
	
}