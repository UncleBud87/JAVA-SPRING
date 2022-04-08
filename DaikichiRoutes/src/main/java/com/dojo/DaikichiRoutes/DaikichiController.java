package com.dojo.DaikichiRoutes;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/daikichi")
public class DaikichiController {
	@RequestMapping("")
	public String index() {
		return "Welcome!";
	}
	
	@RequestMapping("/search")
	public String index(@RequestParam(value="q", required=false) String searchQuery) {
		return"You searched for: " + searchQuery;
	}

	@RequestMapping(value="/today", method=RequestMethod.GET)
	public String today() {
		return "Today you will find luck in all your endeavors!";
	}
	
	@RequestMapping(value="/tomorrow", method=RequestMethod.GET)
	public String tomorrow() {
		return "Tomorrow, an opportunity will arise, so be sure to be open to new ideas!";
	}
	
	@RequestMapping("/travel/{track}")
	public String travel(@PathVariable("track") String track) {
		return "Congratulations! you will soon travel to " + track;
	}
	
	@RequestMapping("/lotto/{track}")
	public String lotto(@PathVariable("track") Integer track) {
		if(track % 2 == 0) {
			return "You will take a grand journey in the near future, but be weary of tempting offers.";
		}else {
		return "You have enjoyed the fruits of your labor but now is a great time to spend time with family and friends.";
		}
	}
}
