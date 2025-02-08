package com.hexbee.usermanagement.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexbee.usermanagement.Repository.UserRepository;
import com.hexbee.usermanagement.dto.UserRequestDTO;
import com.hexbee.usermanagement.dto.UserSaveDTO;
import com.hexbee.usermanagement.entity.UserEntity;
import com.hexbee.usermanagement.exceptionHandler.InvalidTokenException;
import com.hexbee.usermanagement.exceptionHandler.UnauthorizedAccessException;
import com.hexbee.usermanagement.security.JwtUtils;
//import com.hexbee.usermanagement.securityService.UserDetailsImpl;
import com.hexbee.usermanagement.service.UserService;
import jakarta.validation.Valid;

import org.springframework.security.core.context.SecurityContextHolder;

@RestController
@CrossOrigin
@RequestMapping("api/v1/ecommerce")
public class UserController {

	@Autowired
	UserService userservice;

	@Autowired
    private JwtUtils jwtUtil;
	

	@Autowired
	UserRepository userrepository;
	
	
	@Autowired
    private AuthenticationManager authenticationManager;

	@PostMapping(path="/register")
	public ResponseEntity<UserEntity> savestudent(@Valid @RequestBody UserSaveDTO usersavedto)
	{
		UserEntity id = userservice.AddUser(usersavedto);
	    return ResponseEntity.status(HttpStatus.CREATED).body(id);
	
	}
	
//	@PostMapping(path="/user/login")
//    public ResponseEntity<String> createlogin(@Valid @RequestBody UserRequestDTO userrequestdto)  {
//	
//		UserEntity user = userservice.createlogin(userrequestdto.getUsername(),userrequestdto.getPassword()) ;
//		if (user != null) {
//	    return ResponseEntity.ok("Login successful");
//	    } else {
//	    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
//	     }
//    } 
	
//    @PostMapping(path="/user/auth/login")
//    public ResponseEntity<?> createLogin(@Valid @RequestBody UserRequestDTO userrequestdto) {
//        try {
//            authenticationManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(userrequestdto.getUsername(), userrequestdto.getPassword())
//            );
//        } catch (BadCredentialsException e) {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(" Username or Password are Incorrect Please Check It");
//        }
//
//        final UserDetails userDetails = userservice.loadUserByUsername(userrequestdto.getUsername());
//        final String token = jwtUtil.generateToken(userDetails);
//
//        return ResponseEntity.ok(new JwtResponse(token));
//    }
    
	
	@PostMapping(path = "/user/auth/login")
	public ResponseEntity<?> createLogin(@Valid @RequestBody UserRequestDTO userRequestDTO) {
	
	    UserEntity userEntity = userrepository.findByUsername(userRequestDTO.getUsername());
	    if (userEntity == null) {
	        throw new UsernameNotFoundException("User not found with username: " + userRequestDTO.getUsername());
	    }

	  
	    authenticationManager.authenticate(
	        new UsernamePasswordAuthenticationToken(userRequestDTO.getUsername(), userRequestDTO.getPassword())
	    );

	  
	    final String token = jwtUtil.generateToken(
	        new org.springframework.security.core.userdetails.User(
	            userEntity.getUsername(), userEntity.getPassword(), new ArrayList<>()
	        )
	    );

	 
	    Map<String, Object> response = new LinkedHashMap<>();
	    response.put("timestamp", java.time.LocalDateTime.now());
	    response.put("status", 200);
	    response.put("success", true);
	    response.put("message", "Login successful");
	    response.put("token", token);
	    response.put("path", "/user/auth/login");

	    Map<String, Object> userDetailsMap = new LinkedHashMap<>();
	    userDetailsMap.put("id", userEntity.getId());
	    userDetailsMap.put("username", userEntity.getUsername());
	    userDetailsMap.put("password", userEntity.getPassword());
	    userDetailsMap.put("email", userEntity.getEmail());
	    userDetailsMap.put("phone", userEntity.getPhone());
	    userDetailsMap.put("shopName", userEntity.getShopname());
	    userDetailsMap.put("address", userEntity.getAddress());
	    userDetailsMap.put("isActive", userEntity.getIsActive());
	    userDetailsMap.put("createdAt", userEntity.getCreatedAt());
	    userDetailsMap.put("updatedAt", userEntity.getUpdatedAt());

	    response.put("data", userDetailsMap);

	    return ResponseEntity.ok(response);
	}

	  

	
	@GetMapping(path="/user/{username}")
	public ResponseEntity<UserEntity>User(@PathVariable("username")String username){
		UserEntity obj=userservice.User(username);
		return ResponseEntity.ok().body(obj);	
		
	
	}
	
	@GetMapping("/profile")
	public ResponseEntity<?> getUserProfile(@RequestHeader("Authorization") String token) {
	    if (token == null || !token.startsWith("Bearer ")) {
	        throw new InvalidTokenException("Invalid token format.");
	    }

	    String jwt = token.substring(7);
	    String username = jwtUtil.extractUsername(jwt);

	    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	    if (authentication == null || !authentication.isAuthenticated() || !authentication.getName().equals(username)) {
	        throw new UnauthorizedAccessException("Unauthorized: Invalid or expired token.");
	    }

	    UserEntity user = userservice.getUserByUsername(username);

	    Map<String, Object> response = new HashMap<>();
	    response.put("message", "Welcome " + user.getUsername() + "! You are authorized.");
	    response.put("userDetails", user);

	    return ResponseEntity.ok(response);
	}

}

	
	

