package entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Token implements Serializable {
    private int id;
    private String token;
    private Usuario usuario;
    private Date caduca;
    private boolean activo;

    public Token() {}

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Token token1 = (Token) o;
        return id == token1.id &&
                Objects.equals(token, token1.token);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, token);
    }

    @Override
    public String toString() {
        return "Token{" +
                "id=" + id +
                ", token='" + token + '\'' +
                ", usuario=" + usuario +
                ", caduca=" + caduca +
                ", activo=" + activo +
                '}';
    }
}
