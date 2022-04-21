package com.dojo.BookClub.controllers;



import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.dojo.BookClub.models.Book;

import com.dojo.BookClub.services.BookService;
import com.dojo.BookClub.services.UserService;

@Controller
public class BookController 
{
	@Autowired
	private BookService bookService;
	@Autowired
	private UserService userService;
	
	public BookController
	(
			BookService bookService,
			UserService userService
	)
	{
			this.bookService=bookService;
			this.userService=userService;
	}
	
	@GetMapping("/book/new")
	public String book_new
	(
			@Valid @ModelAttribute("book") Book book,
			BindingResult res,
			Model model,
			HttpSession session
	)
	{
			if(!userService.IsLoggedIn(session)) return "redirect:/login";
			model.addAttribute("book",new Book());
			model.addAttribute("books",bookService.ReadAll());
			return"new_book";
	}
	
	@PostMapping("/book/new")
	public String book_create
	(
			@Valid @ModelAttribute("book") Book book,
			BindingResult res,
			Model model,
			HttpSession session
	)
	{
			if(!userService.IsLoggedIn(session)) return "redirect:/login";
			if(res.hasErrors())
			{
				model.addAttribute("books",bookService.ReadAll());
				return "new_book";
			}
			bookService.Create(book);
			return "redirect:/book";
	}
	
	@GetMapping("/book/{id}/delete")
	public String delete_book
	(
			Model model,
			@PathVariable("id") Long id,
			HttpSession session
	)
	{
		model.addAttribute("book",bookService.ReadOne(id));
		Book book = bookService.ReadOne(id);
		Long userId = (Long) session.getAttribute("user_id");
		Long adder = book.getUser().getId();
		System.out.println(userId);
		System.out.println(adder);
		if(userId != adder)
		{
			return "redirect:/book";
		} else {
		bookService.Delete(id);
		return "redirect:/book";
		}
	}
	
	@GetMapping("/book/{id}/edit")
	public String edit_book
	(
			@PathVariable("id") Long id,
			Model model,
			HttpSession session
	)
	{
		model.addAttribute("book",bookService.ReadOne(id));
		Book book=bookService.ReadOne(id);
		Long userId = (Long) session.getAttribute("user_id");
		Long adder = book.getUser().getId();
		System.out.println(userId);
		System.out.println(adder);
		if(userId != adder) 
		{
			return "redirect:/book";
		}else{
			return "edit_book";
		}
		
	}
	
	@PostMapping("/book/{id}/update")
	public String update_book
	(
			@Valid @ModelAttribute("book") Book book,
			BindingResult res,
			Model model,
			@PathVariable("id") Long id,
			HttpSession session
	)
	{
		if(res.hasErrors())
		{
			System.out.println("error in update_book");
			return "edit_book";
		}
		bookService.Update(book);
		return "redirect:/book";
		}
	
	@GetMapping("/book/{id}/details")
	public String book_details
	(
			@PathVariable("id") Long id,
			Model model,
			HttpSession session,
			Book book
	)
	{
		if(!userService.IsLoggedIn(session)) return "redirect:/login";
		model.addAttribute("book",bookService.ReadOne(id));
		model.addAttribute("user_name",session.getAttribute("user_name"));
		return "book_details";
	}
			
	

}
