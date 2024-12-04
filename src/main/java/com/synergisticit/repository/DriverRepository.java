package com.synergisticit.repository;

import com.synergisticit.domain.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {
    public Driver findByUsername(String username);

    public void deleteByUsername(String username);
}
