package com.webs.mumscrum.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.webs.mumscrum.domain.Sprint;
import com.webs.mumscrum.domain.UserStory;
import com.webs.mumscrum.service.SprintService;
import com.webs.mumscrum.service.UserStoryService;

@Controller
@RequestMapping("/userStories")
public class UserStoriesController {

	@Autowired
	UserStoryService userStoryService;
	
	@Autowired
	SprintService sprintService;

	@ModelAttribute("sprints")
	public List<Sprint> getSprints() {
		return sprintService.getAllSprints();
	}
	
	@RequestMapping(value = { "/", "" }, method = RequestMethod.GET)
	public String index(Model model) {

		model.addAttribute("userStories", userStoryService.getAllUserStories());

		return "userStories";
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
	}
	
}
