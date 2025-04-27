package com.shivan.project.uber.uberApp.services.impl;
import com.shivan.project.uber.uberApp.services.DistanceService;
import lombok.Data;
import org.locationtech.jts.geom.Point;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;


@Data
class OSRMResponseDTO {
    private List<OSRMRoute> routes;
}

@Data
class OSRMRoute {
    private Double distance;
}

@Service
public class DistanceServiceOSRMImpl implements DistanceService {

    private static final String OSRM_API = "http://router.project-osrm.org/route/v1/driving/";

    @Override
    public double calculateDistance(Point source, Point dest) {

        String uri = source.getX() + "," + source.getY() + ";" + dest.getX() + "," + dest.getY();

        try {
            OSRMResponseDTO responseDTO = RestClient.builder()
                    .baseUrl(OSRM_API)
                    .build()
                    .get()
                    .uri(uri)
                    .retrieve()
                    .body(OSRMResponseDTO.class);
            return responseDTO.getRoutes().getFirst().getDistance() / 1000.0;

        } catch (Exception e) {
            throw new RuntimeException("Error getting data from OSRM, " + e.getMessage());
        }
    }

}
