package com.webs.mumscrum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.webs.mumscrum.service.SprintService;
import com.webs.mumscrum.serviceImpl.SprintServiceImpl;

@Controller
public class SprintsController {

	@Autowired
	SprintService sprintService;

	@RequestMapping(value = {"/sprints"}, method = RequestMethod.GET)
	public String index(Model model){
		
		System.out.println(sprintService.getAllSprints().size());
		  model.addAttribute("sprints",sprintService.getAllSprints());
		  
		  return "sprints";
	}
}
