package com.oficina.backend.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import lombok.Data;

@Table(name = "tb_budget_product")
@Entity
@Data
public class ProductItem  {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "budget_id")
  @JsonIgnore
  private Budget budget;

  @ManyToOne
  @JoinColumn(name = "product_id")
  private Product product;

  private Integer quantity;
  private String brand;
  private Double price;
}
