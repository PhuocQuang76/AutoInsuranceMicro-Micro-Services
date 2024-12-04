package com.synergisticit.service;

import com.synergisticit.domain.Driver;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DriverService {
    public Driver saveDriver(Driver driver);

    public List<Driver> findAllDrivers();

    public Driver findById(Long driverId);

    public Driver updateByIdDriver(Long driverId);

    public Driver updateDriver(Driver driver);

    public void deleteByIdDriver(Long driverId);

    public Driver findByUsername(String username);

    public void deleteByUsername(String username);
}
