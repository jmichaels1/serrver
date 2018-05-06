package entity;

import java.io.Serializable;

public class PlanificacionCalendarios implements Serializable {
    private CalendarioBase calendarioBase;
    private int dia;
    private Universidad universidad;
    private Sesion sesion;
    private Master master;

    public PlanificacionCalendarios() {
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
}
