package com.webs.mumscrum.domain;

public class HRAdmin extends Role{

	private static final long serialVersionUID = 1L;

	public HRAdmin()
	{
		setId(EmployeeRole.HRAdmin.getValue());
		setName(EmployeeRole.HRAdmin.toString());
	}
	
	@Override
	public EmployeeRole getEmployeeRole() {
		return EmployeeRole.HRAdmin;
	}

}
