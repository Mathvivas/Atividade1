package dao

/**
 * Interface que possui os métodos de ligação com o Banco de Dados.
 * @author Gabriel de Godoy Braz - 17.00163-3
 * @author Matheus Lopes Vivas - 17.04401-4
 */

interface DAOFields {

    fun getTableName() : String
    fun getDeleteString(table : String) : String
    fun getUpdateString(table : String) : String
    fun getInsertString(table : String) : String
    fun getSelectAllString(table : String) : String
    fun getSelectConditionalString(table : String) : String
}