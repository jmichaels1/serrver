package entity;

import java.io.Serializable;
import java.util.Objects;

public class CalendarioBase implements Serializable {
    private int dia;
    private Universidad universidad;
    private String descSpa;
    private String descCat;
    private Integer weekDay;
    private boolean isSummer;
    private boolean isFestivo;
    private boolean isActive = true;
    private String cursoAcademico;

    // Solo para interfaz
    private String idDate;

    public CalendarioBase() {}

    public CalendarioBase(int dia, Universidad universidad, String descSpa, Integer weekDay,
                          String idDate, String cursoAcademico) {
        this.dia = dia;
        this.universidad = universidad;
        this.descSpa = descSpa;
        this.weekDay = weekDay;
        this.cursoAcademico = cursoAcademico;
        this.idDate = idDate;
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

    public String getDescSpa() {
        return descSpa;
    }

    public void setDescSpa(String descSpa) {
        this.descSpa = descSpa;
    }

    public String getDescCat() {
        return descCat;
    }

    public void setDescCat(String descCat) {
        this.descCat = descCat;
    }

    public Integer getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(Integer weekDay) {
        this.weekDay = weekDay;
    }

    public boolean isSummer() {
        return isSummer;
    }

    public void setSummer(boolean summer) {
        isSummer = summer;
    }

    public boolean isFestivo() {
        return isFestivo;
    }

    public void setFestivo(boolean festivo) {
        isFestivo = festivo;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getCursoAcademico() {
        return cursoAcademico;
    }

    public void setCursoAcademico(String cursoAcademico) {
        this.cursoAcademico = cursoAcademico;
    }

    public String getIdDate() {
        return idDate;
    }

    public void setIdDate(String idDate) {
        this.idDate = idDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CalendarioBase that = (CalendarioBase) o;
        return dia == that.dia &&
                Objects.equals(universidad, that.universidad) &&
                Objects.equals(idDate, that.idDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dia, universidad, idDate);
    }

    @Override
    public String toString() {
        return "CalendarioBase{" +
                "dia=" + dia +
                ", universidad=" + universidad +
                ", descSpa='" + descSpa + '\'' +
                ", descCat='" + descCat + '\'' +
                ", weekDay=" + weekDay +
                ", isSummer=" + isSummer +
                ", isFestivo=" + isFestivo +
                ", isActive=" + isActive +
                ", cursoAcademico='" + cursoAcademico + '\'' +
                ", idDate='" + idDate + '\'' +
                '}';
    }
}
