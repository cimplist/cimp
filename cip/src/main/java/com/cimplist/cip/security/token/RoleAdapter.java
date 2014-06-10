package com.cimplist.cip.security.token;

import org.springframework.security.core.GrantedAuthority;

public class RoleAdapter  implements GrantedAuthority{
	final String role;
	public RoleAdapter (String role) {
		this.role=role;
	}
	@Override
	public String getAuthority() {
		return role;
	}

}
