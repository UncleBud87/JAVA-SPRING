package com.dojo.BeltExam.controllers;


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

import com.dojo.BeltExam.models.Song;
import com.dojo.BeltExam.services.SongService;
import com.dojo.BeltExam.services.UserService;


@Controller
public class SongController 
{
	@Autowired
	private SongService songService;
	@Autowired
	private UserService userService;
	
	public SongController
	(
			SongService songService,
			UserService userService
	)
	{
		this.songService=songService;
		this.userService=userService;
	}
	
	@GetMapping("/songs/new")
	public String song_new
	(
			@Valid @ModelAttribute("song") Song song,
			BindingResult res,
			Model model,
			HttpSession session
	)
	{
		if(!userService.IsLoggedIn(session)) return "redirect:/login";
		model.addAttribute("song",new Song());
		model.addAttribute("songs",songService.ReadAll());
		return"new_song";
	}
	
	@PostMapping("/songs/new")
	public String book_create
	(
			@Valid @ModelAttribute("song") Song song,
			BindingResult res,
			Model model,
			HttpSession session
	)
	{
			if(!userService.IsLoggedIn(session)) return "redirect:/login";
			if(res.hasErrors())
			{
				model.addAttribute("songs",songService.ReadAll());
				return "new_song";
			}
			songService.Create(song);
			return "redirect:/home";
	}
	
	@GetMapping("/songs/{id}")
	public String song_details
	(
			@PathVariable("id") Long id,
			Model model,
			HttpSession session,
			Song song
	)
	{
		if(!userService.IsLoggedIn(session)) return "redirect:/login";
		model.addAttribute("song",songService.ReadOne(id));
		model.addAttribute("user_name",session.getAttribute("user_name"));
		return "song_details";
	}
	
	@GetMapping("/songs/{id}/edit")
	public String edit_song
	(
			@PathVariable("id") Long id,
			Model model,
			HttpSession session
	)
	{
		model.addAttribute("song",songService.ReadOne(id));
		model.addAttribute("user_name",session.getAttribute("user_name"));
		return "edit_song";
	}
	
	@PostMapping("/songs/{id}/update")
	public String update_book
	(
			@Valid @ModelAttribute("song") Song song,
			BindingResult res,
			Model model,
			@PathVariable("id") Long id,
			HttpSession session
	)
	{
		if(res.hasErrors())
		{
			System.out.println("error in update_book");
			return "edit_song";
		}
		model.addAttribute("song",songService.ReadOne(id));
		model.addAttribute("songs", songService.ReadAll());
		songService.Update(song);
		return "redirect:/home";
	}
	
	@GetMapping("/songs/{id}/delete")
	public String delete_song
	(
			Model model,
			@PathVariable("id") Long id,
			HttpSession session
	)
	{
		model.addAttribute("song",songService.ReadOne(id));
		Song song = songService.ReadOne(id);
		Long userId = (Long) session.getAttribute("user_id");
		Long adder = song.getUser().getId();
		System.out.println(userId);
		System.out.println(adder);
		if(userId != adder)
		{
			return "redirect:/songs/{id}/edit";
		} else {
		songService.Delete(id);
		return "redirect:/home";
		}
	}

}
