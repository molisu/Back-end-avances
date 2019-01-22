package cl.accenture.programatufuturo.proyecto.model;

import java.util.Date;

public class Usuario {
    private int id, telefono;
    private String nombre, email, contraseña, nacionalidad, rut, genero;
    private Date ultimoLogin, fechaNac;
    private Rol rol;

    public Usuario(){}

    public Usuario(int id, String nombre, String email, String contraseña, Date ultimoLogin, Date fechaNac, int telefono,String nacionalidad, String rut, String genero, Rol rol) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.contraseña = contraseña;
        this.ultimoLogin = ultimoLogin;
        this.fechaNac = fechaNac;
        this.telefono = telefono;
        this.nacionalidad = nacionalidad;
        this.rut = rut;
        this.genero = genero;
        this.rol = rol;

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
