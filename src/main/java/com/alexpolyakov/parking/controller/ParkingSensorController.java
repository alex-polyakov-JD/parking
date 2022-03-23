package com.alexpolyakov.parking.controller;

import com.alexpolyakov.parking.entity.ParkingSensor;
import com.alexpolyakov.parking.service.ParkingSensorService;
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
@RequestMapping("/sensors")
@RequiredArgsConstructor(onConstructor = @__({@Autowired}))
public class ParkingSensorController {

    private final ParkingSensorService sensorService;

    @GetMapping("/count")
    public Long getCount() {
        return sensorService.count();
    }

    @GetMapping("/list")
    public List<ParkingSensor> findAll() {
        return sensorService.findAll();
    }

    @GetMapping("/status/{id}")
    public boolean getStatus(@PathVariable Long id) {
        return sensorService.isOccupied(id);
    }

    @GetMapping("{id}")
    public ParkingSensor findById(@PathVariable Long id) {
        return sensorService.findById(id);
    }

    @PostMapping
    public ParkingSensor save(@RequestBody ParkingSensor sensor) {
        return sensorService.save(sensor);
    }

    @PutMapping("{id}")
    public void update(@PathVariable Long id, @RequestBody ParkingSensor sensor) {
        sensor.setId(id);
        sensorService.save(sensor);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        sensorService.delete(id);
    }
}
