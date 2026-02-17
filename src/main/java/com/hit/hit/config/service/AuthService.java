package com.hit.hit.config.service;

import com.hit.hit.Repository.UserRepository;
import com.hit.hit.config.JwtUtil;
import com.hit.hit.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class AuthService {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String authenticate(String username, String password) throws Exception {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password)
        );

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        return jwtUtil.generateToken(userDetails);
    }

    public void registerUser(String username, String password, String firstName, String lastName, int role) throws Exception {
        if (userRepository.findByUsername(username).isPresent()) {
            throw new Exception("Username already exists");
        }

        Users user = new Users();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password)); // Hash the password
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setRole(role);
        user.setEmail(username);
        userRepository.save(user);
    }

    public Optional<Users> getUserDetails(String username){
        return userRepository.findByUsername(username);
    }

    public List<Users> getAllUsers(){
        return userRepository.findAll();
    }
}
