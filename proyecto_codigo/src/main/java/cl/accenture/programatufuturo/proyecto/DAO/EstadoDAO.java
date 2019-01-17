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
    private Statement statement;
    private PreparedStatement psInsertar;
    private Conexion conexion;

    public EstadoDAO(Conexion conexion) {
        this.conexion = conexion;
    }
    public void agregarEstado(Estado estado)throws SinConexionException {
        try{
            final String SQL = "INSERT INTO estado(idEstado,nombre) VALUES(?,?)";
            PreparedStatement ps= conexion.getConexion().prepareStatement(SQL);
            ps.setInt(1,estado.getId());
            ps.setString(2,estado.getNombre());
            ps.executeUpdate();

        } catch (SQLException o) {
            o.printStackTrace();

        }
    }
    public List<Estado> obtenerestados()throws SinConexionException{
        List<Estado> estados = new ArrayList<Estado>();
        try{
            final String SQL = "SELECT * from estado";
            PreparedStatement ps = conexion.getConexion().prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Estado estado = new Estado();
                estado.setId( rs.getInt(1));
                estado.setNombre( rs.getString(2));

                estados.add(estado);
            }

        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return estados;
    }

    public List<Estado>buscarEstadopornombre (String t) throws SinConexionException {
        List<Estado> estados = new ArrayList<Estado>();
        try {
            final String SQL = "SELECT * FROM estado WHERE nombre=?";
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
    public List<Estado>buscarEstadoporId(int p)throws SinConexionException{
        List<Estado>estados=new ArrayList<Estado>();
        try {
            final String SQL = "SELECT * FROM estado WHERE nombre=?";
            PreparedStatement ps = conexion.getConexion().prepareStatement(SQL);
            ps.setInt(1, p);
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

}

//
// no retorna anda, modifica el id, de un Estado a
public void cambiarEstado (int idParaBuscar, int idModificado) throws SinConexionException{
    try {


        final String SQL2 = "UPDATE Reclamo SET estado_idEstado= ? WHERE id= ?;";
        PreparedStatement ps =
        ps.setInt(1, idModificado);
        ps.setInt(2, idParaBuscar);
        ps.executeUpdate();

    } catch (SQLException e) {
        e.printStackTrace();
    } catch (SinConexionException e) {
        e.printStackTrace();
    }
}