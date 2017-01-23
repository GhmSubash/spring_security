package org.security.auth;

import org.security.service.CustomUserDetailsService;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

public class CustomAuthenticationProvider implements AuthenticationProvider {

	@Override
	public Authentication authenticate(Authentication auth) throws AuthenticationException {
		
		CustomUserDetailsService customUserDetailsService = new CustomUserDetailsService();
		String username = auth.getName();
		String password = auth.getCredentials().toString();
		
		return null;
	}

	@Override
	public boolean supports(Class<?> arg0) {
		return false;
	}

}
