package com.example.demo.Service.Implementation;

import com.example.demo.Model.User;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Request.LoginRequest;
import com.example.demo.Response.LoginResponse;
import com.example.demo.Service.Abstraction.LoginService;
import io.micrometer.common.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Arrays;

@Service
@Slf4j
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        if(!validateRequest(loginRequest)){
            return new LoginResponse("Invalid Request",0);
        }
        String username = loginRequest.getUsername();
        User user = userRepository.findByUsername(username); // getting user details from database
        if (user != null) {
            String password = DigestUtils.md5DigestAsHex(loginRequest.getPassword().getBytes()); // converting password to md5

            if (user.getPassword().equals(password)) {
                return new LoginResponse(user.getUserId(),"success",1);
            }
            else{
                return new LoginResponse("Incorrect password",0);
            }
        }
        return new LoginResponse("User not found",0);
    }

    private boolean validateRequest(LoginRequest loginRequest) {
        if(StringUtils.isBlank(loginRequest.getUsername()) || StringUtils.isBlank(loginRequest.getPassword())){
            return false;
        }
        return true;
    }
}
