package com.synergisticit.service;

import com.synergisticit.domain.Vehicle;
import com.synergisticit.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleServiceImpl implements VehicleService{
    @Autowired
    VehicleRepository vehicleRepository;
    @Override
    public Vehicle saveVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    @Override
    public List<Vehicle> findAll() {
        return vehicleRepository.findAll();
    }

    @Override
    public Vehicle findById(Long vehicleId) {
        Optional<Vehicle> vehicle =  vehicleRepository.findById(vehicleId);
        if(vehicle.isPresent()){
            return vehicle.get();
        }else{
            return null;
        }
    }

    @Override
    public Vehicle updateById(Long vehicleId) {
        return null;
    }

    @Override
    public Vehicle updateVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    @Override
    public void deleteById(Long vehicleId) {
        vehicleRepository.deleteById(vehicleId);
    }

    @Override
    public Vehicle findByUsername(String username) {
        return vehicleRepository.findByUsername(username);
    }
}
