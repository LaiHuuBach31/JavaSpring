package com.project.admin.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

	@RequestMapping("login")
	public String login(@RequestParam(value = "error", required = false) String error, Model model) {
		if (error != null) {
			model.addAttribute("error", "Login failed!");
		}
		return "admin_login";
	}

	@RequestMapping("logout")
	public String logout(Model model) {
		model.addAttribute("error", "Has Logged out!!!");
		return "admin_login";
	}

	@RequestMapping("/403")
	public String accessDenied(Model model) {
		model.addAttribute("error", "You do not have access to this site");
		return "admin_login";
	}
}
