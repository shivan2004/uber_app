package com.shivan.project.uber.uberApp.services;

import com.shivan.project.uber.uberApp.dto.DriverDTO;
import com.shivan.project.uber.uberApp.dto.SignUpDTO;
import com.shivan.project.uber.uberApp.dto.UserDTO;

public interface AuthService {

    String login(String email, String password);

    UserDTO signUp(SignUpDTO signUpDTO);

    DriverDTO onboardNewDriver(Long userId, String vehicleId);

}
