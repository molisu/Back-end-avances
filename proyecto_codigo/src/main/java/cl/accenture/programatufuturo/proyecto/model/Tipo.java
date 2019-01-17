package cl.accenture.programatufuturo.proyecto.model;

public class Tipo {

    private Integer id;
    private String nombre;
    private Integer sla;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setSla(Integer sla) {
        this.sla = sla;
    }

    public Tipo(Integer id, String nombre, Integer sla) {
        this.id = id;
        this.nombre = nombre;
        this.sla = sla;
    }

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getSla() {
        return sla;
    }
    public Tipo(){

    }
}
