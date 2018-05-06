package entity;

import java.io.Serializable;
import java.util.Date;

public class Usuario implements Serializable {
    private int id;
    private String avatar;
    private String nick;
    private String email;
    private String password;
    private Universidad universidad;
    private Roles rol;
    private int num_auth_failed;
    private Date last_auth_failed;

    public Usuario() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Universidad getUniversidad() {
        return universidad;
    }

    public void setUniversidad(Universidad universidad) {
        this.universidad = universidad;
    }

    public Roles getRol() {
        return rol;
    }

    public void setRol(Roles rol) {
        this.rol = rol;
    }

    public int getNumAuthFailed() {
        return num_auth_failed;
    }

    public void setNumAuthFailed(int num_auth_failed) {
        this.num_auth_failed = num_auth_failed;
    }

    public Date getLastAuthFailed() {
        return last_auth_failed;
    }

    public void setLastAuthFailed(Date last_auth_failed) {
        this.last_auth_failed = last_auth_failed;
    }
}
