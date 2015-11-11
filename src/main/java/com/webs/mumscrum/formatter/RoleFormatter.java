package com.webs.mumscrum.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;

import com.webs.mumscrum.domain.Developer;
import com.webs.mumscrum.domain.HRAdmin;
import com.webs.mumscrum.domain.Role;
import com.webs.mumscrum.domain.ScrumMaster;
import com.webs.mumscrum.domain.Tester;

public class RoleFormatter implements Formatter<Role> {

	@Override
	public String print(Role role, Locale locale) {
		return role.getName();
	}

	@Override
	public Role parse(String text, Locale locale) throws ParseException {

		switch (text.toLowerCase()) {
		case "developer":
			return new Developer();

		case "tester":
			return new Tester();

		case "scrummaster":
			return new ScrumMaster();

		case "hradmin":
			return new HRAdmin();

		default:
			break;
		}
		return null;
	}

}
