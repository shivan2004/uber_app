package com.shivan.project.uber.uberApp.services.impl;

import com.shivan.project.uber.uberApp.dto.DriverDTO;
import com.shivan.project.uber.uberApp.dto.SignUpDTO;
import com.shivan.project.uber.uberApp.dto.UserDTO;
import com.shivan.project.uber.uberApp.entities.Driver;
import com.shivan.project.uber.uberApp.entities.Rider;
import com.shivan.project.uber.uberApp.entities.User;
import com.shivan.project.uber.uberApp.entities.enums.Role;
import com.shivan.project.uber.uberApp.exceptions.ResourceNotFoundException;
import com.shivan.project.uber.uberApp.exceptions.RuntimeConflictException;
import com.shivan.project.uber.uberApp.repositories.UserRepository;
import com.shivan.project.uber.uberApp.services.AuthService;
import com.shivan.project.uber.uberApp.services.DriverService;
import com.shivan.project.uber.uberApp.services.RiderService;
import com.shivan.project.uber.uberApp.services.WalletService;
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
    private final WalletService walletService;
    private final DriverService driverService;

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
//                .orElseThrow(() -> new RuntimeConflictException("Cannot sign Up, User already exists with email : " + signUpDTO.getEmail()));

        User mappedUser = modelMapper.map(signUpDTO, User.class);
        mappedUser.setRoles(Set.of(Role.RIDER));
        User savedUser = userRepository.save(mappedUser);

        riderService.createNewRider(savedUser);
        walletService.createNewWallet(savedUser);

        return modelMapper.map(savedUser, UserDTO.class);
    }

    @Override
    public DriverDTO onboardNewDriver(Long userId, String vehicleId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id : " + userId));

        if(user.getRoles().contains(Role.DRIVER)) {
            throw new RuntimeConflictException("User with id : " + userId + " is already a driver");
        }

        Driver createDriver = Driver.builder()
                .user(user)
                .available(true)
                .rating(0.0)
                .vehicleId(vehicleId)
                .build();

        user.getRoles().add(Role.DRIVER);
        userRepository.save(user);

        Driver savedDriver = driverService.createNewDriver(createDriver);
        return modelMapper.map(savedDriver, DriverDTO.class);

    }

}
