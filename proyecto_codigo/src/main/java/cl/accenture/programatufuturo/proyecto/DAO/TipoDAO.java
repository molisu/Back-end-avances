package cl.accenture.programatufuturo.proyecto.DAO;

import cl.accenture.programatufuturo.proyecto.exception.SinConexionException;
import cl.accenture.programatufuturo.proyecto.model.Estado;
import cl.accenture.programatufuturo.proyecto.model.Reclamo;
import cl.accenture.programatufuturo.proyecto.model.Tipo;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class TipoDAO {

    private Conexion conexion;

    public TipoDAO(Conexion conexion) {
        this.conexion = conexion;
    }

    //metodo insertar (tipo)reclamo


    public void insertarTipoReclamo(Tipo a) throws SinConexionException {
        try {
            PreparedStatement pstatementInsert = conexion.getConexion().prepareStatement("INSERT INTO TipoReclamo(id,nombre,sla");
            pstatementInsert.setInt(1, a.getId());
            pstatementInsert.setString(2, a.getNombre());
            pstatementInsert.setInt(3, a.getSla());

            pstatementInsert.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    //metodo para buscar tiporeclamo por id


    public Tipo buscarTipoConId (int t) throws SinConexionException {
        Tipo tipo = new Tipo();

        try {
            final String SQL = "SELECT * FROM TipoReclamo WHERE id=?";
            PreparedStatement ps = conexion.getConexion().prepareStatement(SQL);
            ps.setInt(1, t);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                tipo.setId(rs.getInt(1));
                tipo.setNombre(rs.getString(2));
                tipo.setSla(rs.getInt(3));

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return tipo;
    }


    //metodo para buscar por nombre

    public List<Tipo> buscarPorNombre(String nombre) throws SinConexionException {
        List<Tipo> tipos = new ArrayList<Tipo>();
        try {
            final String SQL = "SELECT * FROM TipoReclamo WHERE nombre=?";
            PreparedStatement ps = conexion.getConexion().prepareStatement(SQL);
            ps.setString(1, nombre);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Tipo tipo = new Tipo();
                tipo.setId(rs.getInt(1));
                tipo.setNombre(rs.getString(2));
                tipo.setSla(rs.getInt(3));
                tipos.add(tipo);
            }
        } catch (SQLException o) {
            o.printStackTrace();
        }
        return tipos;
    }


    //metodo para ordenar por SLA


    public List<Tipo> ordenarPorsSla() throws SinConexionException{
        List<Tipo> tipos = new ArrayList<Tipo>();
        try {
            final String SQL = "SELECT * FROM TipoReclamo WHERE ORDER BY sla ASC";
            PreparedStatement ps = conexion.getConexion().prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Tipo tipo = new Tipo();
                tipo.setId(rs.getInt(1));
                tipo.setNombre(rs.getString(2));
                tipo.setSla(rs.getInt(3));
                tipos.add(tipo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tipos;
    }


    //metodo para buscar por SLA


    public List<Tipo> buscarPorSla(int sla) throws SinConexionException {
        List<Tipo> tipos = new ArrayList<Tipo>();
        try {
            final String SQL = "SELECT * FROM TipoReclamo WHERE sla=?";
            PreparedStatement ps = conexion.getConexion().prepareStatement(SQL);
            ps.setInt(1, sla);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Tipo tipo = new Tipo();
                tipo.setId(rs.getInt(1));
                tipo.setNombre(rs.getString(2));
                tipo.setSla(rs.getInt(3));
                tipos.add(tipo);
            }
        } catch (SQLException o) {
            o.printStackTrace();
        }
        return tipos;
    }


    //metodo para ordenar por nombre


    public List<Tipo> ordenarPorNombre() throws SinConexionException{
        List<Tipo> tipos = new ArrayList<Tipo>();
        try {
            final String SQL = "SELECT * FROM TipoReclamo WHERE ORDER BY nombre ASC";
            PreparedStatement ps = conexion.getConexion().prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Tipo tipo = new Tipo();
                tipo.setId(rs.getInt(1));
                tipo.setNombre(rs.getString(2));
                tipo.setSla(rs.getInt(3));
                tipos.add(tipo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tipos;
    }

    //lista todos los tipos

    public List<Tipo> obtenerAll() throws SinConexionException {
        List<Tipo> tipos = new ArrayList<Tipo>();

        try {

            final String SQL = "SELECT * FROM Tipo";
            PreparedStatement ps = this.conexion.getConexion().prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Tipo t = new Tipo();

                // Asigno sus parametros al objeto previamente creado
                t.setId(rs.getInt(1));
                t.setNombre(rs.getString(2));
                t.setSla(rs.getInt(3));

                // añado mi Tipo con sus atributos ya ingresados en mi list
                tipos.add(t);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tipos;
    }
}


