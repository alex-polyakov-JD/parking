package com.alexpolyakov.parking.service;

import com.alexpolyakov.parking.entity.ParkingSensor;
import com.alexpolyakov.parking.exception.EntityNotFoundException;
import com.alexpolyakov.parking.repository.ParkingSensorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor(onConstructor = @__({@Autowired}))
public class ParkingSensorService {

    private final ParkingSensorRepository repository;

    public ParkingSensor save(ParkingSensor sensor) {
       return repository.save(sensor);
    }

    public ParkingSensor findById(Long id) {
        return repository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    public List<ParkingSensor> findAll() {
        return repository.findAll();
    }

    public boolean isOccupied(Long id) {
        return repository.findById(id)
                .orElseThrow(EntityNotFoundException::new)
                .isOccupied();
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Long count() {
        return repository.count();
    }
}
