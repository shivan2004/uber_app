package com.shivan.project.uber.uberApp.services;

import com.shivan.project.uber.uberApp.dto.DriverDTO;
import com.shivan.project.uber.uberApp.dto.RideDTO;
import com.shivan.project.uber.uberApp.dto.RiderDTO;

import java.util.List;

public interface DriverService {

    RideDTO acceptRide(Long rateId);

    RideDTO cancelRide(Long rideId);

    RideDTO startRide(Long rideId);

    RideDTO endRide(Long rideId);

    RiderDTO rateRider(Long rideId, Integer rating);

    DriverDTO getMyProfile();

    List<RideDTO> getAllMyRides();



}
