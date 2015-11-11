package com.webs.mumscrum.domain;

public enum EmployeeRole {
	Developer(1L), ScrumMaster(2L), Tester(3L), HRAdmin(4L),NotDefined(19L);

	private final Long value;

	private EmployeeRole(Long value) {
		this.value = value;
	}

	public Long getValue() {
		return value;
	}
}
