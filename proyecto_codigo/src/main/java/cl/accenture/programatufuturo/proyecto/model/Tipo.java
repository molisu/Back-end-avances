package cl.accenture.programatufuturo.proyecto.model;

public class Tipo {

    private Integer id;
    private String nombre;
    private int sla;

    public Tipo(int id, String nombre, int sla) {
        this.id = id;
        this.nombre = nombre;
        this.sla = sla;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getSla() {
        return sla;
    }
}
