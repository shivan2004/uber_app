package com.shivan.project.uber.uberApp.services.impl;
import com.shivan.project.uber.uberApp.services.DistanceService;
import org.locationtech.jts.geom.Point;
import org.springframework.stereotype.Service;

@Service
public class DistanceServiceOSRMImpl implements DistanceService {

    @Override
    public double calculateDistance(Point source, Point dest) {
        return 0;
    }
}
