/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author Vinicius Böbel
 */
public class ConnectionUtil {

    private final static String HOST = "localhost";
    private final static String PORT = "5432";
    private final static String BD = "gametasks";
    private final static String URL = "jdbc:postgresql://"+HOST+":"+PORT+"/"+BD;
    private final static String USER = "postgres";
    private final static String PASSWORD = "12345";
    
    public static Connection getConnection(){
        Connection database = null;
        try {
            Class.forName("org.postgresql.Driver");
            
            database = DriverManager.getConnection(URL, USER, PASSWORD);
            
        } catch (ClassNotFoundException ex) {
            System.err.println("Erro de Sistema - Classe do Driver Nao Encontrada!");
            throw new RuntimeException(ex);
        } catch (SQLException ex) {
            System.err.println("Erro de Sistema - Problema na conexão do banco de dados");
            throw new RuntimeException(ex);
        }
        return(database);
    }
    
}

