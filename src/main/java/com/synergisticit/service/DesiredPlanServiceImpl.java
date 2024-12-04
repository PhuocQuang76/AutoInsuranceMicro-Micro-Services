package com.synergisticit.service;

import com.synergisticit.domain.DesiredPlan;
import com.synergisticit.repository.DesiredPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DesiredPlanServiceImpl implements DesiredPlanService{
    @Autowired
    DesiredPlanRepository desiredPlanRepository;

    @Override
    public DesiredPlan saveDesiredPlan(DesiredPlan desiredPlan) {
        return desiredPlanRepository.save(desiredPlan);
    }

    @Override
    public List<DesiredPlan> findAllDesiredPlans() {
        return desiredPlanRepository.findAll();
    }

    @Override
    public DesiredPlan findById(Long desiredPlanId) {
        return null;
    }

    @Override
    public DesiredPlan findByUsername(String username) {
        return desiredPlanRepository.findByUsername(username);
    }

    @Override
    public void deleteByIdDesiredPlan(Long desiredPlanId) {
        desiredPlanRepository.deleteById(desiredPlanId);
    }

    @Override
    public DesiredPlan update(DesiredPlan desiredPlan) {
        return desiredPlanRepository.save(desiredPlan);
    }


}
