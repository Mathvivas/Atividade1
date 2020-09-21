package br.maua.classes_dao;

import br.maua.dao.DAO;
import br.maua.dao.DAOFields;
import br.maua.model.Manga;

import java.util.List;

public class MangaDAO implements DAO<Manga>, DAOFields {
    @Override
    public List<Manga> get(String condition) {
        return null;
    }

    @Override
    public List<Manga> getAll() {
        return null;
    }

    @Override
    public void update(Manga manga) {

    }

    @Override
    public void delete(Manga manga) {

    }

    @Override
    public void create(Manga manga) {

    }

    @Override
    public String getTableName() {
        return null;
    }

    @Override
    public String getDeleteString(String table) {
        return null;
    }

    @Override
    public String getUpdateString(String table) {
        return null;
    }

    @Override
    public String getInsertString(String tabel) {
        return null;
    }

    @Override
    public String getSelectAllString(String table) {
        return null;
    }

    @Override
    public String getSelectConditionalString(String table) {
        return null;
    }
}
