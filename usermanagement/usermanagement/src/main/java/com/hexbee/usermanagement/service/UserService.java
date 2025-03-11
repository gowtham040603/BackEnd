package com.hexbee.usermanagement.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.hexbee.usermanagement.dto.UserSaveDTO;
import com.hexbee.usermanagement.entity.UserEntity;
@Service
public interface UserService {

  public UserEntity AddUser(UserSaveDTO usersavedto);

  public UserEntity createlogin(String username, String password);

  public UserEntity User(String username);

  public UserDetails loadUserByUsername(String username);

 public UserEntity getUserByUsername(String username);







	

}
