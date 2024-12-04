package com.synergisticit.dto;

import com.synergisticit.domain.DesiredPlan;
import com.synergisticit.domain.Plan;
import com.synergisticit.domain.Policy;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PlanDto implements Serializable {

    @Id
    private Long planId;

    private String name;
    private String planType;

    private String description;

    private DesiredPlan desiredPlan;

//    @JsonIgnore
    List<PolicyDto> policies = new ArrayList<>();

    public PlanDto() {
    }

    public PlanDto(Plan plan) {
        this.planId = plan.getPlanId();
        this.name = plan.getName();
        this.planType = plan.getPlanType();
        this.description = plan.getDescription();
        for (Policy policy : plan.getPolicies()) {
            this.policies.add(new PolicyDto(policy.getId(), policy.getName(), policy.getPlans()));
        }
    }

    public PlanDto(Long planId, String name, String planType, String description, List<PolicyDto> policies) {
        this.planId = planId;
        this.name = name;
        this.planType = planType;
        this.description = description;
        this.policies = policies;
    }

    public Long getPlanId() {
        return planId;
    }

    public void setPlanId(Long planId) {
        this.planId = planId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlanType() {
        return planType;
    }

    public void setPlanType(String planType) {
        this.planType = planType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<PolicyDto> getPolicies() {
        return policies;
    }

    public void setPolicies(List<PolicyDto> policies) {
        this.policies = policies;
    }

}