package com.shivan.project.uber.uberApp.strategies.manager;

import com.shivan.project.uber.uberApp.strategies.DriverMatchingStrategy;
import com.shivan.project.uber.uberApp.strategies.RideFareCalculationStrategy;
import com.shivan.project.uber.uberApp.strategies.impl.driverMatching.DriverMatchingHighestRatedDriverStrategy;
import com.shivan.project.uber.uberApp.strategies.impl.driverMatching.DriverMatchingNearestDriverStrategy;
import com.shivan.project.uber.uberApp.strategies.impl.rideFare.RideFareSurgePricingFareCalculationStrategy;
import com.shivan.project.uber.uberApp.strategies.impl.rideFare.RiderFareDefaultFareCalculationStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Component
@RequiredArgsConstructor
public class RideStrategyManager {

    private final DriverMatchingHighestRatedDriverStrategy highestRatedDriverStrategy;
    private final DriverMatchingNearestDriverStrategy nearestDriverStrategy;

    private final RiderFareDefaultFareCalculationStrategy defaultFareCalculationStrategy;
    private final RideFareSurgePricingFareCalculationStrategy surgePricingFareCalculationStrategy;

    public DriverMatchingStrategy driverMatchingStrategy(double riderRating) {
        if(riderRating >= 4.8) return highestRatedDriverStrategy;
        else return nearestDriverStrategy;
    }

    public RideFareCalculationStrategy rideFareCalculationStrategy() {

        LocalTime surgeStartTime = LocalTime.of(18, 0);
        LocalTime surgeEndTime = LocalTime.of(21, 0);

        LocalTime currentTime = LocalTime.now();
        boolean isSurgeTime = currentTime.isAfter(surgeStartTime) && currentTime.isBefore(surgeEndTime);

        if(isSurgeTime) return surgePricingFareCalculationStrategy;
        else return defaultFareCalculationStrategy;

    }
}
