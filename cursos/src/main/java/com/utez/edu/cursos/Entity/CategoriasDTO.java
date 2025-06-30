package com.utez.edu.cursos.Entity;

import jakarta.validation.constraints.NotBlank;

public class CategoriasDTO {
	
	private Long categoria_id;
	
	@NotBlank(message = "El nombre es obligatorio")
	private String nombre;
    
	@NotBlank(message = "La descripción es obligatorio")
	private String descripcion;

	@NotBlank(message = "El estado es obligatorio")
	private String estado;

	public CategoriasDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CategoriasDTO(Long categoria_id, @NotBlank(message = "El nombre es obligatorio") String nombre,
			@NotBlank(message = "La descripción es obligatorio") String descripcion,
			@NotBlank(message = "El estado es obligatorio") String estado) {
		super();
		this.categoria_id = categoria_id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.estado = estado;
	}
		
	
	public Long getCategoria_id() {
		return categoria_id;
	}

	public void setCategoria_id(Long categoria_id) {
		this.categoria_id = categoria_id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "CategoriasDTO [categoria_id=" + categoria_id + ", nombre=" + nombre + ", descripcion=" + descripcion
				+ ", estado=" + estado + "]";
	}
	
	


}
