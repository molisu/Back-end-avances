package cl.accenture.programatufuturo.proyecto.DAO;

import cl.accenture.programatufuturo.proyecto.exception.SinConexionException;
import cl.accenture.programatufuturo.proyecto.model.Reclamo;
import cl.accenture.programatufuturo.proyecto.model.Estado;
import cl.accenture.programatufuturo.proyecto.model.Tipo;




import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ReclamoDAO {

    private Conexion conexion;

    public ReclamoDAO(Conexion conexion) {
        this.conexion = conexion;
    }

    // ingresa un nuevo reclamo a la base de datos

    public void insertarReclamo(Reclamo a) throws SinConexionException {

        try {

            PreparedStatement pstatementInsert = conexion.getConexion().prepareStatement("INSERT INTO Reclamo (id, titulo, descripcion, fecha, region, tipoReclamo_Id, usuario_Id, estado_idEstado)" + "VALUES (?,?,?,?,?,?,?,?)");

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

    // busca reclamos de acuerdo a una id ingresada

    public Reclamo buscarPorId(int a) throws SinConexionException{

        Reclamo reclamo= new Reclamo();
        try{

            PreparedStatement pstatementSelect = conexion.getConexion().prepareStatement("SELECT * FROM Reclamo WHERE id=? ");
            pstatementSelect.setInt(1,a);
            ResultSet rs = pstatementSelect.executeQuery();

            reclamo.setId(rs.getInt(1));
            reclamo.setTitulo(rs.getString(2));
            reclamo.setDescripcion(rs.getString(3));
            reclamo.setFecha(rs.getDate(4));
            reclamo.setRegion(rs.getString(5));

            TipoDAO tipoDao = new TipoDAO(this.conexion);
            EstadoDAO estadoDao = new EstadoDAO(this.conexion);
            UsuarioDAO usuarioDao = new UsuarioDAO(this.conexion);

            reclamo.setTipo((Tipo) tipoDao.buscartipoconid((rs.getInt(6))));
            reclamo.setUsuario(usuarioDao.obtenerPorId(rs.getInt(7)));
            reclamo.setEstado((Estado) estadoDao.buscarEstadoporId(rs.getInt(8)));



        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reclamo;
    }

    // muestra todos los reclamos de un tipo especifico ingresado
    // recibe un tipo y devuelve una lista de reclamos que tienen ese tipo

    public List<Reclamo> mostrarPorTipo(Tipo a) throws SinConexionException {

        List<Reclamo> reclamos = new ArrayList<Reclamo>();
        try {

            PreparedStatement pstatementSelect = conexion.getConexion().prepareStatement("SELECT * FROM Reclamo WHERE tipoReclamo_Id=? ");
            pstatementSelect.setInt(1, a.getId());
            ResultSet rs = pstatementSelect.executeQuery();

            while (rs.next()) {

                Reclamo reclamo = new Reclamo();
                reclamo.setId(rs.getInt(1));
                reclamo.setTitulo(rs.getString(2));
                reclamo.setDescripcion(rs.getString(3));
                reclamo.setFecha(rs.getDate(4));
                reclamo.setRegion(rs.getString(5));

                TipoDAO tipoDao = new TipoDAO(this.conexion);
                EstadoDAO estadoDao = new EstadoDAO(this.conexion);
                UsuarioDAO usuarioDao = new UsuarioDAO(this.conexion);

                reclamo.setTipo((Tipo) tipoDao.buscartipoconid((rs.getInt(6))));
                reclamo.setUsuario(usuarioDao.obtenerPorId(rs.getInt(7)));
                reclamo.setEstado((Estado) estadoDao.buscarEstadoporId(rs.getInt(8)));
                reclamos.add(reclamo);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reclamos;
    }

    // muestra lo reclamos filtrados por region.
    // revibe un String que es la region y devuelve la lista de reclamos de esa region

    public List<Reclamo> mostrarPorRegion(String a ) throws SinConexionException{

        List<Reclamo> reclamos= new ArrayList<Reclamo>();

        try{
            PreparedStatement pstatementSelect = conexion.getConexion().prepareStatement("SELECT * FROM Reclamo WHERE region=? ");
            pstatementSelect.setString(1, a);
            ResultSet rs = pstatementSelect.executeQuery();

            while (rs.next()) {

                Reclamo reclamo = new Reclamo();
                reclamo.setId(rs.getInt(1));
                reclamo.setTitulo(rs.getString(2));
                reclamo.setDescripcion(rs.getString(3));
                reclamo.setFecha(rs.getDate(4));
                reclamo.setRegion(rs.getString(5));

                TipoDAO tipoDao = new TipoDAO(this.conexion);
                EstadoDAO estadoDao = new EstadoDAO(this.conexion);
                UsuarioDAO usuarioDao = new UsuarioDAO(this.conexion);

                reclamo.setTipo((Tipo) tipoDao.buscartipoconid((rs.getInt(6))));
                reclamo.setUsuario(usuarioDao.obtenerPorId(rs.getInt(7)));
                reclamo.setEstado((Estado) estadoDao.buscarEstadoporId(rs.getInt(8)));
                reclamos.add(reclamo);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reclamos;
    }

    // muestra los reclamos filtrados por titulo
    //recibe un string y devuelve una lista de reclamos con el mismo titulo

    public List<Reclamo> mostrarPorTitulo(String a ) throws SinConexionException{

        List<Reclamo> reclamos= new ArrayList<Reclamo>();

        try{
            PreparedStatement pstatementSelect = conexion.getConexion().prepareStatement("SELECT * FROM Reclamo WHERE titulo=? ");
            pstatementSelect.setString(1, a);
            ResultSet rs = pstatementSelect.executeQuery();

            while (rs.next()) {

                Reclamo reclamo = new Reclamo();
                reclamo.setId(rs.getInt(1));
                reclamo.setTitulo(rs.getString(2));
                reclamo.setDescripcion(rs.getString(3));
                reclamo.setFecha(rs.getDate(4));
                reclamo.setRegion(rs.getString(5));

                TipoDAO tipoDao = new TipoDAO(this.conexion);
                EstadoDAO estadoDao = new EstadoDAO(this.conexion);
                UsuarioDAO usuarioDao = new UsuarioDAO(this.conexion);

                reclamo.setTipo((Tipo) tipoDao.buscartipoconid((rs.getInt(6))));
                reclamo.setUsuario(usuarioDao.obtenerPorId(rs.getInt(7)));
                reclamo.setEstado((Estado) estadoDao.buscarEstadoporId(rs.getInt(8)));
                reclamos.add(reclamo);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reclamos;
    }

    // ordena los reclamos por fecha de forma ascendente
    //no recibe nada, ya que los ordena



    public List<Reclamo> ordenarPorFechaASC() throws SinConexionException{

        List<Reclamo> reclamos= new ArrayList<Reclamo>();

        try{
            PreparedStatement pstatementSelect = conexion.getConexion().prepareStatement("SELECT * FROM Reclamo WHERE ORDER BY fecha ASC ");
            ResultSet rs = pstatementSelect.executeQuery();


            while (rs.next()) {

                Reclamo reclamo = new Reclamo();
                reclamo.setId(rs.getInt(1));
                reclamo.setTitulo(rs.getString(2));
                reclamo.setDescripcion(rs.getString(3));
                reclamo.setFecha(rs.getDate(4));
                reclamo.setRegion(rs.getString(5));

                TipoDAO tipoDao = new TipoDAO(this.conexion);
                EstadoDAO estadoDao = new EstadoDAO(this.conexion);
                UsuarioDAO usuarioDao = new UsuarioDAO(this.conexion);

                reclamo.setTipo((Tipo) tipoDao.buscartipoconid((rs.getInt(6))));
                reclamo.setUsuario(usuarioDao.obtenerPorId(rs.getInt(7)));
                reclamo.setEstado((Estado) estadoDao.buscarEstadoporId(rs.getInt(8)));
                reclamos.add(reclamo);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reclamos;
    }


    //ordena los reclamos por fecha descendente
    // no recibe nada


    public List<Reclamo> ordenarPorFechaDESC() throws SinConexionException{

        List<Reclamo> reclamos= new ArrayList<Reclamo>();

        try{
            PreparedStatement pstatementSelect = conexion.getConexion().prepareStatement("SELECT * FROM Reclamo WHERE ORDER BY fecha DESC ");
            ResultSet rs = pstatementSelect.executeQuery();

            while (rs.next()) {

                Reclamo reclamo = new Reclamo();
                reclamo.setId(rs.getInt(1));
                reclamo.setTitulo(rs.getString(2));
                reclamo.setDescripcion(rs.getString(3));
                reclamo.setFecha(rs.getDate(4));
                reclamo.setRegion(rs.getString(5));

                TipoDAO tipoDao = new TipoDAO(this.conexion);
                EstadoDAO estadoDao = new EstadoDAO(this.conexion);
                UsuarioDAO usuarioDao = new UsuarioDAO(this.conexion);

                reclamo.setTipo((Tipo) tipoDao.buscartipoconid((rs.getInt(6))));
                reclamo.setUsuario(usuarioDao.obtenerPorId(rs.getInt(7)));
                reclamo.setEstado((Estado) estadoDao.buscarEstadoporId(rs.getInt(8)));
                reclamos.add(reclamo);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reclamos;
    }

    //ordena los reclamos por region de manera ascendente


    public List<Reclamo> ordenarPorRegion()throws SinConexionException{
        List<Reclamo> reclamos= new ArrayList<Reclamo>();

        try{
            PreparedStatement pstatementSelect = conexion.getConexion().prepareStatement("SELECT * FROM Reclamo WHERE ORDER BY region ASC ");
            ResultSet rs = pstatementSelect.executeQuery();

            while (rs.next()) {

                Reclamo reclamo = new Reclamo();
                reclamo.setId(rs.getInt(1));
                reclamo.setTitulo(rs.getString(2));
                reclamo.setDescripcion(rs.getString(3));
                reclamo.setFecha(rs.getDate(4));
                reclamo.setRegion(rs.getString(5));

                TipoDAO tipoDao = new TipoDAO(this.conexion);
                EstadoDAO estadoDao = new EstadoDAO(this.conexion);
                UsuarioDAO usuarioDao = new UsuarioDAO(this.conexion);

                reclamo.setTipo((Tipo) tipoDao.buscartipoconid((rs.getInt(6))));
                reclamo.setUsuario(usuarioDao.obtenerPorId(rs.getInt(7)));
                reclamo.setEstado((Estado) estadoDao.buscarEstadoporId(rs.getInt(8)));
                reclamos.add(reclamo);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reclamos;
    }

    // busca los reclamos hechos en la fecha ingresada


    public List<Reclamo> buscarPorFecha(Date a) throws SinConexionException {

        List<Reclamo> reclamos = new ArrayList<Reclamo>();
        try {

            PreparedStatement pstatementSelect = conexion.getConexion().prepareStatement("SELECT * FROM Reclamo WHERE fecha=? ");
            pstatementSelect.setDate(1, a);
            ResultSet rs = pstatementSelect.executeQuery();

            while (rs.next()) {

                Reclamo reclamo = new Reclamo();
                reclamo.setId(rs.getInt(1));
                reclamo.setTitulo(rs.getString(2));
                reclamo.setDescripcion(rs.getString(3));
                reclamo.setFecha(rs.getDate(4));
                reclamo.setRegion(rs.getString(5));

                TipoDAO tipoDao = new TipoDAO(this.conexion);
                EstadoDAO estadoDao = new EstadoDAO(this.conexion);
                UsuarioDAO usuarioDao = new UsuarioDAO(this.conexion);

                reclamo.setTipo((Tipo) tipoDao.buscartipoconid((rs.getInt(6))));
                reclamo.setUsuario(usuarioDao.obtenerPorId(rs.getInt(7)));
                reclamo.setEstado((Estado) estadoDao.buscarEstadoporId(rs.getInt(8)));
                reclamos.add(reclamo);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reclamos;
    }

    //busca los reclamos de acuerdo al estado ingresado



    public List<Reclamo> buscarPorEstado(Estado a) throws SinConexionException {

        List<Reclamo> reclamos = new ArrayList<Reclamo>();
        try {

            PreparedStatement pstatementSelect = conexion.getConexion().prepareStatement("SELECT * FROM Reclamo WHERE Estado_Id=? ");
            pstatementSelect.setInt(1, a.getId());
            ResultSet rs = pstatementSelect.executeQuery();

            while (rs.next()) {

                Reclamo reclamo = new Reclamo();
                reclamo.setId(rs.getInt(1));
                reclamo.setTitulo(rs.getString(2));
                reclamo.setDescripcion(rs.getString(3));
                reclamo.setFecha(rs.getDate(4));
                reclamo.setRegion(rs.getString(5));

                TipoDAO tipoDao = new TipoDAO(this.conexion);
                EstadoDAO estadoDao = new EstadoDAO(this.conexion);
                UsuarioDAO usuarioDao = new UsuarioDAO(this.conexion);

                reclamo.setTipo((Tipo) tipoDao.buscartipoconid((rs.getInt(6))));
                reclamo.setUsuario(usuarioDao.obtenerPorId(rs.getInt(7)));
                reclamo.setEstado((Estado) estadoDao.buscarEstadoporId(rs.getInt(8)));
                reclamos.add(reclamo);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reclamos;
    }

    // permite cambiar el estado de un reclamo

    public void cambiarEstado (int idParaBuscar, int idModificado) throws SinConexionException {
        try {


            PreparedStatement pstatementUpdate = conexion.getConexion().prepareStatement("UPDATE Reclamo SET estado_idEstado= ? WHERE id= ?;");

            pstatementUpdate.setInt(1, idModificado);
            pstatementUpdate.setInt(2, idParaBuscar);
            pstatementUpdate.executeUpdate();

            int resultUpdate = pstatementUpdate.executeUpdate();

            System.out.println(resultUpdate);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<Reclamo> ordenarPorEstado(Estado a)throws SinConexionException{
        List<Reclamo> reclamos= new ArrayList<Reclamo>();

        try{
            PreparedStatement pstatementSelect = conexion.getConexion().prepareStatement("SELECT * FROM Reclamo WHERE ORDER BY estado_idEstado ASC ");
            ResultSet rs = pstatementSelect.executeQuery();

            while (rs.next()) {

                Reclamo reclamo = new Reclamo();
                reclamo.setId(rs.getInt(1));
                reclamo.setTitulo(rs.getString(2));
                reclamo.setDescripcion(rs.getString(3));
                reclamo.setFecha(rs.getDate(4));
                reclamo.setRegion(rs.getString(5));

                TipoDAO tipoDao = new TipoDAO(this.conexion);
                EstadoDAO estadoDao = new EstadoDAO(this.conexion);
                UsuarioDAO usuarioDao = new UsuarioDAO(this.conexion);

                reclamo.setTipo((Tipo) tipoDao.buscartipoconid((rs.getInt(6))));
                reclamo.setUsuario(usuarioDao.obtenerPorId(rs.getInt(7)));
                reclamo.setEstado((Estado) estadoDao.buscarEstadoporId(rs.getInt(8)));
                reclamos.add(reclamo);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reclamos;

    }


}
