package com.shivan.project.uber.uberApp.services;

import com.shivan.project.uber.uberApp.entities.Payment;
import com.shivan.project.uber.uberApp.entities.Ride;
import com.shivan.project.uber.uberApp.entities.enums.PaymentStatus;

public interface PaymentService {

    Payment createNewPayment(Ride ride);

    void processPayment(Ride ride);

}
