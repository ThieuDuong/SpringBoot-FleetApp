/*
 * Thieu Duong
 */
package com.fleet.thieuduong.fleetapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApplicationController {
	@GetMapping("/login")
	public String login() {
		System.out.println("Login");
		return "login";
	}
	
	@GetMapping("/register")
	public String register() {
		return "Register";
	}
	
//	@GetMapping("/logout")
//	public String logout() {
//		return "login";
//	}

}
