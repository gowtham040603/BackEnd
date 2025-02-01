package com.hexbee.usermanagement.serviceIMPL;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.hexbee.usermanagement.Repository.UserRepository;
import com.hexbee.usermanagement.dto.UserSaveDTO;
import com.hexbee.usermanagement.entity.UserEntity;
import com.hexbee.usermanagement.service.UserService;

@Service
public class UserServiceIMPL implements UserService {

	@Autowired
	UserRepository userrepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public UserEntity AddUser(UserSaveDTO usersavedto) {
		UserEntity eco = new UserEntity();
		eco.setUsername(usersavedto.getUsername());
		eco.setPassword(passwordEncoder.encode(usersavedto.getPassword()));
		eco.setEmail(usersavedto.getEmail());
		eco.setPhone(usersavedto.getPhone());
		eco.setShopname(usersavedto.getShopname());
		eco.setAddress(usersavedto.getAddress());
			
		return userrepository.save(eco);
	}

	@Override
	public UserEntity createlogin(String username, String password) {
		
		UserEntity	user = userrepository.findByUsernameAndPassword(username,password);
		 if (user != null) { 
	            return user;
	        }
	        return null;
	}

	@Override
	public UserEntity User(String username) {
		return userrepository.findByUsername(username);
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	    // Retrieve the user from the database
		UserEntity user = userrepository.findByUsername(username);
	    if (user == null) {
	        throw new UsernameNotFoundException("User not found with username: " + username);
	    }

	    // Convert your User entity to UserDetails object, usually a custom UserDetails class
	    return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthorities(user));
	}

	private Collection<? extends GrantedAuthority> getAuthorities(UserEntity user) {
	    // This should map user roles to authorities
	    return AuthorityUtils.createAuthorityList(user.getPhone().toString());
	}

    @Override
	public UserEntity getUserByUsername(String username) {
	     return userrepository.findByUsername(username);
    }
 

}
