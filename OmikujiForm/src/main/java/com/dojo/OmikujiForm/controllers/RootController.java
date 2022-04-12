package com.dojo.OmikujiForm.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RootController {

	@GetMapping("/omikuji")
	public String index() 
	{
		
		return "index";
	}
	
	@RequestMapping(value="/omikuji", method=RequestMethod.POST)
	public String omikuji(HttpSession session,
		@RequestParam("number") Integer number,
		@RequestParam("city") String city,
		@RequestParam("person") String person,
		@RequestParam("hobby") String hobby,
		@RequestParam("thing") String thing,
		@RequestParam("somethingNice") String somethingNice
	) 
	{
		session.setAttribute("number", number);
		session.setAttribute("city", city);
		session.setAttribute("person", person);
		session.setAttribute("hobby", hobby);
		session.setAttribute("thing", thing);
		session.setAttribute("somethingNice", somethingNice);
		
		return "redirect:/show";
	}
	
	@RequestMapping("/show")
	public String submit(HttpSession session, Model model)
	{
		Integer number = (Integer) session.getAttribute("number");
		model.addAttribute("number", number);
		String city = (String) session.getAttribute("city");
		model.addAttribute("city", city);
		String person = (String) session.getAttribute("person");
		model.addAttribute("person", person);
		String hobby = (String) session.getAttribute("hobby");
		model.addAttribute("hobby", hobby);
		String thing = (String) session.getAttribute("thing");
		model.addAttribute("thing", thing);
		String somethingNice = (String) session.getAttribute("somethingNice");
		model.addAttribute("somethingNice", somethingNice);

		
		return "omikuji";
	}
	
	
};
