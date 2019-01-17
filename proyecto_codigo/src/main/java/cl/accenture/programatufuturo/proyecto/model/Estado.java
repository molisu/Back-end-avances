package cl.accenture.programatufuturo.proyecto.model;

public class Estado {

    private int id;
    private String nombre;

    public Estado(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
    public Estado(){
        this.id=0;
        this.nombre="";
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
