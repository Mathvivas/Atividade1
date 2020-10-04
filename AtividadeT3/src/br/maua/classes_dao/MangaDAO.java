package br.maua.classes_dao;

import br.maua.dao.DAO;
import br.maua.dao.DAOFields;
import br.maua.model.Manga;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe que representa o Mangá no Banco de Dados. Implementa os métodos das Interfaces.
 * @author Gabriel de Godoy Braz - 17.00163-3
 * @author Matheus Lopes Vivas - 17.04401-4
 */
public class MangaDAO implements DAO<Manga>, DAOFields {
    private Connection connection;
    private String myDBConnectionString = "jdbc:sqlite:Dados_SQL.db";

    /**
     * Construtor da Classe
     */
    public MangaDAO() {
        try {
            connection = DriverManager.getConnection(myDBConnectionString);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<Manga> get(String valor) {
        List<Manga> mangas = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(getSelectConditionalString(getTableName(), valor));
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
    public String getInsertString(String table) {
        return "INSERT INTO " + table + " (nome, url, sinopse, capitulos, volumes, tipo, nota) VALUES (?, ?, ?, ?, ?, ?, ?);";
    }

    @Override
    public String getSelectAllString(String table) {
        return "SELECT * FROM " + table;
    }

    @Override
    public String getSelectConditionalString(String table, String nome) {
        return "SELECT * FROM " + table + " WHERE nome = " + "'" + nome + "'";
    }
}
