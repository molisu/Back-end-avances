package cl.accenture.programatufuturo.proyecto.model;

import sun.security.provider.certpath.ResponderId;

import java.util.Date;

public class Respuesta {

    private int id;
    private String comentario;
    private Usuario usuario;
    private Reclamo reclamo;
    private Date fecha;

    public Respuesta(){

    }

    public Respuesta(int id, String comentario, Usuario usuario, Reclamo reclamo, Date fecha) {
        this.id = id;
        this.comentario = comentario;
        this.usuario = usuario;
        this.reclamo = reclamo;
        this.fecha = fecha;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Reclamo getReclamo() {
        return reclamo;
    }

    public void setReclamo(Reclamo reclamo) {
        this.reclamo = reclamo;
    }

    public int getId() {
        return id;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario){
       this.comentario = comentario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha){
        this.fecha = fecha;
    }

}

