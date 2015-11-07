package com.webs.mumscrum.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.webs.mumscrum.domain.Sprint;
import com.webs.mumscrum.service.SprintService;

@Controller
@RequestMapping("/sprints")
public class SprintsController {

	@Autowired
	SprintService sprintService;

	@RequestMapping(value = { "/", "" }, method = RequestMethod.GET)
	public String index(Model model) {

		System.out.println(sprintService.getAllSprints().size());
		model.addAttribute("sprints", sprintService.getAllSprints());

		return "sprints";
	}

	@RequestMapping(value = { "/add" }, method = RequestMethod.GET)
	public String addForm(@ModelAttribute("newSprint") Sprint newSprint,Model model) {
		return "sprintAdd";
	}
	
	@RequestMapping(value = { "/add" }, method = RequestMethod.POST)
	public String addSubmit(@ModelAttribute("newSprint") @Valid Sprint newSprint, BindingResult result) {
		if(result.hasErrors()) {
			return "sprintAdd";
		}

		sprintService.addSprint(newSprint);
		return "redirect:/sprints";
	}
}
