package entity;

import java.io.Serializable;
import java.util.Objects;

public class Master implements Serializable {
    private int id;
    private String code;
    private String nombre;
    private String diasLesctivosPrincipales;
    private Universidad universidad;
    private Master masterVinculado;

    public Master() {}

    public Master(int id, String code, String nombre) {
        this.id = id;
        this.code = code;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDiasLesctivosPrincipales() {
        return diasLesctivosPrincipales;
    }

    public void setDiasLesctivosPrincipales(String diasLesctivosPrincipales) {
        this.diasLesctivosPrincipales = diasLesctivosPrincipales;
    }

    public Universidad getUniversidad() {
        return universidad;
    }

    public void setUniversidad(Universidad universidad) {
        this.universidad = universidad;
    }

    public Master getMasterVinculado() {
        return masterVinculado;
    }

    public void setMasterVinculado(Master master_vinculado) {
        this.masterVinculado = master_vinculado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Master master = (Master) o;
        return id == master.id &&
                Objects.equals(code, master.code) &&
                Objects.equals(universidad, master.universidad);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code, universidad);
    }

    @Override
    public String toString() {
        return "Master{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", nombre='" + nombre + '\'' +
                ", diasLesctivosPrincipales='" + diasLesctivosPrincipales + '\'' +
                ", universidad=" + universidad +
                ", masterVinculado=" + masterVinculado +
                '}';
    }
}
