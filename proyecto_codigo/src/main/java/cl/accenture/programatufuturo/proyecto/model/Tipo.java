package cl.accenture.programatufuturo.proyecto.model;

public class Tipo {

    private int id, sla;
    private String nombre;

    public Tipo(){

    }

    public Tipo(int id, String nombre, int sla) {
        this.id = id;
        this.nombre = nombre;
        this.sla = sla;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSla() {
        return sla;
    }

    public void setSla(int sla) {
        this.sla = sla;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
