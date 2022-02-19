package com.bank;


import com.bank.cliente.Cliente;
import com.bank.cliente.ClientePF;
import com.bank.cliente.ClientePJ;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

class Banco {

    private List<Cliente> clientes = new ArrayList<Cliente>();

    private boolean validaIsCliente(Cliente c) {
        boolean isCliente = false;

        // Verficar se o cliente e do banco
        for (Cliente bc : this.clientes) {
            if (bc.getCpfCnpj().equals(c.getCpfCnpj())) {
                isCliente = true;
                break;
            }
        }
        return isCliente;

    }

    public Cliente aberturaConta(
            String nome,
            int idade,
            String endereco,
            String dataNascimento,
            String cpfCnpj,
            BigDecimal depositoInicial,
            int tipoConta) {
        Cliente c = null;

        // Abre cliente PF
        if (tipoConta == 1) {
            c = new ClientePF();
        }
        // Abre cliente PJ
        else if (tipoConta == 2) {
            c = new ClientePJ();
        } else {
            return null;
        }

        c.setDadosPessoais(nome, idade, endereco, dataNascimento, cpfCnpj);
        this.clientes.add(c);
        c.getContaCorrente().incremento(depositoInicial);
        System.out.println("Conta aberta com sucesso. com.bank.Cliente: " + cpfCnpj + " Deposito inicial CC: " + depositoInicial);
        return c;
    }

    public void sacar(Cliente c, BigDecimal valor) {

        if (this.validaIsCliente(c))
        {
            int r = c.getContaCorrente().decremento(valor);

            if (r == 0)
            {
                System.out.println("Saque efetuado com sucesso. Valor: " + valor + " com.bank.Cliente:" + c.getCpfCnpj());

                if (c instanceof ClientePJ)
                {
                    System.out.println("com.bank.Cliente Pessoa Juridica.");
                    c.getContaCorrente().cobranca(valor);
                }
                else {

                }

                return;
            }
            else {
                System.out.println("Saldo Insuficiente");
                return;
            }
        }
        else
        {
            System.out.println("com.bank.Cliente nao pertence ao banco");
        }
    }

    public void consultarSaldo(Cliente c)
    {
        System.out.println("Consultando saldo do cliente: " + c.getCpfCnpj() + " Saldo CC: " + c.getContaCorrente().getSaldo() + " Saldo CI: " + c.getContaInvestimento().getSaldo());
    }

    public void depositarCc(Cliente destinatario, BigDecimal valor) {

        // validar se destinario e cliente do banco
        if (this.validaIsCliente(destinatario)) {
            //Destinario sendo do banco pode ser feito o deposito e o valor
            // acrescido na conta
            destinatario.getContaCorrente().incremento(valor);

            System.out.println("Deposito realizado com sucesso. com.bank.Cliente: " + destinatario.getCpfCnpj() + " Valor: " + valor);

        } else {
            System.out.println("com.bank.Cliente não pertence ao banco");
        }
    }

    public void transferirCc(Cliente remetente, Cliente destinatario, BigDecimal valor) {
        // cenario 1 - destinaraio e remetende do mesmo banco
        // nao esta considerando cenario entre banco
        // validar se destinario e cliente do banco

        if (this.validaIsCliente(destinatario) && (this.validaIsCliente(remetente))) {
            //Realizada a transferencia pelo destinatario, o valor devera ser
            // descontado da conta do mesmo e acrescido a conta do remetente
            remetente.getContaCorrente().decremento(valor);
            destinatario.getContaCorrente().incremento(valor);
            {
                if (remetente instanceof ClientePJ) {
                    System.out.println("com.bank.Cliente Pessoa Juridica. Cobrando.");
                    remetente.getContaCorrente().cobranca(valor);
                }
            }
            System.out.println("Transferencia realizada com sucesso. Remetente: " + remetente.getCpfCnpj() + " Destinatario: " + destinatario.getCpfCnpj() + " Valor: " + valor);

        } else {
            System.out.println("Erro na transferencia- Dados invalidos");
        }
    }

    public void investirCi(Cliente investidor, BigDecimal valor) {
        // com.bank.Cliente PJ e PF abrem conta investimento
        if (this.validaIsCliente(investidor))
        {
            investidor.getContaInvestimento().incremento(valor);
            System.out.println("Investimento realizado com sucesso. com.bank.Cliente: " + investidor.getCpfCnpj() + " Valor: " + valor + " Saldo antes do rendimento: " + investidor.getContaInvestimento().getSaldo());

            if (investidor instanceof ClientePJ)
            {
                System.out.println("com.bank.Cliente Pessoa Juridica, rendendo.");
                investidor.getContaInvestimento().rendimento();
            }
        }
        else
        {
            System.out.println("com.bank.Cliente não pertence ao banco");
        }
    }
}