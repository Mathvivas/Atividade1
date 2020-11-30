package models

/**
 * Classe responsável por representar o Personagem de RPG.
 * @author Gabriel de Godoy Braz - 17.00163-3
 * @author Matheus Lopes Vivas - 17.04401-4
 */

class Personagem(nome: String, raça: String, profissão: String, mana: Int?, ataque: Int?, ataqueMagico: Int?,
                 defesa: Int?, defesaMagica: Int?, velocidade: Int?, destreza: Int?, xp: Int?, nível: Int?) {

    // Atributos da Classe
    var nome : String
    var raça : String
    var profissão : String
    var mana : Int
    var ataque : Int
    var ataqueMagico : Int
    var defesa : Int
    var defesaMagica : Int
    var velocidade : Int
    var destreza : Int
    var xp : Int
    var nível : Int

    /**
     *
     * @param nome Nome do Personagem
     * @param raça Raça do Personagem
     * @param profissão Profissão do Personagem
     * @param mana Quantidade de Mana do Personagem
     * @param ataque Dano de ataque do Personagem
     * @param ataqueMagico Dano de magia do Personagem
     * @param defesa Defesa do Personagem
     * @param defesaMagica Defesa Mágica do Personagem
     * @param velocidade Velocidade do Personagem
     * @param destreza Destreza do Personagem
     * @param xp Quantidade de Experiência do Personagem
     * @param nível Nível Atual do Personagem
     */

    // Corpo do Construtor
    init {
        this.nome = nome
        this.raça = raça
        this.profissão = profissão
        this.mana = mana!!
        this.ataque = ataque!!
        this.ataqueMagico = ataqueMagico!!
        this.defesa = defesa!!
        this.defesaMagica = defesaMagica!!
        this.velocidade = velocidade!!
        this.destreza = destreza!!
        this.xp = xp!!
        this.nível = nível!!
    }

    // Segundo Construtor
    constructor(nome: String) : this(nome, null.toString(), null.toString(), null, null, null,
        null, null, null, null, null, null)

    override fun toString(): String {
        return "Personagem (nome = '$nome', raça = '$raça', profissão = '$profissão', mana = $mana, ataque = $ataque, " +
                "ataque_mágico = $ataqueMagico, defesa = $defesa, defesa_mágica = $defesaMagica, velocidade = $velocidade, " +
                "destreza = $destreza, xp = $xp, nível = $nível)"
    }


}