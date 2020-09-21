package br.maua.classes_dao;

import br.maua.dao.DAO;
import br.maua.dao.DAOFields;
import br.maua.model.Anime;

import java.util.List;

public class AnimeDAO implements DAO<Anime>, DAOFields {
    @Override
    public List<Anime> get(String condition) {
        return null;
    }

    @Override
    public List<Anime> getAll() {
        return null;
    }

    @Override
    public void update(Anime anime) {

    }

    @Override
    public void delete(Anime anime) {

    }

    @Override
    public void create(Anime anime) {

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
