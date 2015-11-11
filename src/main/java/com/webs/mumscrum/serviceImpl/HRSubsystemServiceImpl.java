package com.webs.mumscrum.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webs.mumscrum.domain.Employee;
import com.webs.mumscrum.domain.Role;
import com.webs.mumscrum.repository.EmployeeRepository;
import com.webs.mumscrum.service.HRSubsystemService;

@Service
@Transactional
public class HRSubsystemServiceImpl implements HRSubsystemService {

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

	@Override
	public boolean isCorrectUsernameAndPassword(String username, String password) {
		final Employee employee = employeeRepository.getEmployeeByUsername(username);
		if (employee == null) {
			return false;
		} else {
			if (employee.getPassword().equals(password)) {
				// set authorization
				List<GrantedAuthority> authority = new ArrayList<GrantedAuthority>();
				for (final Role role : employee.getRoles()) {
					GrantedAuthority grantedAuthority = new GrantedAuthority() {

						@Override
						public String getAuthority() {
							// TODO Auto-generated method stub
							return role.getName();
						}
					};
					authority.add(grantedAuthority);
				}
				Authentication authentication = new UsernamePasswordAuthenticationToken(employee,
						employee.getPassword(), authority);

				SecurityContextHolder.getContext().setAuthentication(authentication);
				return true;
			}
			return false;

		}
	}
}
