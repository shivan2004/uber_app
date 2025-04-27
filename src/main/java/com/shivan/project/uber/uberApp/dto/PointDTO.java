package com.shivan.project.uber.uberApp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
public class PointDTO {
    private double[] coordinates;
    private String type = "Point";


    public PointDTO(double[] coordinates) {
        this.coordinates = coordinates;
    }
}
