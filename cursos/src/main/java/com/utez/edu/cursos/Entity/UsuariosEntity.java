package com.utez.edu.cursos.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "usuarios")
public class UsuariosEntity {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long usuarios_id ;

    @Column(name = "nombre", nullable = false, length = 100)
	private String nombre;
    
    @Column(name = "apellido_pat", nullable = false, length = 100)
    private String apellido_pat;
    
    @Column(name = "apellido_mat", nullable = false, length = 100)
    private String apellido_mat;
    
    @Column(name = "correo", nullable = false, length = 100)
    private String correo;
    
    @Column(name = "contraseña", nullable = false, length = 100)
    private String contraseña;
    
    @Column(name = "rol", nullable = false, length = 100)
    private String rol; 
    
    @Column(name = "estado", nullable = false)
    private boolean estado;
    
    @Transient
    private String mensaje;
    
    

	public UsuariosEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UsuariosEntity(String nombre, String apellido_pat, String apellido_mat, String correo, String contraseña,
			String rol, boolean estado, String mensaje) {
		super();
		this.nombre = nombre;
		this.apellido_pat = apellido_pat;
		this.apellido_mat = apellido_mat;
		this.correo = correo;
		this.contraseña = contraseña;
		this.rol = rol;
		this.estado = estado;
		this.mensaje = mensaje;
	}

	
	public Long getUsuarios_id() {
		return usuarios_id;
	}

	public void setUsuarios_id(Long usuarios_id) {
		this.usuarios_id = usuarios_id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido_pat() {
		return apellido_pat;
	}

	public void setApellido_pat(String apellido_pat) {
		this.apellido_pat = apellido_pat;
	}

	public String getApellido_mat() {
		return apellido_mat;
	}

	public void setApellido_mat(String apellido_mat) {
		this.apellido_mat = apellido_mat;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	@Override
	public String toString() {
		return "UsuariosEntity [usuarios_id=" + usuarios_id + ", nombre=" + nombre + ", apellido_pat=" + apellido_pat
				+ ", apellido_mat=" + apellido_mat + ", correo=" + correo + ", contraseña=" + contraseña + ", rol="
				+ rol + ", estado=" + estado + ", mensaje=" + mensaje + "]";
	}

    

    
    
	
}
