package entity;

import java.io.Serializable;
import java.util.Date;

public class Token implements Serializable {
    private int id;
    private String token;
    private Usuario usuario;
    private Date caduca;
    private boolean activo;

    public Token() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Date getCaduca() {
        return caduca;
    }

    public void setCaduca(Date caduca) {
        this.caduca = caduca;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}
