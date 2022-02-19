package com.bank.conta;

import java.math.BigDecimal;

public class ContaInvestimento extends ContaBase {
    public ContaInvestimento(BigDecimal investimento) {
        this.tarifaInvestimento = investimento;
    }

    public ContaInvestimento() {
    }
    public void rendimento(){
        BigDecimal normalizedTarifaInvestimento = this.tarifaInvestimento.multiply(new BigDecimal(100));

        this.saldo = this.saldo.
                multiply(normalizedTarifaInvestimento.add(new BigDecimal(100))).
                divide(new BigDecimal(100));
    }
}