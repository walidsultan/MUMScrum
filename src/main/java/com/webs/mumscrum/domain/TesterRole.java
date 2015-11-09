package com.webs.mumscrum.domain;

public class TesterRole extends Role{

	private static final long serialVersionUID = 1L;

	@Override
	public EmployeeRole getEmployeeRole() {
		return EmployeeRole.Tester;
	}

}
