package com.utez.edu.cursos.Entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CursosDTO {

	private Long cursos_id;

	@NotBlank(message = "El nombre es obligatorio")
	private String nombre;
	
	@NotBlank(message = "La duracion es obligatorio")
	private String duracion;

	@NotBlank(message = "El temario es obligatorio")
	private String temario;
	
	@NotBlank(message = "La descripcion es obligatorio")
	private String descripcion;

	@NotBlank(message = "El estado es obligatorio")
	private String estado;
	
	@NotNull(message = "La categoria es obligatorio")
	private CategoriasEntity categorias;
	 
	private String name_img;

	public Long getCursos_id() {
		return cursos_id;
	}

	public void setCursos_id(Long cursos_id) {
		this.cursos_id = cursos_id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDuracion() {
		return duracion;
	}

	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}

	public String getTemario() {
		return temario;
	}

	public void setTemario(String temario) {
		this.temario = temario;
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


	public CategoriasEntity getCategorias() {
		return categorias;
	}

	public void setCategorias(CategoriasEntity categorias) {
		this.categorias = categorias;
	}

	public String getName_img() {
		return name_img;
	}

	public void setName_img(String name_img) {
		this.name_img = name_img;
	}
	
	


	

}
