package com.alexpolyakov.parking.repository;

import com.alexpolyakov.parking.entity.ParkingSpot;
import com.alexpolyakov.parking.entity.ParkingSpotType;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingSpotRepository extends GenericRepository<ParkingSpot, Long> {

    @Query(value = "SELECT COUNT(*) FROM parking_spot " +
            "JOIN parking_sensor " +
            "ON parking_sensor.occupied = false " +
            "AND parking_spot.parking_type = :#{#type?.name()} " +
            "AND parking_spot.id = parking_sensor.id",
            nativeQuery = true)
    Long findVacantCountByType(@Param("type") ParkingSpotType type);

    @Query(value = "SELECT COUNT(*) FROM parking_spot " +
            "JOIN parking_sensor " +
            "ON parking_sensor.occupied = false " +
            "AND parking_spot.id = parking_sensor.id",
            nativeQuery = true)
    Long findVacant();
}
