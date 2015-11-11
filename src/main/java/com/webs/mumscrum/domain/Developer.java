package com.webs.mumscrum.domain;

public class Developer extends Role {

	
	private static final long serialVersionUID = 1L;

	@Override
	public EmployeeRole getEmployeeRole() {
		return EmployeeRole.Developer;
	}
}
