package sistema

import dao.PersonagemDAO
import models.Personagem

/**
 * Classe responsável pelo sistema principal do programa. Ela é quem interage com o usuário.
 * @author Gabriel de Godoy Braz - 17.00163-3
 * @author Matheus Lopes Vivas - 17.04401-4
 */

class Aplicacao {
    private val personagem : List<Personagem>
    private val personagemDAO : PersonagemDAO

    init {
        personagem = ArrayList()
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


    fun atualizarPersonagem() {
        val personagem = personagemDAO.getAll()
        print("Digite o nome do Personagem: ")
        var name = readLine()
        print("Digite a raça do Personagem: ")
        var raca = readLine()
        print("Digite a profissão do Personagem: ")
        var profissao = readLine()
        print("Digite a mana do Personagem: ")
        var mana = readLine()
        print("Digite o ataque do Personagem: ")
        var ataque = readLine()
        print("Digite o ataque mágico do Personagem: ")
        var ataque_mágico = readLine()
        print("Digite a defesa do Personagem: ")
        var defesa = readLine()
        print("Digite a defesa mágica do Personagem: ")
        var defesa_mágica = readLine()
        print("Digite a velocidade do Personagem: ")
        var velocidade = readLine()
        print("Digite a destreza do Personagem: ")
        var destreza = readLine()
        print("Digite o xp do Personagem: ")
        var xp = readLine()
        print("Digite o nível do Personagem: ")
        var nivel = readLine()

        personagemDAO.update(Personagem(name.toString(), raca.toString(), profissao.toString(), mana!!.toInt(),
            ataque!!.toInt(), ataque_mágico!!.toInt(), defesa!!.toInt(), defesa_mágica!!.toInt(),
        velocidade!!.toInt(), destreza!!.toInt(), xp!!.toInt(), nivel!!.toInt()))
    }

    fun deletarPersonagem() {
        print("Digite o nome do personagem que quer deletar: ")
        var nome = readLine()
        var personagem = Personagem(nome!!)
        personagemDAO.delete(personagem)
    }

    fun exibirPersonagens() {
        var personagens = personagemDAO.getAll()
        println("Personagens: ")
        for ( personagem in personagens ) println(personagem)
    }

    fun cadastrarNovoPersonagem() {
        print("Digite o nome do Personagem: ")
        var name = readLine()
        print("Digite a raça do Personagem: ")
        var raca = readLine()
        print("Digite a profissão do Personagem: ")
        var profissao = readLine()
        print("Digite a mana do Personagem: ")
        var mana = readLine()
        print("Digite o ataque do Personagem: ")
        var ataque = readLine()
        print("Digite o ataque mágico do Personagem: ")
        var ataqueMagico = readLine()
        print("Digite a defesa do Personagem: ")
        var defesa = readLine()
        print("Digite a defesa mágica do Personagem: ")
        var defesaMagica = readLine()
        print("Digite a velocidade do Personagem: ")
        var velocidade = readLine()
        print("Digite a destreza do Personagem: ")
        var destreza = readLine()
        print("Digite o xp do Personagem: ")
        var xp = readLine()
        print("Digite o nível do Personagem: ")
        var nivel = readLine()

        personagemDAO.create(Personagem(name.toString(), raca.toString(), profissao.toString(), mana!!.toInt(),
            ataque!!.toInt(), ataqueMagico!!.toInt(), defesa!!.toInt(), defesaMagica!!.toInt(),
            velocidade!!.toInt(), destreza!!.toInt(), xp!!.toInt(), nivel!!.toInt()))
    }

}