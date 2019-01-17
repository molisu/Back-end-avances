package cl.accenture.programatufuturo.proyecto.DAO;

import cl.accenture.programatufuturo.proyecto.exception.SinConexionException;
import cl.accenture.programatufuturo.proyecto.model.Rol;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RolDAO {

    private Conexion conexion;

    public RolDAO(Conexion conexion) {
        this.conexion = conexion;
    }

    // Agregar Rol, no retornamos nada, recibimos un Rol
    public void agregarRol(Rol x) throws SinConexionException {
        try {

            // en mi SQL hago un INSERT TO, y VALUES, con signos de interrogacion en los valores de las columnas
            // y a continuación les dadamos el valor
            final String SQL = "INSERT INTO Rol(id, nombre) VALUES (?,?)";

            PreparedStatement ps = conexion.getConexion().prepareStatement(SQL);

            // ingresamos los valores con Set, segun el lugar del signo,
            // y un get de la respuesta recibida según corresponda
            ps.setInt(1, x.getId());
            ps.setString(2, x.getNombre());

            // Ejecutamos el almacenamiento
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Obetener lista de Roles, retornamos una List de Rol, no recibo nada.
    public List<Rol> obtenerAll() throws SinConexionException {

        // Creo mi List y la inicializo como una ArrayList
        List<Rol> roles = new ArrayList<Rol>();

        try {

            // Selecciono todas las columnas, de la tabla Rol
            final String SQL = "SELECT * FROM Rol";

            // Creo mi PreparedStatement, con la conexion con mi SQL
            PreparedStatement ps = this.conexion.getConexion().prepareStatement(SQL);

            // en el ResultSet ejecuto la Query del ps.
            ResultSet rs = ps.executeQuery();

            // Mientras rs, siga teniendo respuestas, entonces
            while (rs.next()) {

                // creo un nuevo usuario SIN PARAMETROS
                Rol r = new Rol();

                // Asigno sus parametros al objeto previamente creado
                r.setId(rs.getInt(1));
                r.setNombre(rs.getString(2));

                // añado mi Rol con sus atributos ya ingresados en mi list
                roles.add(r);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return roles;
    }

    // Eliminar un rol según su id, no retorno nada, recibo un int (id del Rol)
    public void eliminarRol (int x) throws SinConexionException {
        try {

            // Elimino todas las columnas de la tabla Rol, donde el id
            // sea igual a ? (valor ingresado a contiuacion)
            final String SQL = "DELETE * FROM Rol WHERE id = ?";

            // creo un Statement, conecto y creo Statement
            Statement sentenciaDelete = this.conexion.getConexion().createStatement();

            // variable resultado de esto, que sería la variable del
            // Statement ejecutando la modificacion del SQL.
            int resultadoDelete = sentenciaDelete.executeUpdate(SQL);

            // creo un PS, del SQL
            PreparedStatement ps = this.conexion.getConexion().prepareStatement(SQL);

            // le asigno valor a mi '?' que en este caso será el String que nos entregan (u)
            ps.setInt(1, x);

            // ejecuto la modificacion
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Obtener Usuario por su id, retorno un Usuario
    // recibo un int que será el id del Usuario
    public Rol obtenerPorId (int id) throws SinConexionException {
        Rol rol = new Rol();

        try {
            // Selecciono todas las columnas de la tabla Usuario, donde
            // su id sea equivalente a un valor que entregaré a continuacion
            final String SQL = "SELECT * FROM Rol WHERE id = ?";
            PreparedStatement ps = this.conexion.getConexion().prepareStatement(SQL);

            // aqui ingreso el valor de mi signo de interrogacion, es decir '?'
            // será igual a id que es el int que me ingresan (id del Usuario)
            ps.setInt(1, id);

            // respuesta almacenada en una variable, de la Query ejecutada en ps.
            ResultSet rs = ps.executeQuery();

            // Mientras sigan habíendo respuestas
            while (rs.next()) {

                // A user entrego los valores que corresponden a sus atributos
                rol.setId(rs.getInt(1));
                rol.setNombre(rs.getString(2));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rol;
    }

}
