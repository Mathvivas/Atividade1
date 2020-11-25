package dao

import models.Personagem
import java.lang.Exception
import java.sql.*

class PersonagemDAO : DAO<Personagem>, DAOFields {

    private var conn : Connection? = null
    private var myDBConnectionString : String = "jdbc:sqlite:Personagem.db"

    init {
        try {
            conn = DriverManager.getConnection(myDBConnectionString)

        } catch (throwables : SQLException) {
            throwables.printStackTrace()
        }
    }

    override fun get(condition: String): List<Personagem> {
        TODO("Not yet implemented")
    }

    override fun getAll(): List<Personagem> {
        TODO("Not yet implemented")
    }

    override fun update(t: Personagem) {
        TODO("Not yet implemented")
    }

    override fun create(t: Personagem) {
        TODO("Not yet implemented")
    }

    override fun delete(t: Personagem) {
        try {
            val statement : PreparedStatement = conn!!.prepareStatement(getDeleteString(getTableName()))

        } catch (e : Exception) {
            e.printStackTrace()
        }
    }

    override fun getTableName(): String { return "Personagem" }

    override fun getDeleteString(table: String): String {
        return "DELETE FROM " + table + "WHERE id = ?;"
    }

    override fun getUpdateString(table: String): String {
        TODO("Not yet implemented")
    }

    override fun getInsertString(table: String): String {
        return "INSERT INTO " + table + " (nome, raça, profissão, mana, ataque, ataque_mágico, defesa, defesa_mágica, " +
                "velocidade, destreza, xp, nível) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);"
    }

    override fun getSelectAllString(table: String): String {
        return "SELECT * FROM " + table
    }

    override fun getSelectConditionalString(table: String): String {
        return "SELECT * FROM " + table + " WHERE "
    }
}