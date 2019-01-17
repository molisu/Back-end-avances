package cl.accenture.programatufuturo.proyecto.DAO;

import cl.accenture.programatufuturo.proyecto.exception.SinConexionException;

import java.sql.*;

public class Conexion {



    public Connection getConexion() throws SinConexionException {
        Connection conexion = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/proyecto", "root", "33forever");
            System.out.println("resulto! :)");
            Statement s = conexion.createStatement();
            ResultSet rs = s.executeQuery("select * from Reclamo");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        } catch (SQLException e) {
            throw new SinConexionException("sin conexion");
        }
        return conexion;
    }




}

