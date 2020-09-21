/*
    Nome: Matheus Lopes Vivas

    R.A.: 17.04401-4
*/

package com.company;

public class Conta {
    private int ID;
    private double saldo;
    private Usuário usuário;

    // Construtor
    public Conta(Usuário usuário, double saldo, int ID) {
        this.usuário = usuário;
        this.saldo = saldo;
        this.ID = ID;
    }

    public Usuário getUsuário() {

        return usuário;
    }

    public int getID() {

        return ID;
    }

    public double getsaldo() {

        return saldo;
    }
}
