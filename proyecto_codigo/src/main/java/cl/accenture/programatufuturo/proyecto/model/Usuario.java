package cl.accenture.programatufuturo.proyecto.model;

import java.util.Date;

public class Usuario {
    private int id, telefono;
    private String nombre, email, contraseña, nacionalidad, rut, genero;
    private Date ultimoLogin, fechaNac;
    private Rol rol;

    public Usuario(){}

    public Usuario(int id, int telefono, String nombre, String email, String contraseña, String nacionalidad, String rut, String genero, Date ultimoLogin, Date fechaNac, Rol rol) {
        this.id = id;
        this.nombre = nombre;
        this.rut = rut;
        this.telefono = telefono;
        this.email = email;
        this.nacionalidad = nacionalidad;
        this.genero = genero;
        this.ultimoLogin = ultimoLogin;
        this.fechaNac = fechaNac;
        this.rol = rol;
        this.contraseña = contraseña;
    }


    public void setId(int id) {
        this.id = id;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Date getUltimoLogin() {
        return ultimoLogin;
    }

    public void setUltimoLogin(Date ultimoLogin) {
        this.ultimoLogin = ultimoLogin;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public String getNombre() {
        return nombre;
    }

    public String getContraseña() {
        return contraseña;
    }

    public int getId() {
        return id;
    }
}
