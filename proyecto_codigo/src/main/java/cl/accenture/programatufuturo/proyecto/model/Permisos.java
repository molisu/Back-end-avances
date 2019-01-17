package cl.accenture.programatufuturo.proyecto.model;

public class Permisos {
    private String nombre;
    private Rol rol;

    public Permisos(String nombre, Rol rol) {
        this.nombre = nombre;
        this.rol = rol;
    }
    public Permisos() {
        this.nombre = "";
        this.rol = new Rol();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
}

