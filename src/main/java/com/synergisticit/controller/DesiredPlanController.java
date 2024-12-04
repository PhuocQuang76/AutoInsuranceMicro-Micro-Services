package com.synergisticit.controller;

import com.synergisticit.domain.DesiredPlan;
import com.synergisticit.domain.Driver;
import com.synergisticit.domain.Member;
import com.synergisticit.service.DesiredPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
public class DesiredPlanController {
    @Autowired
    DesiredPlanService desiredPlanService;

    @PostMapping("/saveDesiredPlan")
    public DesiredPlan saveDesiredPlan(@RequestBody DesiredPlan desiredPlan){
        String username = desiredPlan.getUsername();
        System.out.println("DesiredPlan username: "+username);
        DesiredPlan d = desiredPlanService.findByUsername(username);

        if(d == null){
            return desiredPlanService.saveDesiredPlan(desiredPlan);
        }else{

            desiredPlanService.deleteByIdDesiredPlan(d.getId());
            return desiredPlanService.saveDesiredPlan(desiredPlan);
        }

    }

    @GetMapping("/desiredPlans")
    public List<DesiredPlan> findAllDesiredPlans(){
        return desiredPlanService.findAllDesiredPlans();
    }

    @GetMapping("/desiredPlan/{desiredPlanId}")
    public DesiredPlan findByIdDesiredPlan(@PathVariable Long desiredPlanId) {
        return desiredPlanService.findById(desiredPlanId);
    }

    @DeleteMapping("/deleteDesiredPlan/desiredPlanId")
    public void deleteDesiredPlan(@PathVariable Long desiredPlanId){
        desiredPlanService.deleteByIdDesiredPlan(desiredPlanId);
    }

    @PutMapping("/updateDesiredPlan")
    public DesiredPlan updatedDesiredPlan(@RequestBody DesiredPlan desiredPlan){
        return desiredPlanService.update(desiredPlan);
    }

    @GetMapping("/desiredPlanByUsername/{username}")
    public DesiredPlan desiredPlanByUsername(@PathVariable String username){
        DesiredPlan desiredPlan = desiredPlanService.findByUsername(username);
        if(desiredPlan != null){
            return desiredPlan;
        }
        return null;
    }

}
