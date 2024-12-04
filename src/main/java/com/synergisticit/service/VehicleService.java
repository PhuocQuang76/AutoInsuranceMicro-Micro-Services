package com.synergisticit.service;

import com.synergisticit.domain.Vehicle;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VehicleService {
    public Vehicle saveVehicle(Vehicle vehicle);

    public List<Vehicle> findAll();

    public Vehicle findById(Long vehicleId);

    public Vehicle updateById(Long vehicleId);

    public Vehicle updateVehicle(Vehicle vehicle);

    public void deleteById(Long vehicleId);

    public Vehicle findByUsername(String username);
}
