package models

class Personagem (nome : String, raça : String, profissão : String, mana : Int, ataque : Int, ataque_mágico : Int,
    defesa : Int, defesa_mágica : Int, velocidade : Int, destreza : Int, xp : Int, nível : Int) {

    // Atributos da Classe
    val nome : String
    val raça : String
    val profissão : String
    val mana : Int
    val ataque : Int
    val ataque_mágico : Int
    val defesa : Int
    val defesa_mágica : Int
    val velocidade : Int
    val destreza : Int
    val xp : Int
    val nível : Int

    // Corpo do Construtor
    init {
        this.nome = nome
        this.raça = raça
        this.profissão = profissão
        this.mana = mana
        this.ataque = ataque
        this.ataque_mágico = ataque_mágico
        this.defesa = defesa
        this.defesa_mágica = defesa_mágica
        this.velocidade = velocidade
        this.destreza = destreza
        this.xp = xp
        this.nível = nível
    }

    override fun toString(): String {
        return "Personagem (nome = '$nome', raça = '$raça', profissão = '$profissão', mana = $mana, ataque = $ataque, " +
                "ataque_mágico = $ataque_mágico, defesa = $defesa, defesa_mágica = $defesa_mágica, velocidade = $velocidade, " +
                "destreza = $destreza, xp = $xp, nível = $nível)"
    }


}