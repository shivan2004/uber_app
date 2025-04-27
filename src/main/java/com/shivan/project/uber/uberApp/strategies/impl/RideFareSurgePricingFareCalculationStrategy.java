package com.shivan.project.uber.uberApp.strategies.impl;

import com.shivan.project.uber.uberApp.entities.RideRequest;
import com.shivan.project.uber.uberApp.strategies.RideFareCalculationStrategy;
import org.springframework.stereotype.Service;

@Service
public class RideFareSurgePricingFareCalculationStrategy implements RideFareCalculationStrategy {

    @Override
    public double calculateFare(RideRequest rideRequest) {
        return 0;
    }
}
