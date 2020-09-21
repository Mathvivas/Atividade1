package br.maua.dao;

import java.util.List;

public interface DAO <T>{       // Qualquer tipo --> Genérica
    List<T> get(String condition);
    List<T> getAll();

    void update(T t);
    void delete(T t);
    void create(T t);
}
