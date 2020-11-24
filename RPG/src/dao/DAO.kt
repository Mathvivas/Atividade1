package dao

interface DAO <T>{

    fun get(condition : String) : List<T>
    fun getAll() : List<T>

    fun update(t : T)
    fun create(t : T)
    fun delete(t : T)
}