package com.example.springsecurityexample.demo.service;

import com.example.springsecurityexample.demo.entity.User;
import com.example.springsecurityexample.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GroupUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userOptional = userRepository.findByUserName(username);
        return userOptional.map(GroupUserDetails::new).orElseThrow(()-> new UsernameNotFoundException(username + " does not exist!"));
    }
}
