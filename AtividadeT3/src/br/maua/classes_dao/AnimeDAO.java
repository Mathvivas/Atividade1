package br.maua.classes_dao;

import br.maua.dao.DAO;
import br.maua.dao.DAOFields;
import br.maua.model.Anime;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Classe que representa o Anime no Banco de Dados. Implementa os métodos das Interfaces.
 * @author Gabriel de Godoy Braz - 17.00163-3
 * @author Matheus Lopes Vivas - 17.04401-4
 */
public class AnimeDAO implements DAO<Anime>, DAOFields {
    private Connection connection;
    private String myDBConnectionString = "jdbc:sqlite:Dados_SQL.db";

    /**
     * Construtor da Classe
     */
    public AnimeDAO() {
        try {
            connection = DriverManager.getConnection(myDBConnectionString);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<Anime> get(String valor) {
        List<Anime> animes = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(getSelectConditionalString(getTableName(), valor));
            while (resultSet.next()) {
                Anime anime = new Anime(
                        resultSet.getString("nome"),
                        resultSet.getString("url"),
                        resultSet.getString("sinopse"),
                        resultSet.getInt("episodios"),
                        resultSet.getDouble("nota")
                );
                animes.add(anime);
            }
            resultSet.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return animes;
    }

    @Override
    public List<Anime> getAll() {
        List<Anime> animes = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(getSelectAllString(getTableName()));
            while (resultSet.next()) {
                Anime anime = new Anime(
                        resultSet.getString("nome"),
                        resultSet.getString("url"),
                        resultSet.getString("sinopse"),
                        resultSet.getInt("episodios"),
                        resultSet.getDouble("nota")
                );
                animes.add(anime);
            }
            resultSet.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return animes;
    }

    @Override
    public void create(Anime anime) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(getInsertString(getTableName()));
            preparedStatement.setString(1, anime.getNome());
            preparedStatement.setString(2, anime.getUrl());
            preparedStatement.setString(3, anime.getSinopse());
            preparedStatement.setInt(4, anime.getEpisodios());
            preparedStatement.setDouble(5, anime.getNota());

            int retorno = preparedStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getTableName() {
        return "anime";
    }

    @Override
    public String getInsertString(String table) {
        return "INSERT INTO " + table + " (nome, url, sinopse, episodios, nota) VALUES (?, ?, ?, ?, ?)";
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
