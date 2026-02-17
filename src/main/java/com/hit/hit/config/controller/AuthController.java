package com.hit.hit.config.controller;

import com.hit.hit.config.service.AuthService;
import com.hit.hit.model.AuthRequest;
import com.hit.hit.model.AuthResponse;
import com.hit.hit.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@CrossOrigin
@RestController
public class AuthController {


    @Autowired
    private AuthService authService;

    @PostMapping("/auth")
    public ResponseEntity<AuthResponse> createAuthenticationToken(@RequestBody AuthRequest authRequest) {
        try {
            String jwt = authService.authenticate(authRequest.getUsername(), authRequest.getPassword());
            return ResponseEntity.ok(new AuthResponse(jwt));
        } catch (Exception e) {
            return ResponseEntity.status(401).body(new AuthResponse("Invalid username or password"));
        }
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody Users authRequest) {
        try {
            authService.registerUser(authRequest.getUsername(), authRequest.getPassword(), authRequest.getFirstName(), authRequest.getLastName(), authRequest.getRole());
            return ResponseEntity.ok("User registered successfully");
        } catch (Exception e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }

    @GetMapping("/users/get-all")
    public List<Users> getUserDetails(){
        return authService.getAllUsers();
    }

}
