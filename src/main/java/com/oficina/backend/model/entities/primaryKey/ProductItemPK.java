package com.oficina.backend.model.entities.primaryKey;

import com.oficina.backend.model.entities.Budget;
import com.oficina.backend.model.entities.Product;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Embeddable
public class ProductItemPK {
  
  @ManyToOne
  @JoinColumn(name = "budget_id")
  private Budget budget;

  @ManyToOne
  @JoinColumn(name = "product_id")
  private Product product;
}




