package com.synergisticit.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstname;

    private String lastname;

    private String DOB;

    private String driverLicenseNo;

    @JsonIgnore
    @ManyToMany(mappedBy="members")
    private List<Driver> drivers = new ArrayList<>();


    public Member() {
    }

    public Member(Long id, String firstname, String lastname, String DOB, String driverLicenseNo, List<Driver> drivers) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.DOB = DOB;
        this.driverLicenseNo = driverLicenseNo;
        this.drivers = drivers;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getDriverLicenseNo() {
        return driverLicenseNo;
    }

    public void setDriverLicenseNo(String driverLicenseNo) {
        this.driverLicenseNo = driverLicenseNo;
    }

    public List<Driver> getDrivers() {
        return drivers;
    }

    public void setDrivers(List<Driver> drivers) {
        this.drivers = drivers;
    }
}
