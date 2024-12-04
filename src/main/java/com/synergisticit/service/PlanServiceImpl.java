package com.synergisticit.service;

import com.synergisticit.domain.Plan;
import com.synergisticit.repository.PlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlanServiceImpl implements PlanService{
    @Autowired
    PlanRepository planRepository;

    @Override
    public List<Plan> findAll() {
        return planRepository.findAll();
    }

    @Override
    public Plan findById(Long id) {
        Optional<Plan> plan = planRepository.findById(id);
        if(plan != null){
            return plan.get();
        }
        return null;
    }

    @Override
    public Plan save(Plan plan) {
        return planRepository.save(plan);
    }
}
