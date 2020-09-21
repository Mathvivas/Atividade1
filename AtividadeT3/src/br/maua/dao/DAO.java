package br.maua.dao;

import java.util.List;

public interface DAO <T>{       // Qualquer tipo --> Genérica
    List<T> get(String valor);
    List<T> getAll();

    void create(T t);
}
