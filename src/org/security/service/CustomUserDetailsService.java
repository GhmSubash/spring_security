package org.security.service;

import java.util.Collection;
import java.util.List;

import org.security.auth.model.CustomGrantedAuthority;
import org.security.auth.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailsService implements UserDetailsService {

	@SuppressWarnings("null")
	@Override
	public User loadUserByUsername(String username) throws UsernameNotFoundException {
		
		UserServices userService = new UserServices();
		User user = userService.loadUserByUserName(username);
		
		System.out.println("\n User Details");
		System.out.println("Username : "+user.getUsername());
		System.out.println("Password : "+user.getPassword());
		System.out.println("Authority : "+user.getAuthority());
		
		String authority = user.getAuthority();
		String[] auths = authority.split(",");
		
		GrantedAuthority grantedAuthority = null;
		List<GrantedAuthority> grantedAuthorities = null;
		
		for(int i = 0;i<auths.length;i++){
			System.out.println("Authority "+(i+1)+": "+auths[i]);
			grantedAuthority = new CustomGrantedAuthority(auths[i]);
			grantedAuthorities.add(grantedAuthority);
		}
		
		user.setAuthorities(grantedAuthorities);
		
		return user;
	}

}
