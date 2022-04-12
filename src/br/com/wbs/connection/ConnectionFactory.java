/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.wbs.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author willian
 */
public class ConnectionFactory {

    private static final String URL = "jdbc:mysql://localhost:3306/bancowbs";
    private static final String USER = "root";
    private static final String PASS = "willian210100WI";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static Connection con = null;

    public static Connection getConnection() {

        try {
            Class.forName(DRIVER);
            con = DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException("Erro na conexão com o banco de dados!");

        }
        return con;
    }
;
}
