package com.shivan.project.uber.uberApp.repositories;

import com.shivan.project.uber.uberApp.entities.Driver;
import com.shivan.project.uber.uberApp.entities.User;
import org.locationtech.jts.geom.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {

    Optional<Driver> findByUser(User user);

    @Query(
            value = "SELECT d.*, ST_Distance(d.current_location, :pickUpLocation) AS distance " +
            "FROM driver AS d " +
            "where available = true AND ST_DWithin(d.current_location, :pickUpLocation, 10000) " +
            "ORDER BY distance ASC " +
            "LIMIT 10", nativeQuery = true
    )

    List<Driver> findTenNearestDrivers(Point pickUpLocation);

    @Query(
            value = "SELECT d.* " +
                    "FROM driver d " +
                    "WHERE d.available = true AND ST_DWithin(d.current_location, :pickUpLocation, 15000) " +
                    "ORDER BY d.rating DESC " +
                    "LIMIT 10", nativeQuery = true
    )
    List<Driver> findTenNearbyTopRatedDrivers(Point pickUpLocation);

    Long id(Long id);
}
