package com.company;

public class Conta {
    private Usuario usuario;
    private double saldo;
    private int idConta;
    private static int totalContas = 0;

    public Conta(Usuario usuario, double saldoInicial){
        this.saldo = saldoInicial;
        this.usuario = usuario;
        this.idConta = Conta.totalContas;
        Conta.totalContas++;
    }

    public String getId() {
        return ""+idConta;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public boolean pagar(double valor) {
        if(valor <= saldo)
            saldo -= valor;
        return valor <= saldo;
    }

    public void depositar(double valor) {
        this.saldo += valor;
    }

    public String exibeStatus(){
        return String.format("Nome Usuário: %s - Saldo: %.2f",usuario.getNome(), saldo);
    }
}
