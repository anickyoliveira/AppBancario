package com.bank.conta;


import java.math.BigDecimal;

public class ContaCorrente extends ContaBase {
    public ContaCorrente(BigDecimal valor) {
        this.tarifaCobranca = valor;
    }
    public void cobranca(BigDecimal valor)
    {
        BigDecimal normalizedtarifaCobranca = this.tarifaCobranca.multiply(new BigDecimal(100));
        valor = valor.multiply(normalizedtarifaCobranca).divide(new BigDecimal(100));

        this.saldo = this.saldo.subtract(valor);
    }

    public ContaCorrente() {
    }
}