package com.shivan.project.uber.uberApp.services;

import com.shivan.project.uber.uberApp.dto.DriverDTO;
import com.shivan.project.uber.uberApp.dto.RideDTO;
import com.shivan.project.uber.uberApp.dto.RideRequestDTO;
import com.shivan.project.uber.uberApp.dto.RiderDTO;
import com.shivan.project.uber.uberApp.entities.Driver;
import com.shivan.project.uber.uberApp.entities.Ride;
import com.shivan.project.uber.uberApp.entities.RideRequest;
import com.shivan.project.uber.uberApp.entities.Rider;
import com.shivan.project.uber.uberApp.entities.enums.RideStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface RideService {

    Ride getRideById(Long rideId);

    Ride createNewRide(RideRequest rideRequest, Driver driver);

    Ride updateRideStatus(Ride ride, RideStatus rideStatus);

    Page<Ride> getAllRidesOfRider(Rider rider, PageRequest pageRequest);

    Page<Ride> getAllRidesOfDriver(Driver driver, PageRequest pageRequest);

}

