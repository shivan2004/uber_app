package com.shivan.project.uber.uberApp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class RiderDTO {

    private Long id;
    private UserDTO user;
    private double rating;
}
