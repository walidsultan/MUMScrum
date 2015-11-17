package com.webs.mumscrum.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.webs.mumscrum.domain.Release;
import com.webs.mumscrum.domain.Sprint;
import com.webs.mumscrum.service.ReleaseService;
import com.webs.mumscrum.service.SprintService;

@Controller
@RequestMapping("/releases")
public class ReleasesController {

	@Autowired
	ReleaseService releaseService;
	
	@Autowired
	SprintService sprintService;

	@RequestMapping(value = { "/", "" }, method = RequestMethod.GET)
	public String index(Model model) {

		model.addAttribute("releases", releaseService.getAllReleases());

		return "releases";
	}

	@RequestMapping(value = { "/add" }, method = RequestMethod.GET)
	public String addForm(@ModelAttribute("newRelease") Release newRelease, Model model) {
		return "releaseAdd";
	}

	@RequestMapping(value = { "/add" }, method = RequestMethod.POST)
	public String addSubmit(@ModelAttribute("newRelease") @Valid Release newRelease, BindingResult result) {
		if(result.hasErrors()) {
			return "releaseAdd";
		}

		releaseService.saveRelease(newRelease);

		return "redirect:/releases";
	}

	@RequestMapping(value = { "/edit/{id}" }, method = RequestMethod.GET)
	public String editForm(@ModelAttribute("existingRelease") Release existingRelease, Model model,
			@PathVariable("id") long id) {
		model.addAttribute("existingRelease", releaseService.getReleaseById(id));
		return "releaseEdit";
	}

	@RequestMapping(value = { "/edit/{id}" }, method = RequestMethod.POST)
	public String editSubmit(@ModelAttribute("existingRelease") Release existingRelease, Model model,
			@PathVariable("id") long id) {
		Release release = releaseService.getReleaseById(id);
		release = existingRelease;
		releaseService.saveRelease(release);
		return "redirect:/releases";
	}
	

	@RequestMapping(value = { "/getSprints/{releaseId}" }, method = RequestMethod.GET)
	public @ResponseBody List<Sprint> getSprints(@PathVariable("releaseId") Long releaseId) {
		return sprintService.getSprintsByReleaseId(releaseId);
	}
	
	@RequestMapping(value = { "/delete/{id}" }, method = RequestMethod.GET)
	public String deleteRelease(@PathVariable("id") long id)
	{
		releaseService.deleteReleaseById(id);
		return "redirect:/releases";
	}
}
