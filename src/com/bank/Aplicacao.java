package com.bank;

import com.bank.cliente.Cliente;
import java.math.BigDecimal;

public class Aplicacao {
    public static void main(String args[]) {

        Banco Poupa = new Banco();
        Cliente cpj1 = Poupa.aberturaConta(
                "Empresa",
                17,
                "Rua Amadeu 21",
                "6/6/2006",
                "846598000117",
                new BigDecimal(20000),
                2);

        Cliente cpf1 = Poupa.aberturaConta(
                " Joana",
                51,
                "Rua João 43 Vila União",
                "13/03/1951",
                "345.456.764-1",
                new BigDecimal(50),
                1);

        Poupa.consultarSaldo(cpf1);
        Poupa.sacar(cpf1, new BigDecimal(30));
        Poupa.consultarSaldo(cpf1);

        Cliente cpf2 = Poupa.aberturaConta(
                "Joao",
                51,
                "Rua Maria 58 Vilas Boas",
                "18/07/1951",
                "347.789.654.18",
                new BigDecimal(100),
                1);

        Poupa.depositarCc(cpf2,new BigDecimal(100));
        Poupa.consultarSaldo(cpf2);

        Poupa.consultarSaldo(cpj1);
        Poupa.transferirCc(cpj1,cpf2,new BigDecimal (500));
        Poupa.consultarSaldo(cpj1);
        Poupa.consultarSaldo(cpf2);


        Poupa.investirCi(cpj1, new BigDecimal(2000));
        Poupa.consultarSaldo(cpj1);
        Poupa.sacar(cpj1, new BigDecimal(200));
        Poupa.consultarSaldo(cpj1);
    }
}