package com.webs.mumscrum.domain;

public class Developer extends Role {

	private static final long serialVersionUID = 1L;

	public Developer()
	{
		setId(EmployeeRole.Developer.getValue());
		setName(EmployeeRole.Developer.toString());
	}

	@Override
	public EmployeeRole getEmployeeRole() {
		return EmployeeRole.Developer;
	}
}
