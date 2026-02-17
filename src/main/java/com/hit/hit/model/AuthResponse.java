package com.hit.hit.model;

public class AuthResponse {
    private String jwt;

    // Constructor
    public AuthResponse() {}

    public AuthResponse(String jwt) {
        this.jwt = jwt;
    }

    // Getter
    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }
}
