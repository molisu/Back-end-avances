package cl.accenture.programatufuturo.proyecto.DAO;

import cl.accenture.programatufuturo.proyecto.exception.SinConexionException;
import cl.accenture.programatufuturo.proyecto.model.Estado;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EstadoDAO {

    private Conexion conexion;

    public EstadoDAO(Conexion conexion) {
        this.conexion = conexion;
    }

    public void agregarEstado(Estado estado) throws SinConexionException {
        try {
            final String SQL = "INSERT INTO Estado(idEstado,nombre) VALUES(?,?)";
            PreparedStatement ps = conexion.getConexion().prepareStatement(SQL);
            ps.setInt(1, estado.getId());
            ps.setString(2, estado.getNombre());
            ps.executeUpdate();

        } catch (SQLException o) {
            o.printStackTrace();
        }
    }

    public List<Estado> obtenerEstados() throws SinConexionException {
        List<Estado> estados = new ArrayList<Estado>();
        try {
            final String SQL = "SELECT * from Estado";
            PreparedStatement ps = conexion.getConexion().prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Estado estado = new Estado();
                estado.setId(rs.getInt(1));
                estado.setNombre(rs.getString(2));

                estados.add(estado);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return estados;
    }

    public List<Estado> buscarEstadopornombre(String t) throws SinConexionException {
        List<Estado> estados = new ArrayList<Estado>();
        try {
            final String SQL = "SELECT * FROM Estado WHERE nombre=?";
            PreparedStatement ps = conexion.getConexion().prepareStatement(SQL);
            ps.setString(1, t);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Estado estado = new Estado();
                estado.setId(rs.getInt(1));
                estado.setNombre(rs.getString(2));
                estados.add(estado);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return estados;
    }

    //metodo buscar estado por id
    public Estado buscarEstadoporId(int p) throws SinConexionException {
        Estado estado = new Estado();

        try {
            final String SQL = "SELECT * FROM Estado WHERE idEstado=?";
            PreparedStatement ps = conexion.getConexion().prepareStatement(SQL);
            ps.setInt(1, p);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                estado.setId(rs.getInt(1));
                estado.setNombre(rs.getString(2));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return estado;
    }

    // no retorna anda, modifica el id de un Estado
    public void cambiarEstado(int idParaBuscar, int idModificado) throws SinConexionException {
        try {

            final String SQL = "UPDATE Reclamo SET estado_idEstado= ? WHERE id= ?;";
            PreparedStatement ps = conexion.getConexion().prepareStatement(SQL);
            ps.setInt(1, idModificado);
            ps.setInt(2, idParaBuscar);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}