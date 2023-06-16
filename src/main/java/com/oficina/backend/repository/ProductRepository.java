package com.oficina.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.oficina.backend.model.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
  
}
