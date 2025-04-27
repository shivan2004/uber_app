package com.shivan.project.uber.uberApp.services;

import com.shivan.project.uber.uberApp.entities.RideRequest;

public interface RideRequestService {

    RideRequest findRideRequestById(Long rideRequestId);
    void update(RideRequest rideRequest);
}
