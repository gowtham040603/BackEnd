package com.hexbee.usermanagement.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexbee.usermanagement.dto.JwtResponse;
import com.hexbee.usermanagement.dto.UserRequestDTO;
import com.hexbee.usermanagement.dto.UserSaveDTO;
import com.hexbee.usermanagement.entity.UserEntity;
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
    private AuthenticationManager authenticationManager;

	@PostMapping(path="/register")
	public UserEntity savestudent(@Valid @RequestBody UserSaveDTO usersavedto)
	{
		UserEntity id = userservice.AddUser(usersavedto);
	    return id;
	
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
	
    @PostMapping(path="/user/auth/login")
    public ResponseEntity<?> createLogin(@Valid @RequestBody UserRequestDTO userrequestdto) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(userrequestdto.getUsername(), userrequestdto.getPassword())
            );
        } catch (BadCredentialsException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }

        final UserDetails userDetails = userservice.loadUserByUsername(userrequestdto.getUsername());
        final String token = jwtUtil.generateToken(userDetails);

        return ResponseEntity.ok(new JwtResponse(token));
    }
    

	
	@GetMapping(path="/user/{username}")
	public ResponseEntity<UserEntity>User(@PathVariable("username")String username){
		UserEntity obj=userservice.User(username);
		return ResponseEntity.ok().body(obj);	
		
	
	}
	
	
	@GetMapping("/profile")
	public ResponseEntity<?> getUserProfile(@RequestHeader("Authorization") String token) {
	    try {
	        // Validate token format (must start with "Bearer ")
	        if (token == null || !token.startsWith("Bearer ")) {
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid token format.");
	        }

	        // Extract JWT token from "Bearer <token>"
	        String jwt = token.substring(7);
	        String username = jwtUtil.extractUsername(jwt);

	        // Validate authentication
	        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	        if (authentication == null || !authentication.isAuthenticated() ||
	            !authentication.getName().equals(username)) {
	            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unauthorized: Invalid or expired token.");
	        }

	        // Fetch user details from the database
	        UserEntity user = userservice.getUserByUsername(username);

	        // Create a custom response
	        Map<String, Object> response = new HashMap<>();
	        response.put("message", "Welcome " + user.getUsername() + "! You are authorized.");
	        response.put("userDetails", user);

	        return ResponseEntity.ok(response);

	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unauthorized: Invalid token.");
	    }
	}

	
}


	
	

