package com.oficina.backend.service.exeptions;

public class DatabaseException extends RuntimeException {
  
  public DatabaseException(String msg){
    super(msg);
  }
}
