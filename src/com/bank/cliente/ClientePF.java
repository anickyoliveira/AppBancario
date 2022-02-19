package com.bank.cliente;

import com.bank.conta.ContaCorrente;
import com.bank.conta.ContaInvestimento;
import com.bank.conta.ContaPoupanca;

public class ClientePF extends Cliente {
    private ContaPoupanca cp;

    public ClientePF() {

        this.cc = new ContaCorrente();
        this.ci = new ContaInvestimento();
        this.cp = new ContaPoupanca();
    }
}
