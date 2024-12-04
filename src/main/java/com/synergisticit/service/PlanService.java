package com.synergisticit.service;

import com.synergisticit.domain.Plan;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PlanService {
    public List<Plan> findAll();

    Plan findById(Long id);

    Plan save(Plan plan);



}
