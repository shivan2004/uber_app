package com.shivan.project.uber.uberApp.strategies;

import com.shivan.project.uber.uberApp.dto.RideRequestDTO;


public interface RideFareCalculationStrategy {

    double calculateFare(RideRequestDTO rideRequestDTO);

}
