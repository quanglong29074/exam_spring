package com.example.exam_spring.service;

import com.example.exam_spring.entity.Vehicle;
import com.example.exam_spring.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleService {
    @Autowired
    private VehicleRepository vehicleRepository;

    public List<Vehicle> findAll() {
        return vehicleRepository.findAll();
    }

    public Vehicle save(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    public void deleteById(int id) {
        vehicleRepository.deleteById(id);
    }

    public Optional<Vehicle> findById(int id) {
        return vehicleRepository.findById(id);
    }
}
