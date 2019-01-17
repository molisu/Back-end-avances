package cl.accenture.programatufuturo.proyecto.model;

import java.util.List;

public class Rol {
    private int id;
    private String nombre;
    private List<Permisos> permisos;

    public Rol(int id, String nombre, List<Permisos> permisos) {
        this.id = id;
        this.nombre = nombre;
        this.permisos = permisos;
    }
    public Rol(){
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Permisos> getPermisos() {
        return permisos;
    }

    public void setPermisos(List<Permisos> permisos) {
        this.permisos = permisos;
    }
}
