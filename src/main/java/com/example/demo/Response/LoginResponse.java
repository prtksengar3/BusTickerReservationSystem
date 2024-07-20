package com.example.demo.Response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class LoginResponse {

    @JsonProperty(value = "message")
    private String message;

    @JsonProperty(value = "response_code")
    private Integer responseCode;

    public LoginResponse(String message, Integer responseCode) {
        this.message = message;
        this.responseCode = responseCode;
    }
}
