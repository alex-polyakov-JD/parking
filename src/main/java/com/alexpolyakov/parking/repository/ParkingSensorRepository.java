package com.alexpolyakov.parking.repository;

import com.alexpolyakov.parking.entity.ParkingSensor;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingSensorRepository extends GenericRepository<ParkingSensor, Long> {
}
