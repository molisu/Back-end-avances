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
    private Statement statement;
    private PreparedStatement psInsertar;
    private Conexion conexion;

    public TipoDAO(Conexion conexion) {
        this.conexion = conexion;
    }

    //metodo insertar reclamo


    public void insertarTiporeclamo(Tipo a) throws SinConexionException {
        try {
            PreparedStatement pstatementInsert = conexion.getConexion().prepareStatement("INSERT INTO tiporeclamo(Id,nombre,SLA");
            pstatementInsert.setInt(1, a.getId());
            pstatementInsert.setString(2, a.getNombre());
            pstatementInsert.setInt(3, a.getSla());
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    //metodo para buscar tiporeclamo por id


    public List<Tipo>buscartipoconid (Integer t) throws SinConexionException {
        List<Tipo> tipos = new ArrayList<Tipo>();    //creo una lista y la inicializo como Arraylist
        try {
            final String SQL = "SELECT * FROM tiporeclamo WHERE Id=?";
            PreparedStatement ps = conexion.getConexion().prepareStatement(SQL);
            ps.setInt(1, t);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Tipo tipo = new Tipo();
                tipo.setId(rs.getInt(1));
                tipo.setNombre(rs.getString(2));
                tipos.add(tipo);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return tipos;
    }


    //metodo para buscar por nombre

    public List<Tipo> buscarpornombre(String nombre) throws SinConexionException {
        List<Tipo> tipos = new ArrayList<Tipo>();
        try {
            final String SQL = "SELECT * FROM tiporeclamo WHERE nombre=?";
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


    public List<Tipo> ordenarporsla() {
        List<Tipo> tipos = new ArrayList<Tipo>();
        try {
            final String SQL = "SELECT * FROM tipoReclamo WHERE ORDER BY sla ASC";
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
        } catch (SinConexionException e) {
            e.printStackTrace();
        }
        return tipos;
    }


    //metodo para buscar por SLA


    public List<Tipo> buscarporsla(Integer sla) throws SinConexionException {
        List<Tipo> tipos = new ArrayList<Tipo>();
        try {
            final String SQL = "SELECT * FROM tiporeclamo WHERE SLA=?";
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


    public List<Tipo> ordenarpornombre() {
        List<Tipo> tipos = new ArrayList<Tipo>();
        try {
            final String SQL = "SELECT * FROM tipoReclamo WHERE ORDER BY nombre ASC";
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
        } catch (SinConexionException e) {
            e.printStackTrace();
        }
        return tipos;
    }
}


