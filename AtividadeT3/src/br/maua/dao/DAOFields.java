package br.maua.dao;

public interface DAOFields {
    String getTableName();
    String getDeleteString(String table);
    String getInsertString(String tabel);
    String getSelectAllString(String table);
    String getSelectConditionalString(String table);
}
