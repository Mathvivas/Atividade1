package com.company;

import java.util.Random;

public class Transacao {
    private static int getRandomNumberInRange(int min, int max) {
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    public static String gerarStringRecebimento(Conta conta, double valor){
        return String.format("%s;%s;%s;%s", conta.getId(), conta.getUsuario().getNome(),""+valor, ""+getRandomNumberInRange(1000,9999));
    }

    public static boolean realizarPagamentoComString(Conta pagador, Conta recebedor, String qrcode){
        String[] dados = qrcode.split(";");             // Separa o QRCode e coloca em um lista chamada dados
        if(pagador.getSaldo() < Double.parseDouble(dados[2]) || !recebedor.getId().equals(dados[0]) || !recebedor.getUsuario().getNome().equals(dados[1]))
            return false;
        else{
            pagador.pagar(Double.parseDouble(dados[2]));
            recebedor.depositar(Double.parseDouble(dados[2]));
            return true;
        }
    }
}
