package cl.accenture.programatufuturo.proyecto.model;

import java.util.Date;

public class Reclamo {

    private int id;
    private Usuario usuario;
    private String titulo, descripcion, region;
    private Tipo tipo;
    private Estado estado;
    private Date fecha;

    public Reclamo(int id, Usuario usuario, String titulo, String descripcion, String region, Tipo tipo, Estado estado, Date fecha) {
        this.id = id;
        this.usuario = usuario;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.region = region;
        this.tipo = tipo;
        this.estado = estado;
        this.fecha = fecha;
    }

    public Reclamo() {
    }

    public int getId() {
        return id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getRegion() {
        return region;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public Estado getEstado() {
        return estado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
