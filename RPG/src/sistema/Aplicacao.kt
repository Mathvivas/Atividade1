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

    

}