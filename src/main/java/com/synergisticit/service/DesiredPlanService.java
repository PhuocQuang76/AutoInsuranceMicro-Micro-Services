package com.synergisticit.service;

import com.synergisticit.domain.DesiredPlan;
import com.synergisticit.domain.Driver;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DesiredPlanService {
    public DesiredPlan saveDesiredPlan(DesiredPlan desiredPlan);

    public List<DesiredPlan> findAllDesiredPlans();

    public DesiredPlan findById(Long desiredPlanId);

    public DesiredPlan findByUsername(String username);

   public void deleteByIdDesiredPlan(Long desiredPlanId);

   public DesiredPlan update(DesiredPlan desiredPlan);


}
