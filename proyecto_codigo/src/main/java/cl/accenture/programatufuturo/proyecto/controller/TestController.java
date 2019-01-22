package cl.accenture.programatufuturo.proyecto.controller;

import cl.accenture.programatufuturo.proyecto.DAO.Conexion;
import cl.accenture.programatufuturo.proyecto.DAO.UsuarioDAO;
import cl.accenture.programatufuturo.proyecto.exception.SinConexionException;
import  cl.accenture.programatufuturo.proyecto.model.Usuario;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class TestController {
    Conexion conexion = new Conexion();

    @GetMapping(value = "hola/{id}")
    public Usuario getCapacitaciones(@PathVariable int id){

        try{
            UsuarioDAO dao= new UsuarioDAO(conexion);
            System.out.println(dao.obtenerPorId(1).getNombre());
            return dao.obtenerPorId(id);

        } catch (SinConexionException e) {
            e.printStackTrace();
            return null;
        }
    }

    @PostMapping("/guardarUsuario")
    public void setUsuario (@RequestBody Usuario usuario){
        try {
            Conexion conexion = new Conexion();
            UsuarioDAO dao = new UsuarioDAO(conexion);
            dao.almacenarUsuario(getCapacitaciones(usuario.getId()));
        } catch (SinConexionException e) {
            e.printStackTrace();
        }
    }
}
