package models

class Personagem(nome: String, raça: String, profissão: String, mana: Int?, ataque: Int?, ataque_mágico: Int?,
                 defesa: Int?, defesa_mágica: Int?, velocidade: Int?, destreza: Int?, xp: Int?, nível: Int?) {

    // Atributos da Classe
    var nome : String
    var raça : String
    var profissão : String
    var mana : Int
    var ataque : Int
    var ataque_mágico : Int
    var defesa : Int
    var defesa_mágica : Int
    var velocidade : Int
    var destreza : Int
    var xp : Int
    var nível : Int

    // Corpo do Construtor
    init {
        this.nome = nome
        this.raça = raça
        this.profissão = profissão
        this.mana = mana!!
        this.ataque = ataque!!
        this.ataque_mágico = ataque_mágico!!
        this.defesa = defesa!!
        this.defesa_mágica = defesa_mágica!!
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
                "ataque_mágico = $ataque_mágico, defesa = $defesa, defesa_mágica = $defesa_mágica, velocidade = $velocidade, " +
                "destreza = $destreza, xp = $xp, nível = $nível)"
    }


}