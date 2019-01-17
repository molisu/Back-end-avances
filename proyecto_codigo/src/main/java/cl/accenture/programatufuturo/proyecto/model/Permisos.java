package cl.accenture.programatufuturo.proyecto.model;

import java.util.List;

public class Permisos {
    private String nombre;
    private List<Rol> rol;

    public Permisos(String nombre, List<Rol>rol) {
        this.nombre = nombre;
        this.rol = rol;
    }
    public Permisos() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Rol> getRol() {
        return rol;
    }

    public void setRol(List<Rol> rol) {
        this.rol = rol;
    }
}

