package com.example.project.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.project.dtos.UserDTO;
import com.example.project.entity.User;
import com.example.project.repository.UserRepo;

@Service
public class UserService {
	
	@Autowired
	UserRepo userRepo;
	@Autowired
	private PasswordEncoder encoder;
	
	public User createUser(UserDTO dto) {
		User user = new User(dto.getUsername(),encoder.encode(dto.getPassword()),dto.getRole());
		return userRepo.save(user);
	}
	public List<User> getAllUser(){
		return userRepo.findAll();
	}
	

}
