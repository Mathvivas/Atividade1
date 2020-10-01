package br.maua.dao;

import java.util.List;

/**
 * Interface de tipo genérico que possui métodos que retornam listas.
 * @author Gabriel de Godoy Braz - 17.00163-3
 * @author Matheus Lopes Vivas - 17.04401-4
 */

public interface DAO <T>{       // Qualquer tipo --> Genérica
    List<T> get(String valor);
    List<T> getAll();

    void create(T t);
}
