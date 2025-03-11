package com.hexbee.usermanagement.serviceIMPL;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
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
	
		Optional<UserEntity> existingUser = userrepository.findByEmail(usersavedto.getEmail());
	       if (existingUser.isPresent()) {
             throw new DataIntegrityViolationException("Email already exists: " + usersavedto.getEmail());
        }
		
		UserEntity eco = new UserEntity();
		eco.setUsername(usersavedto.getUsername());
		eco.setPassword(passwordEncoder.encode(usersavedto.getPassword()));
		eco.setEmail(usersavedto.getEmail());
		eco.setPhone(usersavedto.getPhone());
		eco.setShopname(usersavedto.getShopname());
		eco.setGstNumber(usersavedto.getGstNumber());
		eco.setSignature(usersavedto.getSignature());
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
        UserEntity user = userrepository.findByUsername(username);
        
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                new ArrayList<>() // No roles/authorities
        );
    }

    @Override
	public UserEntity getUserByUsername(String username) {
	     return userrepository.findByUsername(username);
    }
 

}
