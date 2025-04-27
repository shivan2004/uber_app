package com.shivan.project.uber.uberApp.services.impl;

import com.shivan.project.uber.uberApp.dto.DriverDTO;
import com.shivan.project.uber.uberApp.dto.SignUpDTO;
import com.shivan.project.uber.uberApp.dto.UserDTO;
import com.shivan.project.uber.uberApp.entities.Rider;
import com.shivan.project.uber.uberApp.entities.User;
import com.shivan.project.uber.uberApp.entities.enums.Role;
import com.shivan.project.uber.uberApp.exceptions.RuntimeConflictException;
import com.shivan.project.uber.uberApp.repositories.UserRepository;
import com.shivan.project.uber.uberApp.services.AuthService;
import com.shivan.project.uber.uberApp.services.RiderService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    private final RiderService riderService;

    @Override
    public String login(String email, String password) {
        return "";
    }

    @Override
    @Transactional
    public UserDTO signUp(SignUpDTO signUpDTO) {
        User user = userRepository.findByEmail(signUpDTO.getEmail()).orElse(null);
        if(user != null) {
            throw new RuntimeConflictException("Cannot signup, User already exists with email : " + signUpDTO.getEmail());
        }
//        userRepository.findByEmail(signUpDTO.getEmail())
//                .orElseThrow(() -> new RuntimeConflictException("Cannot signUp, User already exists with email : " + signUpDTO.getEmail()));

        User mappedUser = modelMapper.map(signUpDTO, User.class);
        mappedUser.setRoles(Set.of(Role.RIDER));
        User savedUser = userRepository.save(mappedUser);

        Rider savedRider = riderService.createNewRider(savedUser);

        //todo: add walled related service here

        return modelMapper.map(savedUser, UserDTO.class);
    }

    @Override
    public DriverDTO onboardNewDriver(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow();
        user.getRoles().add(Role.DRIVER);
        User savedUser = userRepository.save(user);
        return null;
    }

}
