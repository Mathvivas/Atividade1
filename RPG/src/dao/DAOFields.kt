package dao

interface DAOFields {

    fun getTableName() : String
    fun getDeleteString(table : String) : String
    fun getUpdateString(table : String) : String
    fun getInsertString(table : String) : String
    fun getSelectAllString(table : String) : String
    fun getSelectConditionalString(table : String) : String
}