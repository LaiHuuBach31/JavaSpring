package com.project.service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.project.dao.UserDAO;
import com.project.entities.CustomUserDetails;
import com.project.entities.User;
import com.project.entities.UserRole;

@Service
public class CustomUserDetailService implements UserDetailsService {
	
	@Autowired
	private UserDAO userDAO;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return loadUser(username);
	}
	
	private UserDetails loadUser(String username) {
		User user = userDAO.findByUserName(username);

        if (user==null){
            return null;
        }
        
        Collection<GrantedAuthority> grantedAuthoritySet = new HashSet<>();

        Set<UserRole> roles = user.getUserRoles();
        
        for (UserRole account_Role : roles) {
        	grantedAuthoritySet.add(new SimpleGrantedAuthority(account_Role.getRole().getName()));
		}       
        
        return new CustomUserDetails(grantedAuthoritySet, user.getEmail(), user.getFullName(), user.getPassword(), user.getUserName(), user.getGender(), user.getAddress(), user.getTelephone(), user.getEnabled(),true,true,true);
	}
}
