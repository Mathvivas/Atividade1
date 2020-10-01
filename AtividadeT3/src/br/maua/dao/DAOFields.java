package br.maua.dao;

/**
 * Interface que possui os métodos de ligação com o Banco de Dados.
 * @author Gabriel de Godoy Braz - 17.00163-3
 * @author Matheus Lopes Vivas - 17.04401-4
 */

public interface DAOFields {
    String getTableName();
    String getInsertString(String table);
    String getSelectAllString(String table);
    String getSelectConditionalString(String table);
}
