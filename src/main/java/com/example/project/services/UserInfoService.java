package com.example.project.services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.project.dtos.UserInfoDetails;
import com.example.project.entity.User;
import com.example.project.repository.UserRepo;

import java.util.List;
import java.util.Optional;

@Service
public class UserInfoService implements UserDetailsService {

    @Autowired
    private UserRepo repo;

   

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Optional<User> userDetail = repo.findByUsername(username); // Assuming 'email' is used as username
//
//        // Converting UserInfo to UserDetails
//        return org.springframework.security.core.userdetails.User.map(UserInfoDetails::new)
//                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
//    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repo.findByUsername(username)
                .map(user -> new org.springframework.security.core.userdetails.User(
                        user.getUsername(), // or getEmail() if that's what you're using
                        user.getPassword(), // must be BCrypt-encoded
                        List.of(new SimpleGrantedAuthority("ROLE_"+user.getRole())) // single role string
                ))
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
    }


   
}