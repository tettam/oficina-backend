package com.oficina.backend.model.entities.enums;

public enum BudgetStatus {
  ESPERANDO_AUTORIZACAO(1),
  AUTORIZADO(2),
  SERVICO_EM_ANDAMENTO(3),
  ESPERANDO_PAGAMENTO(4),
  CONCLUIDO(5),
  CANCELED(6);

  private int code;

  private BudgetStatus(int code){
    this.code = code;
  }

  public int getCode(){
    return code;
  }

  public static BudgetStatus valueOf(int code){
    for(BudgetStatus value : BudgetStatus.values()){
      if(value.getCode() == code){
        return value;
      }
    }
    throw new IllegalArgumentException("Código ENUM inválido!");
  }
}
