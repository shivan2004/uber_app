package com.shivan.project.uber.uberApp.services;

import org.locationtech.jts.geom.Point;

public interface DistanceService {

    double calculateDistance(Point source, Point dest);
}
