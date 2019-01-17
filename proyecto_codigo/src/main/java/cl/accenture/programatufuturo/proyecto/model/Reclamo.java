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

}
