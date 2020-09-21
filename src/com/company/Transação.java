/*
    Nome: Matheus Lopes Vivas

    R.A.: 17.04401-4
*/

package com.company;

import java.util.Random;
import java.lang.String;

public class Transação {

    private static int getRandomNumberInRange(int min, int max) {
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }


    public static int GerarCode(Conta conta, double valor) {
        String s = String.format("%s;%s;%i;i", conta.getID(), conta.getUsuário(), valor, getRandomNumberInRange(1000, 9999));
        String dados[] = s.split(";");
        int ID = Integer.parseInt(dados[0]);
        return ID;
    }

    public static double Transferir(Conta c1, Conta c2, double valor) {
        if (c1.getID() == GerarCode(c1, valor)) {
            if (c2.getsaldo() >= valor) {
                double x = c1.getsaldo() + valor;
                double y = c2.getsaldo() - valor;
                System.out.println("Transferência bem sucedida!");
                System.out.println("Saldo atual ("+ c1.getUsuário() +"): " + x);
                System.out.println("Saldo atual ("+ c2.getUsuário() +"): " + y);

            }
            else
                System.out.println("Saldo insuficiente!");
        }
        else
            System.out.println("Usuário não reconhecido!");

        return Transferir(c1, c2, valor);
    }

}
