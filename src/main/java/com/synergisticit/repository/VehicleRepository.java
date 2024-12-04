package com.synergisticit.repository;

import com.synergisticit.domain.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    public Vehicle findByUsername(String username);
}
