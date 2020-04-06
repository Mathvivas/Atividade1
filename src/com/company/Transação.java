/*
    Nome: Matheus Lopes Vivas

    R.A.: 17.04401-4
*/

package com.company;

import java.util.Random;
import java.util.Scanner;

public class Transação {

    private static int getRandomNumberInRange(int min, int max) {
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    static Scanner scanner = new Scanner(System.in);


    public static int Gerar(Conta conta) {
        System.out.println("Digite o valor: ");
        double valor = scanner.nextDouble();
        String s = String.format("%s;%s;%i;i", conta.getID(), conta.getUsuário(), valor, getRandomNumberInRange(1000, 9999));
        String dados[] = s.split(";");
        int ID = Integer.parseInt(dados[0]);
        return ID;
    }

    public static boolean Tranferir(Conta c1, Conta c2) {
        if (c1.getID() == c2.getID())
            System.out.println("Não é possível transferir para si mesmo!");
        else
            
    }

}
