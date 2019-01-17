package cl.accenture.programatufuturo.proyecto.DAO;

import cl.accenture.programatufuturo.proyecto.exception.SinConexionException;
import cl.accenture.programatufuturo.proyecto.model.Reclamo;
import cl.accenture.programatufuturo.proyecto.model.Tipo;

import java.sql.*;
import java.util.ArrayList;
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
    public void insertarTiporeclamo(Tipo a)throws SinConexionException {
        try {
            PreparedStatement pstatementInsert = conexion.getConexion().prepareStatement("INSERT INTO tiporeclamo(Id,nombre,SLA");
            pstatementInsert.setInt(1, a.getId());
            pstatementInsert.setString(2, a.getNombre());
            pstatementInsert.setInt(3, a.getSla());
        }catch (SQLException e){
            e.printStackTrace();

        }
    }
    //metodo para buscar tiporeclamo por id
    public void buscarporid(Integer a)throws SinConexionException{
        try{
            PreparedStatement pstatementSelect = conexion.getConexion().prepareStatement("SELECT * FROM tiporeclamo WHERE Id=?");
            pstatementSelect.setInt(1, a);
            ResultSet rs = pstatementSelect.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getInt("Id"));
                System.out.println(rs.getString("nombre"));
                System.out.println(rs.getInt("SLA"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    //metodo para buscar por nombre
    public void buscarpornombre(String nombre)throws SinConexionException{
        try{
            PreparedStatement pstatementSelect = conexion.getConexion().prepareStatement("SELECT * FROM permiso WHERE nombre=? ");
            pstatementSelect.setString (1, nombre);
            ResultSet rs = pstatementSelect.executeQuery();
            while(rs.next()){
                System.out.print(rs.getInt("Id"));
                System.out.print(rs.getString("nombre"));
                System.out.print(rs.getInt("SLA"));
                System.out.println("");
            }
            statement.close();
            rs.close();
        }catch (SQLException o){
            o.printStackTrace();
        }
    }
//metodo para ordenar por SLA



















    //metodo para buscar por SLA ayudaaaa
    public List<Reclamo> buscarporsla(Reclamo p)throws SinConexionException{
        List<Reclamo>reclamos=new ArrayList<Reclamo>();
        try{
            statement =conexion.getConexion().createStatement();
            String query="SELECT * FROM tiporeclamo WHERE nombre=?";
            PreparedStatement statement=conexion.getConexion().prepareStatement(query);
            statement.setArray(3,p);
            ResultSet rs=statement.executeQuery();
            while(rs.next()){
                System.out.print(rs.getInt("Id"));
                System.out.print(rs.getString("nombre"));
                System.out.print(rs.getInt("SLA"));
                System.out.println("");
            }
            statement.close();
            rs.close();
        }catch (SQLException o) {
            o.printStackTrace();
        }
        return reclamos;

    }
    //metodo para ordenar por nombre




}