package cl.accenture.programatufuturo.proyecto.DAO;

import cl.accenture.programatufuturo.proyecto.exception.SinConexionException;
import cl.accenture.programatufuturo.proyecto.model.Reclamo;
import cl.accenture.programatufuturo.proyecto.model.Estado;


import java.sql.*;
import java.util.Scanner;

public class ReclamoDAO {

    private Conexion conexion;

    public ReclamoDAO(Conexion conexion) {
        this.conexion = conexion;
    }

    public void insertarReclamo(Reclamo a) throws SinConexionException {

        try {

            PreparedStatement pstatementInsert = conexion.getConexion().prepareStatement("INSERT INTO Reclamo (Id, titulo, descripcion, fecha,region, TipoReclamo_Id, Usuario_Id, Estado_Id)" + "VALUES (?,?,?,?,?,?,?,?)");

            pstatementInsert.setInt(1,a.getId());
            pstatementInsert.setString(2,a.getTitulo());
            pstatementInsert.setString(3,a.getDescripcion());
            pstatementInsert.setDate(4, (Date) a.getFecha());
            pstatementInsert.setString(5,a.getRegion());
            pstatementInsert.setInt(6, a.getTipo().getId());
            pstatementInsert.setInt(7,a.getUsuario().getId());
            pstatementInsert.setInt(8,a.getEstado().getId());


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // metodo para buscar reclamos de acuerdo a una id ingresada.

    public Reclamo buscarPorId(int a) throws SinConexionException{
        Reclamo r = new Reclamo();
        try {

            PreparedStatement pstatementSelect = conexion.getConexion().prepareStatement("SELECT * FROM Reclamo WHERE Id=?");
            pstatementSelect.setInt(1, a);
            ResultSet rs = pstatementSelect.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getInt("Id"));
                System.out.println(rs.getString("titulo"));
                System.out.println(rs.getString("descripcion"));

                PreparedStatement psstatementSelect = conexion.getConexion().prepareStatement("SELECT nombre FROM Usuario WHERE Id in (SELECT Id FROM Reclamo WHERE Id=?");
                psstatementSelect.setInt(1, a);
                ResultSet rss = pstatementSelect.executeQuery();
                System.out.println(rss.getString("nombre"));

                System.out.println(rs.getDate("fecha"));
                System.out.println(rs.getString("region"));

                PreparedStatement ppsstatementSelect = conexion.getConexion().prepareStatement("SELECT nombre FROM Estado WHERE Id in (SELECT Id FROM Reclamo WHERE Id=?");
                ppsstatementSelect.setInt(1, a);
                ResultSet rrss = pstatementSelect.executeQuery();
                System.out.println(rrss.getString("nombre"));

                PreparedStatement pesstatementSelect = conexion.getConexion().prepareStatement("SELECT nombre FROM TipoReclamo WHERE Id in (SELECT Id FROM Reclamo WHERE Id=?");
                pesstatementSelect.setInt(1, a);
                ResultSet ress = pstatementSelect.executeQuery();
                System.out.println(ress.getString("nombre"));

            }

            PreparedStatement prstatementSelect = conexion.getConexion().prepareStatement("SELECT * FROM Respuesta WHERE Reclamo_Id=?");
            prstatementSelect.setInt(1, a);
            ResultSet prs = prstatementSelect.executeQuery();

            while (prs.next()) {
                System.out.println(prs.getString("comentario"));

                PreparedStatement ppesstatementSelect = conexion.getConexion().prepareStatement("SELECT nombre FROM Usuario WHERE Id in (SELECT Id FROM Reclamo WHERE Id=?");
                ppesstatementSelect.setInt(1, a);
                ResultSet rress = pstatementSelect.executeQuery();
                System.out.println(rress.getString("nombre"));

                System.out.println(prs.getDate("fecha"));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return r;
    }


    // metodo para buscar un reclamo de acuerdo a un titulo ingresado


    public void buscarPorTitulo(String a) throws SinConexionException{
        try {

            PreparedStatement pstatementSelect = conexion.getConexion().prepareStatement("SELECT * FROM Reclamo WHERE titulo=? ");
            pstatementSelect.setString (1, a);
            ResultSet rs = pstatementSelect.executeQuery();

            while (rs.next()) {

                System.out.println(rs.getInt("Id"));
                System.out.println(rs.getString("titulo"));
                System.out.println(rs.getString("descripcion"));

                PreparedStatement psstatementSelect = conexion.getConexion().prepareStatement("SELECT nombre FROM Usuario WHERE Id in SELECT Id FROM Reclamo  ");
                psstatementSelect.setString(1, a);
                ResultSet rss = pstatementSelect.executeQuery();

                System.out.println(rss.getString("nombre"));

                System.out.println(rs.getDate("fecha"));
                System.out.println(rs.getString("region"));


                PreparedStatement ppsstatementSelect = conexion.getConexion().prepareStatement("SELECT ");
                ppsstatementSelect.setString(1, a);
                ResultSet rrss = ppsstatementSelect.executeQuery();

                System.out.println(rrss.getString("nombre"));

                PreparedStatement pesstatementSelect = conexion.getConexion().prepareStatement("SELECT");
                pesstatementSelect.setString(1, a);
                ResultSet ress = pesstatementSelect.executeQuery();

                System.out.println(ress.getString("nombre"));
            }
            PreparedStatement prstatementSelect = conexion.getConexion().prepareStatement("SELECT * FROM Respuesta WHERE Reclamo_Id=?");
            prstatementSelect.setString(1, a);
            ResultSet prs = prstatementSelect.executeQuery();

            while (prs.next()) {
                System.out.println(prs.getString("comentario"));

                PreparedStatement ppesstatementSelect = conexion.getConexion().prepareStatement("SELECT nombre FROM Usuario WHERE Id in (SELECT Id FROM Reclamo WHERE Id=?");
                ppesstatementSelect.setString(1, a);
                ResultSet rress = pstatementSelect.executeQuery();
                System.out.println(rress.getString("nombre"));

                System.out.println(prs.getDate("fecha"));

            }



            } catch (SQLException e1) {
            e1.printStackTrace();
        }

    }


    public  void main(String[] args) throws SinConexionException {
        Scanner teclado = new Scanner(System.in);
        int id = 1;
         buscarPorId(id);

    }


}
