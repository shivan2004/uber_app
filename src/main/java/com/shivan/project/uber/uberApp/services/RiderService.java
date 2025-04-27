package com.shivan.project.uber.uberApp.services;

import com.shivan.project.uber.uberApp.dto.DriverDTO;
import com.shivan.project.uber.uberApp.dto.RideDTO;
import com.shivan.project.uber.uberApp.dto.RideRequestDTO;
import com.shivan.project.uber.uberApp.dto.RiderDTO;
import com.shivan.project.uber.uberApp.entities.Rider;
import com.shivan.project.uber.uberApp.entities.User;

import java.util.List;

public interface RiderService {

    RideRequestDTO requestRide(RideRequestDTO rideRequestDTO);

    RideDTO cancelRide(Long rideId);

    DriverDTO rateDriver(Long rideId, Integer rating);

    RiderDTO getMyProfile();

    List<RideDTO> getAllMyRides();

    Rider createNewRider(User user);

}
