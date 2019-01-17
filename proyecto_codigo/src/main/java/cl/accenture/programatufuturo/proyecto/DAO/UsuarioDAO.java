package cl.accenture.programatufuturo.proyecto.DAO;
import cl.accenture.programatufuturo.proyecto.exception.SinConexionException;
import cl.accenture.programatufuturo.proyecto.model.Rol;
import cl.accenture.programatufuturo.proyecto.model.Usuario;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    private Conexion conexion;

    public UsuarioDAO(Conexion conexion) throws SinConexionException{

        this.conexion = conexion;
    }

    // Almacenar Usuario, no retorna nada. Recibe un Usuario
    public void almacenarUsuario (Usuario u) throws SinConexionException{
        try{

            // en mi SQL hago un INSERT TO, y VALUES, con signos de interrogacion en los valores de las columnas
            // y a continuación les dadamos el valor
            final String SQL = "INSERT INTO Usuario(id, nombre, email, contraseña, ultimoLogin, fechaNac, telefono, nacionalidad, rut, genero, rol_Id) VALUES (?,?,?,?,?,?,?,?,?,?,?)";

            PreparedStatement ps = conexion.getConexion().prepareStatement(SQL);

            // ingresamos los valores con Set, segun el lugar del signo,
            // y un get de la respuesta recibida según corresponda


            ps.setInt(1,u.getId());
            ps.setString(2,u.getNombre());
            ps.setString(3,u.getEmail());
            ps.setString(4,u.getContraseña());
            ps.setDate(5,(Date) u.getUltimoLogin());
            ps.setDate(6,(Date) u.getFechaNac());
            ps.setInt(7,u.getTelefono());
            ps.setString(8,u.getNacionalidad());
            ps.setString(9,u.getRut());
            ps.setString(10,u.getGenero());
            ps.setInt(11,u.getRol().getId());

            // Ejecutamos el almacenamiento
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Login para ingresar, retorna un boolean, recibe un Usuario
    public boolean login(String usuario, String contraseña)throws SinConexionException {

        try{
            final String SQL = "SELECT * FROM usuario WHERE nombre=? AND contraseña=?";

            PreparedStatement ps = conexion.getConexion().prepareStatement(SQL);
            ps.setString(1, usuario);
            ps.setString(2, contraseña);

            ResultSet rs = ps.executeQuery();

            if (rs.next())
            return true;

        }catch (SQLException e){
        }
        return false;

    }

    public String encriptar(String cadena) throws NoSuchAlgorithmException {

        //Encriptacion MD5

        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] hashInBytes = md.digest(cadena.getBytes(StandardCharsets.UTF_8));

        StringBuilder sb = new StringBuilder();
        for (byte b : hashInBytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    // Buscar un Usuario por su nombre, retorno una Lista de Usuarios
    // recibo un String que será el nombre del Usuario
    public List<Usuario> buscarUsuarioPorNombre (String name) throws SinConexionException {

        // Creo mi lista, de tipo Array porque quiero >:)
        List<Usuario> usuarios = new ArrayList<Usuario>();

        try {
            // Selecciono todas las columnas de la tabla Usuario, donde
            // su nombre sea equivalente a un valor que entregaré a continuacion
            final String SQL = "SELECT * FROM Usuario WHERE nombre = ?";
            PreparedStatement ps = this.conexion.getConexion().prepareStatement(SQL);

            // aqui ingreso el valor de mi signo de interrogacion, es decir '?'
            // será igual a name que es el String que me ingresan (nombre del Usuario)
            ps.setString(1, name);

            // respuesta almacenada en una variable, de la Query ejecutada en ps.
            ResultSet rs = ps.executeQuery();

            // Mientras sigan habíendo respuestas
            while (rs.next()) {

                // Creo objeto Usuario
                Usuario user = new Usuario();

                // y le entrego los valores que corresponden a sus atributos
                user.setId(rs.getInt(1));
                user.setNombre(rs.getString(2));
                user.setEmail(rs.getString(3));
                user.setContraseña(rs.getString(4));
                user.setUltimoLogin(rs.getDate(5));
                user.setFechaNac(rs.getDate(6));
                user.setTelefono(rs.getInt(7));
                user.setNacionalidad(rs.getString(8));
                user.setRut(rs.getString(9));
                user.setGenero(rs.getString(10));

                RolDAO rDAO = new RolDAO(this.conexion);

                user.setRol(rDAO.obtenerPorId(rs.getInt(11)));

                // añado el Usuario a la list
                usuarios.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuarios;
    }

    // Buscar un Usuario por su email, retorno una Lista de Usuarios
    // recibo un String que será el email del Usuario
    public List<Usuario> buscarUsuarioPorEmail (String email) throws SinConexionException {

        // Creo mi lista, de tipo Array porque quiero >:)
        List<Usuario> usuarios = new ArrayList<Usuario>();

        try {
            // Selecciono todas las columnas de la tabla Usuario, donde
            // su email sea equivalente a un valor que entregaré a continuacion
            final String SQL = "SELECT * FROM Usuario WHERE email = ?";
            PreparedStatement ps = this.conexion.getConexion().prepareStatement(SQL);

            // aqui ingreso el valor de mi signo de interrogacion, es decir '?'
            // será igual a name que es el String que me ingresan (nombre del Usuario)
            ps.setString(1, email);

            // respuesta almacenada en una variable, de la Query ejecutada en ps.
            ResultSet rs = ps.executeQuery();

            // Mientras sigan habíendo respuestas
            while (rs.next()) {

                // Creo objeto Usuario
                Usuario user = new Usuario();

                // y le entrego los valores que corresponden a sus atributos
                user.setId(rs.getInt(1));
                user.setNombre(rs.getString(2));
                user.setEmail(rs.getString(3));
                user.setContraseña(rs.getString(4));
                user.setUltimoLogin(rs.getDate(5));
                user.setFechaNac(rs.getDate(6));
                user.setTelefono(rs.getInt(7));
                user.setNacionalidad(rs.getString(8));
                user.setRut(rs.getString(9));
                user.setGenero(rs.getString(10));

                RolDAO rDAO = new RolDAO(this.conexion);

                user.setRol(rDAO.obtenerPorId(rs.getInt(11)));

                // añado añado el Usario a la list
                usuarios.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuarios;
    }

    // Obtener Usuario por su id, retorno un Usuario
    // recibo un int que será el id del Usuario
    public Usuario obtenerPorId (int id) throws SinConexionException {
        Usuario user = new Usuario();

        try {
            // Selecciono todas las columnas de la tabla Usuario, donde
            // su id sea equivalente a un valor que entregaré a continuacion
            final String SQL = "SELECT * FROM Usuario WHERE id = ?";
            PreparedStatement ps = this.conexion.getConexion().prepareStatement(SQL);

            // aqui ingreso el valor de mi signo de interrogacion, es decir '?'
            // será igual a id que es el int que me ingresan (id del Usuario)
            ps.setInt(1, id);

            // respuesta almacenada en una variable, de la Query ejecutada en ps.
            ResultSet rs = ps.executeQuery();

            // Mientras sigan habíendo respuestas
            while (rs.next()) {

                // A user entrego los valores que corresponden a sus atributos
                user.setId(rs.getInt(1));
                user.setNombre(rs.getString(2));
                user.setEmail(rs.getString(3));
                user.setContraseña(rs.getString(4));
                user.setUltimoLogin(rs.getDate(5));
                user.setFechaNac(rs.getDate(6));
                user.setTelefono(rs.getInt(7));
                user.setNacionalidad(rs.getString(8));
                user.setRut(rs.getString(9));
                user.setGenero(rs.getString(10));

                RolDAO rDAO = new RolDAO(this.conexion);

                user.setRol(rDAO.obtenerPorId(rs.getInt(11)));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

}



