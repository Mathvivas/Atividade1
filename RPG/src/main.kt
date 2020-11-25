import sistema.Aplicacao

// create table Personagem(id Integer primary key AUTOINCREMENT, nome varchar(20), raça varchar(20), profissão varchar(20),
//                       mana integer, ataque integer, ataque_mágico integer, defesa integer, defesa_mágica integer,
//                       velocidade integer, destreza integer, xp integer, nível integer);

fun main() {
    val aplicacao = Aplicacao()

    aplicacao.run()
}