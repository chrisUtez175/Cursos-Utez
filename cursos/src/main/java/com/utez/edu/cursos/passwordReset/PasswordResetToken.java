package com.utez.edu.cursos.passwordReset;

import com.utez.edu.cursos.Entity.UsuariosEntity;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class PasswordResetToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String token;

    private LocalDateTime expirationDate;

    @ManyToOne
    private UsuariosEntity user;

    public PasswordResetToken() {}

    public PasswordResetToken(String token, LocalDateTime expirationDate, UsuariosEntity user) {
        this.token = token;
        this.expirationDate = expirationDate;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public LocalDateTime getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDateTime expirationDate) {
        this.expirationDate = expirationDate;
    }

    public UsuariosEntity getUser() {
        return user;
    }

    public void setUser(UsuariosEntity user) {
        this.user = user;
    }
}