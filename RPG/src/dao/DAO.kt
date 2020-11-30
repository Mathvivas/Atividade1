package dao

/**
 * Interface de tipo genérico que possui métodos que retornam listas.
 * @author Gabriel de Godoy Braz - 17.00163-3
 * @author Matheus Lopes Vivas - 17.04401-4
 */

interface DAO <T>{

    fun get(condition : String) : List<T>
    fun getAll() : List<T>

    fun update(t : T)
    fun create(t : T)
    fun delete(t : T)
}