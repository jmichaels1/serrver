package entity;

import java.io.Serializable;
import java.util.Objects;

public class DiaPlanificado implements Serializable {
    private CalendarioBase calendarioBase;
    private int dia;
    private Universidad universidad;
    private Sesion sesion;
    private Master master;
    private Practica campo1;
    private Practica campo2;
    private int version;

    public DiaPlanificado() {}

    public DiaPlanificado(CalendarioBase cb, int dia, Universidad uni, Master master) {
        this.calendarioBase = cb;
        this.dia = dia;
        this.universidad = uni;
        this.master = master;
        version = 1;
    }

    public void aumentVersion(){
        version++;
    }

    public CalendarioBase getCalendarioBase() {
        return calendarioBase;
    }

    public void setCalendarioBase(CalendarioBase calendarioBase) {
        this.calendarioBase = calendarioBase;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public Universidad getUniversidad() {
        return universidad;
    }

    public void setUniversidad(Universidad universidad) {
        this.universidad = universidad;
    }

    public Sesion getSesion() {
        return sesion;
    }

    public void setSesion(Sesion sesion) {
        this.sesion = sesion;
    }

    public Master getMaster() {
        return master;
    }

    public void setMaster(Master master) {
        this.master = master;
    }

    public Practica getCampo1() {
        return campo1;
    }

    public void setCampo1(Practica campo1) {
        this.campo1 = campo1;
    }

    public Practica getCampo2() {
        return campo2;
    }

    public void setCampo2(Practica campo2) {
        this.campo2 = campo2;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DiaPlanificado that = (DiaPlanificado) o;
        return dia == that.dia &&
                version == that.version &&
                Objects.equals(universidad, that.universidad) &&
                Objects.equals(sesion, that.sesion) &&
                Objects.equals(master, that.master) &&
                Objects.equals(campo1, that.campo1) &&
                Objects.equals(campo2, that.campo2);
    }

    @Override
    public int hashCode() {

        return Objects.hash(dia, universidad, sesion, master, campo1, campo2, version);
    }

    @Override
    public String toString() {
        return "DiaPlanificado{" +
                "calendarioBase=" + calendarioBase +
                ", dia=" + dia +
                ", universidad=" + universidad +
                ", sesion=" + sesion +
                ", master=" + master +
                ", campo1=" + campo1 +
                ", campo2=" + campo2 +
                ", version=" + version +
                '}';
    }
}
