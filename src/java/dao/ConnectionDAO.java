/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 *
 * @author Vinicius Böbel
 */
    public abstract class ConnectionDAO<T> implements DAO<T>{
    protected Connection database;
    protected PreparedStatement command;
    
    public Connection toConnect(String sql) throws SQLException {
        database = ConnectionUtil.getConnection();
        command = database.prepareStatement(sql);
        return database;
    }

    public void connectGettingId(String sql) throws SQLException {
        database = ConnectionUtil.getConnection();
        command = database.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
    }

    public void closeConnection() {
        try {
            if (command != null) {
                command.close();
            }
            if (database != null) {
                database.close();
            }
        } catch (SQLException ex) {
            System.err.println("Erro de Sistema - Erro ao encerrar a database");
            throw new BDException(ex);

        }
    }
}
