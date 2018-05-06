package entity;

import java.io.Serializable;

public class Universidad implements Serializable {
    private int id;
    private String nombre;

    public Universidad() {
    }

    public Universidad(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
