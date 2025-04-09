package com.shivan.project.uber.uberApp.dto;

import com.shivan.project.uber.uberApp.entities.Rider;
import com.shivan.project.uber.uberApp.entities.enums.PaymentMethod;
import com.shivan.project.uber.uberApp.entities.enums.RideRequestStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.locationtech.jts.geom.Point;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class RideRequestDTO {

    private Point pickupLocation;

    private Point dropOffLocation;

    private LocalDateTime requestedTime;

    private Rider rider;

    private PaymentMethod paymentMethod;

    private RideRequestStatus rideRequestStatus;



}
