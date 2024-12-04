package com.synergisticit.service;

import com.synergisticit.domain.Driver;
import com.synergisticit.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DriverServiceImpl implements DriverService {
    @Autowired
    DriverRepository driverRepository;

    @Override
    public Driver saveDriver(Driver driver) {
        Driver d = findByUsername(driver.getUsername());
        if(d == null){
            driverRepository.save(driver);
        }else{
            driverRepository.deleteById(d.getId());
            driverRepository.save(driver);
        }
        return driver;
    }

    @Override
    public List<Driver> findAllDrivers() {
        return driverRepository.findAll();
    }

    @Override
    public Driver findById(Long driverId) {
        Optional<Driver> d =  driverRepository.findById(driverId);
        if(d.isPresent()){
            return d.get();
        }
        return null;
    }

    @Override
    public Driver updateByIdDriver(Long driverId) {
       return  null;
    }

    @Override
    public Driver updateDriver(Driver driver) {
        return driverRepository.save(driver);
    }

    @Override
    public void deleteByIdDriver(Long driverId) {
        driverRepository.deleteById(driverId);
    }

    @Override
    public Driver findByUsername(String username) {
        return driverRepository.findByUsername(username);
    }

    @Override
    public void deleteByUsername(String username) {

    }
}
