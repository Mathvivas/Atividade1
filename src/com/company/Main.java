/*
    Nome: Matheus Lopes Vivas

    R.A.: 17.04401-4
*/

package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Usuário u1, u2, u3;
        Conta c1, c2, c3;
        u1 = new Usuário("Matheus");
        u2 = new Usuário("Ingrid");
        u3 = new Usuário("Bob");

        c1 = new Conta(u1, 1000, 1);
        c2 = new Conta(u2, 250, 2);
        c3 = new Conta(u3, 3000, 3);


    }
}

