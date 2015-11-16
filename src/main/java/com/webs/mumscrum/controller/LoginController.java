package com.webs.mumscrum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.webs.mumscrum.service.HRSubsystemService;

@Controller
public class LoginController {

	@Autowired
	HRSubsystemService hrSubsystemService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}

	@RequestMapping(value = "/loginfailed", method = RequestMethod.GET)
	public String loginerror(Model model) {

		model.addAttribute("error", "true");
		return "login";

	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(Model model) {
		SecurityContextHolder.getContext().setAuthentication(null);
		return "redirect:/welcome";
	}

	@RequestMapping(value = "/postLogin", method = RequestMethod.POST)
	public String postLogin(String username, String password) {
		boolean isCorrect = hrSubsystemService.isCorrectUsernameAndPassword(username, password);
		if (isCorrect) {
			
			return "redirect:/welcome";
		} else {
			return "login";
		}
	}

}
