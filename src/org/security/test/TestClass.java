package org.security.test;

import org.security.auth.CustomAuthentication;
import org.security.auth.CustomAuthenticationProvider;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;

public class TestClass {
	
	public static void main(String[] sargs){
		
		String username = "subash048";
		String password = "ghimire";
		
		Authentication authentication = new CustomAuthentication(username,password);
		AuthenticationProvider authenticationProvider = new CustomAuthenticationProvider();
		authenticationProvider.authenticate(authentication);
		
	}
	

}
