package org.yodogi.learn.kata.spring.security;

import org.springframework.security.core.GrantedAuthority;

public class Role implements GrantedAuthority {
	private static final long serialVersionUID = 1L;

	public static String user_role = "ROLE_USER";

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthority() {
		return this.name;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Role [name=");
		builder.append(name);
		builder.append("]");
		return builder.toString();
	}

}
