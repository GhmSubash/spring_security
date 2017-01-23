package org.security.auth;

import org.security.service.CustomUserDetailsService;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomAuthenticationProvider implements AuthenticationProvider {

	private UserDetailsService customUserDetailsService = new CustomUserDetailsService();
	
	@Override
	public Authentication authenticate(Authentication auth) throws AuthenticationException {
		
		//CustomUserDetailsService customUserDetailsService = new CustomUserDetailsService();
		String username = auth.getName();
		String password = auth.getCredentials().toString();
		
	    UserDetails userDetails = customUserDetailsService.loadUserByUsername(username);
		
		if(userDetails==null){
			throw new UsernameNotFoundException("User does not exist in the system");
		}
		
		if(userDetails.getPassword().equals(password)){
			throw new UsernameNotFoundException("Password did not match");
		}
		
		UsernamePasswordAuthenticationToken newAuth = new UsernamePasswordAuthenticationToken(username, password,userDetails.getAuthorities());
		
		return newAuth;
	}

	@Override
	public boolean supports(Class<?> arg0) {
		return true;
	}

}
