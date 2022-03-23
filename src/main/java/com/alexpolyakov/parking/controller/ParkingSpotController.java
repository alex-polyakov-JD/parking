package com.alexpolyakov.parking.controller;

import com.alexpolyakov.parking.entity.ParkingSpot;
import com.alexpolyakov.parking.entity.ParkingSpotType;
import com.alexpolyakov.parking.service.ParkingSpotService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/spots")
@RequiredArgsConstructor(onConstructor = @__({@Autowired}))
public class ParkingSpotController {

    private final ParkingSpotService spotService;

    @GetMapping("/count")
    public Long getCount() {
        return spotService.count();
    }

    @GetMapping("/count/vacant")
    public Long getCountVacant() {
        return spotService.findVacant();
    }

    @GetMapping("/count/vacant/regular")
    public Long getCountVacantRegular() {
        return spotService.findVacantCountByType(ParkingSpotType.REGULAR);
    }

    @GetMapping("/count/vacant/handicap")
    public Long getCountVacantHandicap() {
        return spotService.findVacantCountByType(ParkingSpotType.HANDICAP);
    }

    @GetMapping("/list")
    public List<ParkingSpot> findAll() {
        return spotService.findAll();
    }

    @GetMapping("{id}")
    public ParkingSpot findById(@PathVariable Long id) {
        return spotService.findById(id);
    }

    @PostMapping
    public ParkingSpot save(@RequestBody ParkingSpot spot) {
        return spotService.save(spot);
    }

    @PutMapping("{id}")
    public void update(@PathVariable Long id, @RequestBody ParkingSpot spot) {
        spot.setId(id);
        spotService.save(spot);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        spotService.delete(id);
    }
}
