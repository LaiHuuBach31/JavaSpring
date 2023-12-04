package com.project.admin.controllers;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.entities.CustomUserDetails;

@Controller
@RequestMapping("admin")
public class AdminController {

	@GetMapping("")
	public String index(Model model) {
		model.addAttribute("mess", "Welcome to admin page");

		CustomUserDetails user = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		model.addAttribute("user", user);
		
		return "home";
	}

}
