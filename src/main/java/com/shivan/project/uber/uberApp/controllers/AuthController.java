package com.shivan.project.uber.uberApp.controllers;

import com.shivan.project.uber.uberApp.dto.SignUpDTO;
import com.shivan.project.uber.uberApp.dto.UserDTO;
import com.shivan.project.uber.uberApp.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signup")
    UserDTO signUp(@RequestBody SignUpDTO signUpDTO) {
        return authService.signUp(signUpDTO);
    }

}
