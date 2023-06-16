package com.oficina.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oficina.backend.model.entities.ModelCar;

public interface ModelCarRepository extends JpaRepository<ModelCar, Long> {
  
}
