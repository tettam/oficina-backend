package com.oficina.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oficina.backend.model.entities.BrandCar;

public interface BrandCarRepository extends JpaRepository<BrandCar, Long> {
  
}
