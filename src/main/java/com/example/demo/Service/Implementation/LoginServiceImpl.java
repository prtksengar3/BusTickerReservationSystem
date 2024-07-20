package com.example.demo.Service.Implementation;

import com.example.demo.Model.User;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Request.LoginRequest;
import com.example.demo.Response.LoginResponse;
import com.example.demo.Service.Abstraction.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        String username = loginRequest.getUsername();
        User user = userRepository.findByUsername(username);
        if (user != null) {
            String password = loginRequest.getPassword();
            if (user.getPassword().equals(password)) {
                return new LoginResponse("success",2);
            }
            else{
                return new LoginResponse("Incorrect password",2);
            }
        }
        return new LoginResponse("success",2);
    }
}
