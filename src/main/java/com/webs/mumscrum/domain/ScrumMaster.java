package com.webs.mumscrum.domain;

public class ScrumMaster extends Role {

	private static final long serialVersionUID = 1L;

	public ScrumMaster()
	{
		setId(EmployeeRole.ScrumMaster.getValue());
		setName(EmployeeRole.ScrumMaster.toString());
	}
	
	@Override
	public EmployeeRole getEmployeeRole() {
		return EmployeeRole.ScrumMaster;
	}

}
