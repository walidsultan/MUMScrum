package com.webs.mumscrum.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.webs.mumscrum.domain.Employee;
import com.webs.mumscrum.service.HRSubsystemService;

@Controller
@RequestMapping("/hrSubsystem/Employees")
public class EmployeesController {
	@Autowired
	HRSubsystemService hrSubsystemService;

	@RequestMapping(value = { "/", "" }, method = RequestMethod.GET)
	public String index(Model model) {

		model.addAttribute("employees", hrSubsystemService.getAllEmployees());

		return "employees";
	}

	@RequestMapping(value = { "/add" }, method = RequestMethod.GET)
	public String addForm(@ModelAttribute("newEmployee") Employee newEmployee, Model model) {
		return "employeesAdd";
	}

	@RequestMapping(value = { "/add" }, method = RequestMethod.POST)
	public String addSubmit(@ModelAttribute("newEmployee") @Valid Employee newEmployee, BindingResult result) {
		if(result.hasErrors()) {
			return "employeesAdd";
		}

		hrSubsystemService.saveEmployee(newEmployee);

		return "redirect:/employees";
	}

	@RequestMapping(value = { "/edit/{id}" }, method = RequestMethod.GET)
	public String editForm(@ModelAttribute("existingEmployee") Employee existingEmployee, Model model,
			@PathVariable("id") long id) {
		model.addAttribute("existingEmployee", hrSubsystemService.getEmployeeById(id));
		return "employeeEdit";
	}

	@RequestMapping(value = { "/edit/{id}" }, method = RequestMethod.POST)
	public String editSubmit(@ModelAttribute("existingEmployee") Employee existingEmployee, Model model,
			@PathVariable("id") long id) {
		Employee employee = hrSubsystemService.getEmployeeById(id);
		employee = existingEmployee;
		hrSubsystemService.saveEmployee(employee);
		return "redirect:/employees";
	}
		
}
