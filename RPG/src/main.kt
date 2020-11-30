import sistema.Aplicacao

// create table Personagem(id Integer primary key AUTOINCREMENT, nome varchar(20), raça varchar(20), profissão varchar(20),
//                       mana integer, ataque integer, ataque_mágico integer, defesa integer, defesa_mágica integer,
//                       velocidade integer, destreza integer, xp integer, nível integer);

/**
 * Classe de inicialização do sistema.
 * @author Gabriel de Godoy Braz - 17.00163-3
 * @author Matheus Lopes Vivas - 17.04401-4
 * @since 28/11/2020
 * @version 1.0
 */

fun main() {
    val aplicacao = Aplicacao()

    aplicacao.run()
}