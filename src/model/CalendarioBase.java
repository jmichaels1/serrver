package model;

import java.io.Serializable;

/**
 * Created by J Michael
 */
public class CalendarioBase implements Serializable {

    private String id;
    private int id_universitat;
    private String desc_spa;
    private String desc_cat;
    private Integer week_day;
    private boolean is_summer;
    private boolean is_festivo;
    private boolean is_active;
    private String curso_academico;

    // variables para interfaz
    private String date_format;
    private String dayName;

    /**
     * Metodo Constructor 1
     */
    public CalendarioBase(String id, String date_format, String dayName) {
        this.id = id;
        this.date_format = date_format;
        this.dayName = dayName;
    }


    
    /**
     * Metodo Constructor 2
     * first insert calendario base
     * @param id
     * @param is_summer
     */
    public CalendarioBase(String id, boolean is_summer) {
        this.id = id;
        this.is_summer = is_summer;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getUniversitat() {
        return id_universitat;
    }

    public void setUniversitat(int id_universitat) {
        this.id_universitat = id_universitat;
    }

    public String getDescSpa() {
        return desc_spa;
    }

    public void setDescSpa(String desc_spa) {
        this.desc_spa = desc_spa;
    }

    public String getDescCat() {
        return desc_cat;
    }

    public void setDescCat(String desc_cat) {
        this.desc_cat = desc_cat;
    }

    public Integer getWeek_day() {
        return week_day;
    }

    public void setWeekDay(Integer week_day) {
        this.week_day = week_day;
    }

    public boolean isSummer() {
        return is_summer;
    }

    public void setSummer(boolean is_summer) {
        this.is_summer = is_summer;
    }

    public boolean isFestivo() {
        return is_festivo;
    }

    public void setFestivo(boolean is_festivo) {
        this.is_festivo = is_festivo;
    }

    public boolean isActive() {
        return is_active;
    }

    public void setActive(boolean is_active) {
        this.is_active = is_active;
    }

    public String getCursoAcademico() {
        return curso_academico;
    }

    public void setCursoAcademico(String curso_academico) {
        this.curso_academico = curso_academico;
    }

    public String getDayName() {
        return dayName;
    }

    public void setDayName(String dayName) {
        this.dayName = dayName;
    }

    public String getDate_format() {
        return date_format;
    }

    public void setDate_format(String date_format) {
        this.date_format = date_format;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CalendarioBase that = (CalendarioBase) o;

        return id != null ? id.equals(that.id) : that.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "CalendarioBase{" +
                "id=" + id +
                ", id_universitat=" + id_universitat +
                ", desc_spa='" + desc_spa + '\'' +
                ", desc_cat='" + desc_cat + '\'' +
                ", week_day=" + week_day +
                ", is_summer=" + is_summer +
                ", is_festivo=" + is_festivo +
                ", is_active=" + is_active +
                ", curso_academico='" + curso_academico + '\'' +
                '}';
    }
}
