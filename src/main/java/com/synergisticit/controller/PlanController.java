package com.synergisticit.controller;

import com.synergisticit.domain.Plan;
import com.synergisticit.dto.PlanDto;
import com.synergisticit.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlanController {
    @Autowired
    PlanService planService;


    @PostMapping("/plan/save")
    public Plan saveAutoPlan(@RequestBody Plan plan){
        return planService.save(plan);

    }

    @GetMapping("/plans")
    public List<Plan> getAllPlans(){
        return planService.findAll();

    }

    @GetMapping("/plan/{id}")
    public Plan findById(@PathVariable Long id){
        Plan plan = planService.findById(id);
        return plan;
    }
}
