package com.webs.mumscrum.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.webs.mumscrum.domain.Employee;
import com.webs.mumscrum.domain.EmployeeRole;
import com.webs.mumscrum.domain.Release;
import com.webs.mumscrum.domain.Sprint;
import com.webs.mumscrum.service.HRSubsystemService;
import com.webs.mumscrum.service.ReleaseService;
import com.webs.mumscrum.service.SprintService;

@Controller
@RequestMapping("/sprints")
public class SprintsController {

	@Autowired
	SprintService sprintService;

	@Autowired
	ReleaseService releaseService;

	@Autowired
	HRSubsystemService hrSubsystemService;

	@ModelAttribute("releases")
	public List<Release> getReleases() {
		return releaseService.getAllReleases();
	}

	@ModelAttribute("scrumMasters")
	public List<Employee> getScrumMaster() {
		return hrSubsystemService.getEmployeesByRole(EmployeeRole.ScrumMaster.getValue());
	}

	@RequestMapping(value = { "/", "" }, method = RequestMethod.GET)
	public String index(Model model) {
		model.addAttribute("sprints", sprintService.getAllSprints());

		return "sprints";
	}

	@RequestMapping(value = { "/add" }, method = RequestMethod.GET)
	public String addForm(@ModelAttribute("newSprint") Sprint newSprint, Model model) {
		return "sprintAdd";
	}

	@RequestMapping(value = { "/add" }, method = RequestMethod.POST)
	public String addSubmit(@ModelAttribute("newSprint") @Valid Sprint newSprint, BindingResult result) {
		if (result.hasErrors()) {
			return "sprintAdd";
		}
		
		applyNullValues(newSprint);
		
		sprintService.saveSprint(newSprint);
		return "redirect:/sprints";
	}

	@RequestMapping(value = { "/edit/{id}" }, method = RequestMethod.GET)
	public String editForm(@ModelAttribute("existingSprint") Sprint existingSprint, Model model,
			@PathVariable("id") long id) {

		model.addAttribute("existingSprint", sprintService.getSprintById(id));
		return "sprintEdit";
	}

	@RequestMapping(value = { "/edit/{id}" }, method = RequestMethod.POST)
	public String editSubmit(@ModelAttribute("existingSprint") Sprint existingSprint, Model model,
			@PathVariable("id") long id, BindingResult result) {
		
		if (result.hasErrors()) {
			return "sprintEdit";
		}

		applyNullValues(existingSprint);
		
		Sprint sprint = sprintService.getSprintById(id);
		sprint = existingSprint;
		sprintService.saveSprint(sprint);
		return "redirect:/sprints";
	}

	private void applyNullValues(Sprint existingSprint) {
		if(existingSprint.getScrumRelease().getId()==null || existingSprint.getScrumRelease().getId().equals(0L)){
			existingSprint.setScrumRelease(null);
		}
		if(existingSprint.getScrumMaster().getId()==null|| existingSprint.getScrumMaster().getId().equals(0L)){
			existingSprint.setScrumMaster(null);
		}
	}
}
