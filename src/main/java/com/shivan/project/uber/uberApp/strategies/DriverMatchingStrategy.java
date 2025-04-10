package com.shivan.project.uber.uberApp.strategies;

import com.shivan.project.uber.uberApp.dto.RideRequestDTO;
import com.shivan.project.uber.uberApp.entities.Driver;

import java.util.List;

public interface DriverMatchingStrategy {
    List<Driver> findMatchingDriver(RideRequestDTO rideRequestDTO);
}
