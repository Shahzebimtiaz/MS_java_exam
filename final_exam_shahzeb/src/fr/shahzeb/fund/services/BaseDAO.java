package fr.shahzeb.fund.services;

import java.sql.*;
import java.util.List;

public abstract class BaseDAO<T> {

    private final String url;

    protected BaseDAO(String url) {
        this.url = url;
    }

    protected abstract T extractEntity(ResultSet resultSet) throws SQLException;

    public void create(List<T> entities, String insertSQL) {
        try (Connection connection = DriverManager.getConnection(url)) {
            for (T entity : entities) {
                try (PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {
                    setCreateStatementParams(preparedStatement, entity);
                    preparedStatement.executeUpdate();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<T> search(String searchSQL, String param) {
        List<T> result = null;

        try (Connection connection = DriverManager.getConnection(url)) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(searchSQL)) {
                preparedStatement.setString(1, param);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        T entity = extractEntity(resultSet);
                        result.add(entity);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public void update(String updateSQL, T entity) {
        try (Connection connection = DriverManager.getConnection(url)) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(updateSQL)) {
                setUpdateStatementParams(preparedStatement, entity);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(String deleteSQL, String param) {
        try (Connection connection = DriverManager.getConnection(url)) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(deleteSQL)) {
                preparedStatement.setString(1, param);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected abstract void setCreateStatementParams(PreparedStatement preparedStatement, T entity) throws SQLException;

    protected abstract void setUpdateStatementParams(PreparedStatement preparedStatement, T entity) throws SQLException;
}

