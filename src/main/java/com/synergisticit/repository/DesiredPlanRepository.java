package com.synergisticit.repository;

import com.synergisticit.domain.DesiredPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DesiredPlanRepository extends JpaRepository<DesiredPlan, Long> {
    public DesiredPlan findByUsername(String username);
}
