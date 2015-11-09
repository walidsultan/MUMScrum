package com.webs.mumscrum.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webs.mumscrum.domain.Employee;
import com.webs.mumscrum.domain.EmployeeRole;
import com.webs.mumscrum.repository.EmployeeRepository;
import com.webs.mumscrum.service.HRSubsystemService;

@Service
@Transactional
public class HRSubsystemServiceImpl implements HRSubsystemService{

	@Autowired 
	EmployeeRepository employeeRepository;
	
	@Override
	public Employee getEmployeeById(Long id) {
		return employeeRepository.findOne(id);
	}

	@Override
	public void saveEmployee(Employee employee) {
		employeeRepository.save(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return (List<Employee>) employeeRepository.findAll();
	}

	@Override
	public List<Employee> getEmployeesByRole(Long role) {
		return employeeRepository.findEmployeesByRole(role);
	}

}
