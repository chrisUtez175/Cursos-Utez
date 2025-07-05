package com.utez.edu.cursos.security.token;

import com.utez.edu.cursos.Entity.UsuariosEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class UserDetailsImpl implements UserDetails {

    private final UsuariosEntity usuario;

    public UserDetailsImpl(UsuariosEntity usuario) {
        this.usuario = usuario;
    }

    public static UserDetailsImpl build(UsuariosEntity usuario) {
        return new UserDetailsImpl(usuario);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_" + usuario.getRol().toUpperCase()));
    }

    @Override
    public String getPassword() {
        return usuario.getContraseña();
    }

    @Override
    public String getUsername() {
        return usuario.getCorreo();
    }

    @Override
    public boolean isAccountNonExpired() { return true; }

    @Override
    public boolean isAccountNonLocked() { return true; }

    @Override
    public boolean isCredentialsNonExpired() { return true; }

    @Override
    public boolean isEnabled() {
        return usuario.getEstado().equalsIgnoreCase("activo");
    }

    public UsuariosEntity getUsuario() {
        return usuario;
    }
}
