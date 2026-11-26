package com.hachimakidev.fitzone.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {
    //private static final String URL = "jdbc:oracle:thin:@localhost:1521:ORCL";
    private static final String URL = "jdbc:oracle:thin:@//localhost:1521/FREEPDB1";

    private static final String USER = "usuario_desarrollador";
    private static final String PASS = "123456";

    public static Connection obetenerConexion() throws SQLException{
        return DriverManager.getConnection(URL,USER,PASS);
    }

    public static void main(String[] args) {
        try (Connection conn = obetenerConexion()){
            System.out.println(("Conexión exitosa a Oracle Database"));
        } catch (SQLException e){
            System.out.println("Error al conectar: " + e.getMessage());
        }
    }
}