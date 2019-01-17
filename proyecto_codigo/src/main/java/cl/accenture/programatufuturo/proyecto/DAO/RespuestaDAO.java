package cl.accenture.programatufuturo.proyecto.DAO;

import cl.accenture.programatufuturo.proyecto.exception.SinConexionException;
import cl.accenture.programatufuturo.proyecto.model.Respuesta;

import javax.swing.undo.UndoableEditSupport;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RespuestaDAO {

    private Conexion conexion;

    public RespuestaDAO(Conexion conexion) throws SinConexionException{
        this.conexion = conexion;
    }

    // Añadir Respuesta, no retornamos nada, recibimos un Usuario
    public void añadirRespuesta(Respuesta x) throws SinConexionException {
        try{

            // en mi SQL hago un INSERT TO, y VALUES, con signos de interrogacion en los valores de las columnas
            // y a continuación les dadamos el valor
            final String SQL = "INSERT INTO Respuesta(id, comentario, fecha, reclamo_Id, usuario_Id) VALUES (?,?,?,?,?)";


            PreparedStatement ps = conexion.getConexion().prepareStatement(SQL);

            // ingresamos los valores con Set, segun el lugar del signo,
            // y un get de la respuesta recibida según corresponda
            ps.setInt(1,x.getId());
            ps.setString(2,x.getComentario());
            ps.setDate(3, (Date) x.getFecha());
            ps.setInt(4,x.getReclamo().getId());
            ps.setInt(5,x.getUsuario().getId());

            // Ejecutamos el almacenamiento
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Ordenar por Fecha, retorno lista ordenada, no recibo nada.
    public List<Respuesta> ordenarPorFecha (){
        List<Respuesta> respuestas = new ArrayList<Respuesta>();

        try{
            final String SQL = "SELECT * FROM Respuesta WHERE ORDER BY fecha ASC";

            PreparedStatement ps = this.conexion.getConexion().prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                Respuesta res = new Respuesta();

                res.setId(rs.getInt(1));
                res.setComentario(rs.getString(2));
                res.setFecha(rs.getDate(4));

                ReclamoDAO rDAO = new ReclamoDAO(this.conexion);
                UsuarioDAO uDAO = new UsuarioDAO(this.conexion);

                res.setReclamo(rDAO.buscarPorId(rs.getInt(4)));
                res.setUsuario(uDAO.obtenerPorId(rs.getInt(5)));

                respuestas.add(res);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (SinConexionException e) {
            e.printStackTrace();
        }
        return respuestas;
    }

}
