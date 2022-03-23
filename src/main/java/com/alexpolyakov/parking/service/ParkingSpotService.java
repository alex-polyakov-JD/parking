package com.alexpolyakov.parking.service;

import com.alexpolyakov.parking.entity.ParkingSpot;
import com.alexpolyakov.parking.entity.ParkingSpotType;
import com.alexpolyakov.parking.exception.EntityNotFoundException;
import com.alexpolyakov.parking.repository.ParkingSpotRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor(onConstructor = @__({@Autowired}))
public class ParkingSpotService {

    private final ParkingSpotRepository repository;

    public ParkingSpot save(ParkingSpot spot) {
        return repository.save(spot);
    }

    public ParkingSpot findById(Long id) {
        return repository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    public List<ParkingSpot> findAll() {
        return repository.findAll();
    }

    public Long findVacant() {
        return repository.findVacant();
    }

    public Long findVacantCountByType(ParkingSpotType type) {
        return repository.findVacantCountByType(type);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Long count() {
        return repository.count();
    }
}
