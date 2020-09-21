package br.maua.classes_dao;

import br.maua.dao.DAO;
import br.maua.dao.DAOFields;
import br.maua.model.Manga;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MangaDAO implements DAO<Manga>, DAOFields {
    private Connection connection;
    private String myDBConnectionString = "jdbc:sqlite:Dados_SQL.db";

    public MangaDAO() {
        try {
            connection = DriverManager.getConnection(myDBConnectionString);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<Manga> get(String item, String valor) {
        List<Manga> mangas = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(getSelectConditionalString(getTableName()) + item + " = " + valor);
            while (resultSet.next()) {
                Manga manga = new Manga(
                        resultSet.getString("nome"),
                        resultSet.getString("url"),
                        resultSet.getString("sinopse"),
                        resultSet.getInt("capitulos"),
                        resultSet.getInt("volumes"),
                        resultSet.getString("tipo"),
                        resultSet.getDouble("nota")
                );
                mangas.add(manga);
            }
            resultSet.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mangas;
    }

    @Override
    public List<Manga> getAll() {
        List<Manga> mangas = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(getSelectAllString(getTableName()));
            while (resultSet.next()) {
                Manga manga = new Manga(
                        resultSet.getString("nome"),
                        resultSet.getString("url"),
                        resultSet.getString("sinopse"),
                        resultSet.getInt("capitulos"),
                        resultSet.getInt("volumes"),
                        resultSet.getString("tipo"),
                        resultSet.getDouble("nota")
                );
                mangas.add(manga);
            }
            resultSet.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mangas;
    }

    @Override
    public void delete(Manga manga) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(getDeleteString(getTableName()));
            preparedStatement.setString(1, manga.getNome());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void create(Manga manga) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(getInsertString(getTableName()));
            preparedStatement.setString(1, manga.getNome());
            preparedStatement.setString(2, manga.getUrl());
            preparedStatement.setString(3, manga.getSinopse());
            preparedStatement.setInt(4, manga.getCapitulos());
            preparedStatement.setInt(5, manga.getVolumes());
            preparedStatement.setString(6, manga.getTipo());
            preparedStatement.setDouble(7, manga.getNota());

            int retorno = preparedStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getTableName() {
        return "manga";
    }

    @Override
    public String getDeleteString(String table) {
        return "DELETE FROM " + table + " WHERE nome = ?";
    }

    @Override
    public String getInsertString(String table) {
        return "INSERT INTO " + table + " (nome, url, sinopse, capitulos, volumes, tipo, nota) VALUES (?, ?, ?, ?, ?, ?, ?);";
    }

    @Override
    public String getSelectAllString(String table) {
        return "SELECT * FROM " + table;
    }

    @Override
    public String getSelectConditionalString(String table) {
        return "SELECT * FROM " + table + " WHERE ";
    }
}