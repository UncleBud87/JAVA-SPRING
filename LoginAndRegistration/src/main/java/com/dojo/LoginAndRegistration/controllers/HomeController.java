package com.dojo.LoginAndRegistration.controllers;



import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.dojo.LoginAndRegistration.services.UserService;

@Controller
public class HomeController 
{
	@Autowired
	private UserService userService;
	public HomeController(UserService userService)
	
	{
		this.userService=userService;
	}
	
	@GetMapping("/home")
	public String home(Model model,HttpSession session)
	{
		if(!userService.IsLoggedIn(session)) return "redirect:/login";
		return "home";
	}
	

}
