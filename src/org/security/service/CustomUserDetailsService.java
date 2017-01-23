package org.security.service;

import java.util.Collection;

import org.security.model.CustomGrantedAuthority;
import org.security.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailsService implements UserDetailsService {

	@SuppressWarnings("null")
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		UserServices userService = new UserServices();
		User user = userService.loadUserByUserName(username);
		
		String authority = user.getAuthority();
		String[] auths = authority.split(",");
		
		GrantedAuthority grantedAuthority = null;
		Collection<GrantedAuthority> grantedAuthorities = null;
		
		for(int i = 0;i<auths.length;i++){
			grantedAuthority = new CustomGrantedAuthority(auths[i]);
			grantedAuthorities.add(grantedAuthority);
		}
		
		user.setAuthorities(grantedAuthorities);
		
		return user;
	}

}
