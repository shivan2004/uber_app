package com.shivan.project.uber.uberApp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class DriverDTO {

    private Long id;
    private UserDTO user;
    private double rating;
    private Boolean available;
    private String vehicleId;
}
