package org.security.auth.model;

import org.springframework.security.core.GrantedAuthority;

public class CustomGrantedAuthority implements GrantedAuthority {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String role_name;
	
	public CustomGrantedAuthority(String role_name){
		this.role_name = role_name;
	}

	@Override
	public String getAuthority() {
		return this.role_name;
	}

}
