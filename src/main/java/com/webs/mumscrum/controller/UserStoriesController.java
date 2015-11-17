package com.webs.mumscrum.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.webs.mumscrum.domain.Employee;
import com.webs.mumscrum.domain.EmployeeRole;
import com.webs.mumscrum.domain.Sprint;
import com.webs.mumscrum.domain.UserStory;
import com.webs.mumscrum.service.HRSubsystemService;
import com.webs.mumscrum.service.SprintService;
import com.webs.mumscrum.service.UserStoryService;

@Controller
@RequestMapping("/userStories")
public class UserStoriesController {

	@Autowired
	UserStoryService userStoryService;
	
	@Autowired
	SprintService sprintService;

	@Autowired
	HRSubsystemService hrSubsystemService; 
	
	@ModelAttribute("sprints")
	public List<Sprint> getSprints() {
		return sprintService.getAllSprints();
	}
	
	@ModelAttribute("developers")
	public List<Employee> getDevelopers() {
		return hrSubsystemService.getEmployeesByRole(EmployeeRole.Developer.getValue());
	}
	
	@ModelAttribute("testers")
	public List<Employee> getTesters() {
		return hrSubsystemService.getEmployeesByRole(EmployeeRole.Tester.getValue());
	}
	
	@RequestMapping(value = { "/", "" }, method = RequestMethod.GET)
	public String index(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Employee employee=(Employee) auth.getPrincipal();
		Boolean isScrumMaster= hasAuthority(auth,EmployeeRole.ScrumMaster);
		Boolean isDeveloper= hasAuthority(auth,EmployeeRole.Developer);
		Boolean isTester= hasAuthority(auth,EmployeeRole.Tester);
		
		if (isScrumMaster) {
		model.addAttribute("userStories", userStoryService.getAllUserStories());
		}else if (isDeveloper) {
			model.addAttribute("userStories", userStoryService.getUserStoriesByDeveloperId(employee.getId()));
		}else if (isTester)
		{
			model.addAttribute("userStories", userStoryService.getUserStoriesByTesterId(employee.getId()));
		}
		return "userStories";
	}
	
	private boolean hasAuthority(Authentication auth, EmployeeRole role){
		for(GrantedAuthority ga: auth.getAuthorities()){
			if (ga.getAuthority().equals(role.toString()))
			{
				return true;
			}
		}
		return false;
	}

	@RequestMapping(value = { "/add" }, method = RequestMethod.GET)
	public String addForm(@ModelAttribute("newUserStory") UserStory newUserStory, Model model) {
		return "userStoryAdd";
	}

	@RequestMapping(value = { "/add" }, method = RequestMethod.POST)
	public String addSubmit(@ModelAttribute("newUserStory") @Valid UserStory newUserStory, BindingResult result) {
		if(result.hasErrors()) {
			return "userStoryAdd";
		}
		applyNullValues(newUserStory);
		
		userStoryService.saveUserStory(newUserStory);

		return "redirect:/userStories";
	}

	@RequestMapping(value = { "/edit/{id}" }, method = RequestMethod.GET)
	public String editForm(@ModelAttribute("existingUserStory") UserStory existingUserStory, Model model,
			@PathVariable("id") long id) {
		model.addAttribute("existingUserStory", userStoryService.getUserStoryById(id));
		return "userStoryEdit";
	}

	@RequestMapping(value = { "/edit/{id}" }, method = RequestMethod.POST)
	public String editSubmit(@ModelAttribute("existingUserStory") UserStory existingUserStory, Model model,
			@PathVariable("id") long id) {
		
		applyNullValues(existingUserStory);
		
		UserStory userStory = userStoryService.getUserStoryById(id);
		userStory = existingUserStory;
		userStoryService.saveUserStory(userStory);
		return "redirect:/userStories";
	}
	
	private void applyNullValues(UserStory userStory) {
		if(userStory.getSprint().getId()==null || userStory.getSprint().getId().equals(0L)){
			userStory.setSprint(null);
		}
		
		if(userStory.getDeveloper().getId()==null || userStory.getDeveloper().getId().equals(0L)){
			userStory.setDeveloper(null);
		}
		
		if(userStory.getTester().getId()==null || userStory.getTester().getId().equals(0L)){
			userStory.setTester(null);
		}
	}
	
	@RequestMapping(value = { "/delete/{id}" }, method = RequestMethod.GET)
	public String deleteUserStory(@PathVariable("id") long id)
	{
		userStoryService.deleteUserStoryById(id);
		return "redirect:/userStories";
	}
}
