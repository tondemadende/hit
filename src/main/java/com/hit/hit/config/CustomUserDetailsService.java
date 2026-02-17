package com.hit.hit.config;


import com.hit.hit.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.hit.hit.model.User;


@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Implement your user fetching logic here
        // For example, fetching from a database
//        return null; // Replace with actual UserDetails object
        User user = userRepository.findByUsername(username)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User not found"));

        return org.springframework.security.core.userdetails.User
                .withUsername(user.getUsername())
                .password(user.getPassword())
                .authorities(mapRole(user.getRole()))
                .build();
    }
    private String mapRole(int role) {
        // adapt to your system
        return switch (role) {
            case 1 -> "ROLE_ADMIN";
            default -> "ROLE_USER";
        };
    }
}
