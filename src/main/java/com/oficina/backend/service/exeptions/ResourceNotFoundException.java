package com.oficina.backend.service.exeptions;

public class ResourceNotFoundException extends RuntimeException{

  public ResourceNotFoundException(Object id){
    super("Não encontrado. Id " + id);
  }
  
}
