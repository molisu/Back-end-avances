package cl.accenture.programatufuturo.proyecto.controller;

import cl.accenture.programatufuturo.proyecto.DAO.Conexion;
import cl.accenture.programatufuturo.proyecto.DAO.ReclamoDAO;
import cl.accenture.programatufuturo.proyecto.exception.SinConexionException;
import  cl.accenture.programatufuturo.proyecto.model.Reclamo;
import cl.accenture.programatufuturo.proyecto.model.Tipo;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController

public class ReclamoController {
    Conexion conexion = new Conexion();

    @PostMapping("/insertarReclamo")
    public void setReclamo(@RequestBody Reclamo reclamo) {
        try {
            ReclamoDAO dao = new ReclamoDAO(conexion);
            dao.insertarReclamo(reclamo);

        } catch (SinConexionException e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/porFecha")
    public List<Reclamo> porFecha() {
        try {
            ReclamoDAO dao = new ReclamoDAO(conexion);
            return dao.ordenarPorFechaASC();

        } catch (SinConexionException e) {
            e.printStackTrace();
            return null;
        }


    }

    @GetMapping("/porTipo")
    public List<Reclamo> porTipo(@RequestBody Tipo tipo) {
        try {
            ReclamoDAO dao = new ReclamoDAO(conexion);
            return dao.mostrarPorTipo(tipo);
        } catch (SinConexionException e) {
            e.printStackTrace();
            return null;
        }

    }


}

