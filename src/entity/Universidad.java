package entity;

import java.io.Serializable;
import java.util.Objects;

public class Universidad implements Serializable {
    private int id;
    private String nombre;

    public Universidad() {}

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Universidad that = (Universidad) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Universidad{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
