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
        var personagens : List<Personagem> = ArrayList()
        try {
            val statement : Statement = conn!!.createStatement()
            val result : ResultSet = statement.executeQuery(getSelectConditionalString(getTableName() + condition))

            while (result.next()) {
                val personagem = Personagem(
                    result.getString("nome"),
                result.getString("raça"), result.getString("profissão"), result.getInt("mana"),
                result.getInt("ataque"), result.getInt("ataque_mágico"), result.getInt("defesa"),
                result.getInt("defesa_mágica"), result.getInt("velocidade"), result.getInt("destreza"),
                result.getInt("xp"), result.getInt("nível")
                )
                personagens.plus(personagem)
            }
            result.close()

        } catch (e : Exception) {
            e.printStackTrace()
        }
        return personagens
    }

    override fun getAll(): List<Personagem> {
        var personagens : List<Personagem> = ArrayList()
        try {
            val statement : Statement = conn!!.createStatement()
            val result : ResultSet = statement.executeQuery(getSelectAllString(getTableName()))

            while (result.next()) {
                var personagem = Personagem(
                    result.getString("nome"),
                    result.getString("raça"), result.getString("profissão"), result.getInt("mana"),
                    result.getInt("ataque"), result.getInt("ataque_mágico"), result.getInt("defesa"),
                    result.getInt("defesa_mágica"), result.getInt("velocidade"), result.getInt("destreza"),
                    result.getInt("xp"), result.getInt("nível")
                )
                personagens.plus(personagem)
            }
            result.close()

        } catch (e : Exception) {
            e.printStackTrace()
        }
        return personagens
    }

    override fun update(personagem : Personagem) {
        try {
            val preparedStatement : PreparedStatement = conn!!.prepareStatement(getUpdateString(getTableName()))
            preparedStatement.setString(1, personagem.nome)
            preparedStatement.setString(2, personagem.raça)
            preparedStatement.setString(3, personagem.profissão)
            preparedStatement.setString(4, personagem.mana.toString())
            preparedStatement.setString(5, personagem.ataque.toString())
            preparedStatement.setString(6, personagem.ataque_mágico.toString())
            preparedStatement.setString(7, personagem.defesa.toString())
            preparedStatement.setString(8, personagem.defesa_mágica.toString())
            preparedStatement.setString(9, personagem.velocidade.toString())
            preparedStatement.setString(10, personagem.destreza.toString())
            preparedStatement.setString(11, personagem.xp.toString())
            preparedStatement.setString(12, personagem.nível.toString())
            preparedStatement.setString(13, personagem.nome)


            val retorno : Int = preparedStatement.executeUpdate()

        } catch (e : Exception) {
            e.printStackTrace()
        }
    }

    override fun create(personagem: Personagem) {
        try {
            val preparedStatement : PreparedStatement = conn!!.prepareStatement(getUpdateString(getTableName()))
            preparedStatement.setString(1, personagem.nome)
            preparedStatement.setString(2, personagem.raça)
            preparedStatement.setString(3, personagem.profissão)
            preparedStatement.setString(4, personagem.mana.toString())
            preparedStatement.setString(5, personagem.ataque.toString())
            preparedStatement.setString(6, personagem.ataque_mágico.toString())
            preparedStatement.setString(7, personagem.defesa.toString())
            preparedStatement.setString(8, personagem.defesa_mágica.toString())
            preparedStatement.setString(9, personagem.velocidade.toString())
            preparedStatement.setString(10, personagem.destreza.toString())
            preparedStatement.setString(11, personagem.xp.toString())
            preparedStatement.setString(12, personagem.nível.toString())

            val retorno : Int = preparedStatement.executeUpdate()

        } catch (e : Exception) {
            e.printStackTrace()
        }
    }

    override fun delete(personagem: Personagem) {
        try {
            val statement : PreparedStatement = conn!!.prepareStatement(getDeleteString(getTableName()))
            statement.setString(1, personagem.nome)
            statement.executeUpdate()

        } catch (e : Exception) {
            e.printStackTrace()
        }
    }

    override fun getTableName(): String { return "Personagem" }

    override fun getDeleteString(table: String): String {
        return "DELETE FROM " + table + "WHERE nome = ?;"
    }

    override fun getUpdateString(table: String): String {
         return "UPDATE " + table + " SET nome = ?, raça = ?, profissão = ?, mana = ?, ataque = ?, ataque_mágico = ?," +
                 "defesa = ?, defesa_mágica = ?, velocidade = ?, destreza = ?, xp = ?, nível = ? WHERE nome = ?;"
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