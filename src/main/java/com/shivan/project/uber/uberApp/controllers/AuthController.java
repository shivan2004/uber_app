package com.shivan.project.uber.uberApp.controllers;

import com.shivan.project.uber.uberApp.dto.DriverDTO;
import com.shivan.project.uber.uberApp.dto.OnBoardDriverDTO;
import com.shivan.project.uber.uberApp.dto.SignUpDTO;
import com.shivan.project.uber.uberApp.dto.UserDTO;
import com.shivan.project.uber.uberApp.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<UserDTO> signUp(@RequestBody SignUpDTO signUpDTO) {
        return new ResponseEntity<>(authService.signUp(signUpDTO), HttpStatus.CREATED);
    }

    @PostMapping("/onBoardNewDriver/{userId}/{vehicleId}")
    public ResponseEntity<DriverDTO> onBoardNewDriver(@PathVariable Long userId,
                                                      @RequestBody OnBoardDriverDTO onBoardDriverDTO) {

        return new ResponseEntity<>(authService.onboardNewDriver(userId, onBoardDriverDTO.getVehicleId()), HttpStatus.CREATED);
    }

}
