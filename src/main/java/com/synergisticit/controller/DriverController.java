package com.synergisticit.controller;

import com.synergisticit.domain.Driver;
import com.synergisticit.domain.Member;
import com.synergisticit.service.DriverService;
import com.synergisticit.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
public class DriverController {
    @Autowired
    DriverService driverService;

    @Autowired
    MemberService memberService;

    @PostMapping("/saveDriver")
    public Driver saveDriver(@RequestBody Driver driver){
        String username = driver.getUsername();
        System.out.println("username: "+username);
        Driver d = driverService.findByUsername(username);

        System.out.println("menberSize: " + driver.getMembers().size());
        Member member = null;
        if(driver.getMembers() == null) {
            System.out.println("No member added.");
            return null;
        }else {
            for (Member m : driver.getMembers()) {
                member = memberService.save(m);
                System.out.println("MemberName: " + member.getFirstname());
            }
        }
        if(d == null) {
            return driverService.saveDriver(driver);
        }else {
            driverService.deleteByIdDriver(d.getId());
            return driverService.saveDriver(driver);
        }
    }


    @GetMapping("/drivers")
    public List<Driver> findAllDrivers(){
        return driverService.findAllDrivers();
    }

    @GetMapping("/driver/{driverId}")
    public Driver findByIdDriver(@PathVariable Long driverId) {
        return driverService.findById(driverId);
    }

    @PutMapping("/updateDriver")
    public Driver updateDriver(@RequestBody Driver driver){
        return driverService.updateDriver(driver);
    }

    @DeleteMapping("/deleteDriver/{driverId}")
    public void deleteDriver(Long driverId){

        driverService.deleteByIdDriver(driverId);
    }

    @GetMapping("/driverByUsername/{username}")
    public Driver findByUsername(@PathVariable String username){
        Driver driver = driverService.findByUsername(username);
        if(driver != null){
            return driver;
        }
        return null;
    }

}
