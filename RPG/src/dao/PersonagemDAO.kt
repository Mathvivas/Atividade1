package dao

import models.Personagem
import java.lang.Exception
import java.sql.*
import java.util.*

class PersonagemDAO : DAO<Personagem>, DAOFields {

    object Database {
        internal var conn : Connection? = null
        internal var username = "username"
        internal var password = "password"

        @JvmStatic fun main(args : Array<String>) {
            getConnection()

            executeMySQLQuery()
        }

        fun executeMySQLQuery() {
            var stmt : Statement? = null
            var resultSet : ResultSet? = null
            try {
                stmt = conn!!.createStatement()
                resultSet = stmt!!.executeQuery("SHOW DATABASES;")
                if (stmt.execute("SHOW DATABASES;")) {
                    resultSet = stmt.resultSet
                }

                while (resultSet!!.next()) {
                    println(resultSet.getString("Database"))
                }
            } catch (ex : SQLException) {
                ex.printStackTrace()
            } finally {
                if (resultSet != null) {
                    try {
                        resultSet.close()
                    } catch (sqlEx : SQLException) {}
                    resultSet = null
                }
                if (stmt != null) {
                    try {
                        stmt.close()
                    } catch (sqlEx : SQLException) {}
                    stmt = null
                }
                if (conn != null) {
                    try {
                        conn!!.close()
                    } catch (sqlEx : SQLException) {}
                    conn = null
                }
            }
        }

        fun getConnection() {
            val connectionProps = Properties()
            connectionProps.put("user", username)
            connectionProps.put("password", password)
            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance()
                conn = DriverManager.getConnection(  "jdbc:" + "mysql" + "://" +
                        "127.0.0.1" +
                        ":" + "3306" + "/" +
                        "", connectionProps)
            } catch (ex : SQLException) {
                ex.printStackTrace()
            } catch (ex : Exception) {
                ex.printStackTrace()
            }
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
        TODO("Not yet implemented")
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