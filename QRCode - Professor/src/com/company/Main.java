package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe o nome do usuário 1:");             // Pede o nome
        String nome = scanner.nextLine();                               // Grava o nome na variável nome
        Usuario usuario = new Usuario(nome, "", "");       // Cria um novo usuário utilizando o nome dado acima
        Conta c1 = new Conta(usuario, 1000);                 // Cria uma conta utilizando o usuário criado acima

        System.out.println("Informe o nome do usuário 2:");
        nome = scanner.nextLine();
        usuario = new Usuario(nome, "", "");
        Conta c2 = new Conta(usuario, 250);

        System.out.println("Informe o nome do usuário 3:");
        nome = scanner.nextLine();
        usuario = new Usuario(nome, "", "");
        Conta c3 = new Conta(usuario, 3000);

        System.out.println("Estado Inicial:");
        System.out.println(c1.exibeStatus());
        System.out.println(c2.exibeStatus());
        System.out.println(c3.exibeStatus());

        String qrcode = Transacao.gerarStringRecebimento(c1,250);
        Transacao.realizarPagamentoComString(c2,c1,qrcode);
        Transacao.realizarPagamentoComString(c3,c1,qrcode);
        Transacao.realizarPagamentoComString(c2,c1,qrcode);

        qrcode = Transacao.gerarStringRecebimento(c2, 1000);
        Transacao.realizarPagamentoComString(c3,c2,qrcode);

        System.out.println("Estado Final:");
        System.out.println(c1.exibeStatus());
        System.out.println(c2.exibeStatus());
        System.out.println(c3.exibeStatus());
    }
}
