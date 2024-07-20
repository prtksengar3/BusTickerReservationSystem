package com.example.demo.Controller;

import com.example.demo.Request.LoginRequest;
import com.example.demo.Response.LoginResponse;
import com.example.demo.Service.Abstraction.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static com.example.demo.utils.Endpoints.LOGIN;

@Controller
@RestController
public class ApiController {

    @Autowired
    private LoginService loginService;

    @PostMapping(value = LOGIN)
    public LoginResponse login(@RequestBody LoginRequest loginRequest){
        return loginService.login(loginRequest);
    }
}
