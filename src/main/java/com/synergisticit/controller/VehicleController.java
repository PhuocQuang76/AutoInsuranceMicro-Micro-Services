package com.synergisticit.controller;

import com.synergisticit.domain.Driver;
import com.synergisticit.domain.Member;
import com.synergisticit.domain.Vehicle;
import com.synergisticit.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
public class VehicleController {
    @Autowired
    VehicleService vehicleService;
    @PostMapping("/saveVehicle")
    public Vehicle saveVehicle(@RequestBody Vehicle vehicle){
        String username = vehicle.getUsername();
        System.out.println("username: "+username);
        Vehicle v = vehicleService.findByUsername(username);

        if(v == null){
            return vehicleService.saveVehicle(vehicle);
        }else{
            vehicleService.deleteById(v.getId());
            return vehicleService.saveVehicle(vehicle);
        }
    }


    @GetMapping("/vehicles")
    public List<Vehicle> findAllVehicles(){
       return vehicleService.findAll();
    }

    @GetMapping("/vehicle/{vehicleId}")
    public Vehicle findByIdVehicle(@PathVariable Long vehicleId) {
        return vehicleService.findById(vehicleId);
    }

    @PutMapping("/updateVehicle")
    public Vehicle updateVehicle(@RequestBody Vehicle vehicle){
        return vehicleService.updateVehicle(vehicle);
    }

    @DeleteMapping("/deleteVehicle/{vehicleId}")
    public void deleteVehicle(Long vehicleId){
        vehicleService.deleteById(vehicleId);
    }

    @GetMapping("/vehicleByUsername/{username}")
    public Vehicle findByUsername(@PathVariable String username){
        return vehicleService.findByUsername(username);
    }

}
