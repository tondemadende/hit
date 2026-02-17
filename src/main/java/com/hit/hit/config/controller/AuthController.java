package com.hit.hit.config.controller;

import com.hit.hit.config.service.AuthService;
import com.hit.hit.model.AuthRequest;
import com.hit.hit.model.AuthResponse;
import com.hit.hit.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<String> registerUser(@RequestBody User authRequest) {
        try {
            authService.registerUser(authRequest.getUsername(), authRequest.getPassword(), authRequest.getFirstName(), authRequest.getLastName(), authRequest.getRole());
            return ResponseEntity.ok("User registered successfully");
        } catch (Exception e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    @GetMapping("/auth/getUser/{userName}")
    public Optional<User> getUserDetails(@PathVariable String userName){
        return authService.getUserDetails(userName);
    }

    @GetMapping("/users/get-all")
    public List<User> getUserDetails(){
        return authService.getAllUsers();
    }

}
