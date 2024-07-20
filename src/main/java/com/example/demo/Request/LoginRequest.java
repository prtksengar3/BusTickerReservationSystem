package com.example.demo.Request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class LoginRequest {
    @JsonProperty(value = "username")
    private String username;
    @JsonProperty(value = "password")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LoginRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
