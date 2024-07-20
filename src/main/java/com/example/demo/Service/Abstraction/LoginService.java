package com.example.demo.Service.Abstraction;

import com.example.demo.Request.LoginRequest;
import com.example.demo.Response.LoginResponse;

public interface LoginService {

    LoginResponse login(LoginRequest loginRequest);
}
