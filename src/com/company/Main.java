/*
    Nome: Matheus Lopes Vivas

    R.A.: 17.04401-4
*/

package com.company;

public class Main {
    public static void main(String[] args) {
        Usuário u1, u2, u3;
        Conta c1, c2, c3;
        u1 = new Usuário("Matheus", "pass", "mathvivas@hotmail.com");
        u2 = new Usuário("Bob", "patrick", "bobesponja@uol.com");
        u3 = new Usuário("Ingrid", "linda", "ingrid@hotmail.com");

        c1 = new Conta(u1, 1000, 1);
        c2 = new Conta(u2, 250, 2);
        c3 = new Conta(u3, 3000, 3);


        Transação.GerarCode(c1, 250);
        Transação.Transferir(c1, c2, 250);
        Transação.Transferir(c1, c3, 250);
        Transação.Transferir(c1, c2, 250);
    }
}

