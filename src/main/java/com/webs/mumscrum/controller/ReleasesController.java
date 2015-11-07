package com.webs.mumscrum.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.webs.mumscrum.domain.Release;
import com.webs.mumscrum.service.ReleaseService;

@Controller
@RequestMapping("/releases")
public class ReleasesController {

	@Autowired
	ReleaseService releaseService;

	@RequestMapping(value = { "/", "" }, method = RequestMethod.GET)
	public String index(Model model) {

		model.addAttribute("releases", releaseService.getAllReleases());

		return "releases";
	}

	@RequestMapping(value = { "/add" }, method = RequestMethod.GET)
	public String addForm(@ModelAttribute("newRelease") Release newRelease,Model model) {
		return "releaseAdd";
	}
	
	@RequestMapping(value = { "/add" }, method = RequestMethod.POST)
	public String addSubmit(@ModelAttribute("newRelease") @Valid Release newRelease, BindingResult result) {
		if(result.hasErrors()) {
			return "releaseAdd";
		}

		releaseService.addRelease(newRelease);
		return "redirect:/releases";
	}
}
