package com.bank.cliente;

import com.bank.conta.ContaCorrente;
import com.bank.conta.ContaInvestimento;

public class Cliente {
    private String nome;
    private int idade;
    private String endereco;
    private String dataNascimento;
    private String cpfCnpj;
    protected ContaCorrente cc;
    protected ContaInvestimento ci;

    public ContaCorrente getContaCorrente() {
        return this.cc;
    }

    public ContaInvestimento getContaInvestimento(){
        return this.ci;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setDadosPessoais(String n, int i, String e, String dn, String cp) {
        this.nome = n;
        this.idade = i;
        this.endereco = e;
        this.dataNascimento = dn;
        this.cpfCnpj = cp;
    }
}
