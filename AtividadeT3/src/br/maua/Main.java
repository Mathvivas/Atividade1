package br.maua;

import br.maua.model.Sistema;

/**
 * Classe de inicialização do sistema.
 * @author Gabriel de Godoy Braz - 17.00163-3
 * @author Matheus Lopes Vivas - 17.04401-4
 * @since 08/06/2020
 * @version 1.0
 */

public class Main {

    public static void main(String[] args) {
        Sistema sistema = new Sistema();

        sistema.run();
    }
}
