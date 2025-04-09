package com.shivan.project.uber.uberApp.dto;

import com.shivan.project.uber.uberApp.entities.Driver;
import com.shivan.project.uber.uberApp.entities.enums.PaymentMethod;
import com.shivan.project.uber.uberApp.entities.enums.RideStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.locationtech.jts.geom.Point;

import java.time.LocalDateTime;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class RideDTO {


    private Point pickupLocation;

    private Point dropOffLocation;

    private LocalDateTime createdTime;

    private RiderDTO rider;

    private DriverDTO driver;

    private PaymentMethod paymentMethod;

    private RideStatus rideRequestStatus;

    private Double fair;

    private LocalDateTime startedAt;

    private LocalDateTime endedAt;

}
