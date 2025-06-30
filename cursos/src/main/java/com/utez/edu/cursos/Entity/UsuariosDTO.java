package com.utez.edu.cursos.Entity;

import jakarta.validation.constraints.NotBlank;

public class UsuariosDTO {

	
	
	private Long usuarios_id ;
	
	@NotBlank(message = "El nombre es obligatorio")
	private String nombre;
    
	@NotBlank(message = "El apellido paterno es obligatorio")
	private String apellido_pat;
    
	@NotBlank(message = "El apellido materno es obligatorio")
	private String apellido_mat;
    
	@NotBlank(message = "El correo es obligatorio")
	private String correo;
    
	@NotBlank(message = "La contraseña es obligatorio")
	private String contraseña;
    
	@NotBlank(message = "El rol es obligatorio")
	private String rol; 
    
	@NotBlank(message = "El estado es obligatorio")
	private String estado;
    
    private String mensaje;
       
	public UsuariosDTO() {
		super();
		// TODO Auto-generated constructor stub
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

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
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
		return "UsuariosDTO [usuarios_id=" + usuarios_id + ", nombre=" + nombre + ", apellido_pat=" + apellido_pat
				+ ", apellido_mat=" + apellido_mat + ", correo=" + correo + ", contraseña=" + contraseña + ", rol="
				+ rol + ", estado=" + estado + ", mensaje=" + mensaje + "]";
	}

    
    
    
}
