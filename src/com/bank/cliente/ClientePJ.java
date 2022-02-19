package com.bank.cliente;

import com.bank.conta.ContaCorrente;
import com.bank.conta.ContaInvestimento;

import java.math.BigDecimal;

public class ClientePJ extends Cliente {

    public ClientePJ() {
        this.cc = new ContaCorrente(new BigDecimal("0.005"));
        this.ci = new ContaInvestimento(new BigDecimal("0.02"));
    }
}