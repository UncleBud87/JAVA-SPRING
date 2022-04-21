package com.dojo.BookClub.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.dojo.BookClub.models.User;
import com.dojo.BookClub.services.BookService;
import com.dojo.BookClub.services.UserService;


@Controller
public class RootController
{

	@Autowired
	private UserService userService;
	@Autowired
	private BookService bookService;
	
	
	public RootController
	(
			UserService userService,
			BookService bookService
	)
	{
			this.userService=userService;
			this.bookService=bookService;
	}
	
	
	
	@GetMapping("/")
	public String root_get(Model model)
	{
		return "redirect:/login";
	}
	
	@GetMapping("/book")
	public String show_book(Model model, HttpSession session, User user)

	{
		if(!userService.IsLoggedIn(session)) return "redirect:/login";
		model.addAttribute("book",bookService.ReadAll());
		model.addAttribute("books",bookService.ReadAll());
		model.addAttribute("user_name",session.getAttribute("user_name"));
		return "show_book";
		
	}
}
