package com.shivan.project.uber.uberApp.strategies.impl;

import com.shivan.project.uber.uberApp.entities.Driver;
import com.shivan.project.uber.uberApp.entities.RideRequest;
import com.shivan.project.uber.uberApp.repositories.DriverRepository;
import com.shivan.project.uber.uberApp.strategies.DriverMatchingStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DriverMatchingNearestDriverStrategy implements DriverMatchingStrategy {

    private final DriverRepository driverRepository;

    @Override
    public List<Driver> findMatchingDrivers(RideRequest rideRequest) {
        return driverRepository.findTenNearestDrivers(rideRequest.getPickUpLocation());
    }
}
