package com.oficina.backend.model.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "tb_client")
public class Client {
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  @NotBlank(message = "O nome é obrigatório!")
  @Length(min = 2, max = 50, message = "O nome deve ter no mínimo {min} caracteres")
  private String name;
  @Email(message = "Email inválido!")
  private String email;
  private String phone;
  private String address;
  private String cityState;
  private String complementAddress;
  private String zipCode;
  private LocalDate dateBirth;

 
  @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  @JsonManagedReference
  private List<Vehicle> vehicles = new ArrayList<>();

  @OneToMany(mappedBy = "client", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true)
  private List<Budget> budgets = new ArrayList<>();
  
  public Client() {
  }
  
  public Client(Long id,String name,String email, String phone, String address, String cityState, String complementAddress, String zipCode, LocalDate dateBirth, List<Vehicle> vehicles, List<Budget> budgets) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.phone = phone;
    this.address = address;
    this.cityState = cityState;
    this.complementAddress = complementAddress;
    this.zipCode = zipCode;
    this.dateBirth = dateBirth;
    this.vehicles = vehicles;
    this.budgets = budgets;
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
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }
  public String getPhone() {
    return phone;
  }
  public void setPhone(String phone) {
    this.phone = phone;
  }
  public String getAddress() {
    return address;
  }
  public void setAddress(String address) {
    this.address = address;
  }
  public String getCityState() {
    return cityState;
  }
  public void setCityState(String cityState) {
    this.cityState = cityState;
  }
  public String getComplementAddress() {
    return complementAddress;
  }
  public void setComplementAddress(String complementAddress) {
    this.complementAddress = complementAddress;
  }
  public String getZipCode() {
    return zipCode;
  }
  public void setZipCode(String zipCode) {
    this.zipCode = zipCode;
  }
  public LocalDate getDateBirth() {
    return dateBirth;
  }
  public void setDateBirth(LocalDate dateBirth) {
    this.dateBirth = dateBirth;
  }
  public List<Vehicle> getVehicles() {
    return vehicles;
  }
  public List<Budget> getBudgets() {
    return budgets;
  }
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    return result;
  }
  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Client other = (Client) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    return true;
  }
}
