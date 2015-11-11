package com.webs.mumscrum.domain;

public class Tester extends Role{

	private static final long serialVersionUID = 1L;

	public Tester()
	{
		setId(EmployeeRole.Tester.getValue());
		setName(EmployeeRole.Tester.toString());
	}
	
	@Override
	public EmployeeRole getEmployeeRole() {
		return EmployeeRole.Tester;
	}

}
