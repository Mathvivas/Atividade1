package sistema

import dao.PersonagemDAO
import models.Personagem

class Aplicacao {
    private val personagem : List<Personagem>
    private val personagemDAO : PersonagemDAO

    init {
        personagem = ArrayList<Personagem>()
        personagemDAO = PersonagemDAO()
    }

    fun run() {

        var alive = true

        do {
            menu()
            var op = Integer.parseInt(readLine())

            when (op) {
                0 -> alive = false
                1 -> exibirPersonagens()
                2 -> deletarPersonagem()
                3 -> atualizarPersonagem()
                4 -> cadastrarNovoPersonagem()
                else -> println("Opção Inválida!")
            }
        } while (alive)
    }


    fun menu() {
        println("|---------------------------------")
        println("|")
        println("| 1 - Personagens Cadastrados")
        println("|")
        println("| 2 - Deletar Personagem")
        println("|")
        println("| 3 - Alterar Personagem")
        println("|")
        println("| 4 - Cadastrar Personagem")
        println("|")
        println("| 0 - Sair")
        println("|---------------------------------")
    }

}