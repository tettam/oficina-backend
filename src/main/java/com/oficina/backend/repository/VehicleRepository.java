package com.oficina.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oficina.backend.model.entities.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
  
}
