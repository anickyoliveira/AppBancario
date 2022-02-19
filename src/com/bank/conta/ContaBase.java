package com.bank.conta;


import java.math.BigDecimal;

public class ContaBase {
    protected BigDecimal tarifaCobranca = new BigDecimal(0);
    protected BigDecimal tarifaInvestimento = new BigDecimal(0);
    protected BigDecimal saldo = new BigDecimal(0);


    public void incremento(BigDecimal valor) {
        this.saldo = this.saldo.add(valor);
    }

    public int decremento(BigDecimal valor) {
        if (this.saldo.compareTo(valor) >= 0) {
            this.saldo = this.saldo.subtract(valor);
            return 0;
        } else {
            return -1;
        }
    }

    public BigDecimal getSaldo() {
        return saldo;
    }
}