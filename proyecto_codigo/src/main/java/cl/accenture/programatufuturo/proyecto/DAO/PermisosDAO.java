package cl.accenture.programatufuturo.proyecto.DAO;

import cl.accenture.programatufuturo.proyecto.exception.SinConexionException;

import cl.accenture.programatufuturo.proyecto.model.Permisos;
import cl.accenture.programatufuturo.proyecto.model.Reclamo;
import cl.accenture.programatufuturo.proyecto.model.Rol;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PermisosDAO {

    private Conexion conexion;


    public PermisosDAO(Conexion conexion) {
        this.conexion = conexion;
    }

    public void insertarPermiso(Permisos b) throws SinConexionException {

        try {

            PreparedStatement pstatementInsert = conexion.getConexion().prepareStatement("INSERT INTO permisos(nombre) VALUES (?)");
            pstatementInsert.setString(1, b.getNombre());
            pstatementInsert.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //metodo obtener permiso
    public List<Permisos> obtenerPermisos() throws SinConexionException {
        List<Permisos> permisos = new ArrayList<Permisos>();
        try {
            final String SQL = "SELECT * from permisos";
            PreparedStatement ps = conexion.getConexion().prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Permisos permiso = new Permisos();
                permiso.setNombre(rs.getString(1));
                permisos.add(permiso);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return permisos;

    }

    //metodo eliminar permiso ayudaaaaaa
    public List<Permisos> eliminarpermiso() throws SinConexionException {
        List<Permisos> permisos = new ArrayList<Permisos>();
        try {
            PreparedStatement pstatementDelete=conexion.getConexion().prepareStatement("DELETE FROM permiso WHERE nombre=?;");
            ResultSet rs=pstatementDelete.executeQuery();

            while (rs.next()) {
                Permisos permiso = new Permisos();
                permiso.setNombre(rs.getString(2));
                permisos.remove(permiso);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return permisos;
    }
}
