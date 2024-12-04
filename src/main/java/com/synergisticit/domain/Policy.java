package com.synergisticit.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Policy implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @JsonIgnore
    @ManyToMany(mappedBy="policies")
    private List<Plan> plans = new ArrayList<>();

    public Policy() {
    }

    public Policy(Long id, String name, List<Plan> plans) {
        this.id = id;
        this.name = name;
        this.plans = plans;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Plan> getPlans() {
        return plans;
    }

    public void setPlans(List<Plan> plans) {
        this.plans = plans;
    }
}
