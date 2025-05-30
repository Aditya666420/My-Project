package com.example.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.project.dtos.LoginDTO;
import com.example.project.dtos.UserDTO;
import com.example.project.entity.User;
import com.example.project.services.JwtService;
import com.example.project.services.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	UserService service;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtService jwtService;

	@PostMapping("/register")
	public User create(@RequestBody UserDTO dto) {

		return service.createUser(dto);

	}

	@GetMapping("/all")
	public List<User> getAll() {
		return service.getAllUser();
	}

	@GetMapping("/hello")
	public String hello() {
		return "Hi";

	}

	@PostMapping("/login")
	public String authenticateAndGetToken(@RequestBody LoginDTO authRequest) {
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
		if (authentication.isAuthenticated()) {
			return jwtService.generateToken(authRequest.getUsername());
		} else {
			throw new UsernameNotFoundException("Invalid user request!");
		}

	}
}
