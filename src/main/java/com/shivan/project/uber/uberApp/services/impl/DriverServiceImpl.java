package com.shivan.project.uber.uberApp.services.impl;

import com.shivan.project.uber.uberApp.dto.DriverDTO;
import com.shivan.project.uber.uberApp.dto.RideDTO;
import com.shivan.project.uber.uberApp.dto.RiderDTO;
import com.shivan.project.uber.uberApp.services.DriverService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverServiceImpl implements DriverService {

    @Override
    public RideDTO acceptRide(Long rateId) {
        return null;
    }

    @Override
    public RideDTO cancelRide(Long rideId) {
        return null;
    }

    @Override
    public RideDTO startRide(Long rideId) {
        return null;
    }

    @Override
    public RideDTO endRide(Long rideId) {
        return null;
    }

    @Override
    public RiderDTO rateRider(Long rideId, Integer rating) {
        return null;
    }

    @Override
    public DriverDTO getMyProfile() {
        return null;
    }

    @Override
    public List<RideDTO> getAllMyRides() {
        return List.of();
    }
}
