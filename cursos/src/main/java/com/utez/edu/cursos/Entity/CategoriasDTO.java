package com.utez.edu.cursos.Entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.Modifying;

import java.util.List;

public class CategoriasDTO {
	@NotNull(groups = {Modifying.class, CategoriasDTO.ChangeStatus.class})
	private Long categoria_id;

	@NotBlank(groups = {CategoriasDTO.Register.class, CategoriasDTO.Modify.class})
	private String nombre;

	@NotBlank(groups = {CategoriasDTO.Register.class, CategoriasDTO.Modify.class})
	private String descripcion;

	@NotBlank(groups = {CategoriasDTO.Register.class, CategoriasDTO.Modify.class})
	private Boolean estado;

	@NotBlank(groups = {CategoriasDTO.Register.class, CategoriasDTO.Modify.class})
	private List<CursosEntity> cursosEntity;

	public CategoriasDTO() {
		super();
		// TODO Auto-generated constructor stub
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

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public List<CursosEntity> getCursosEntity() {
		return cursosEntity;
	}

	public void setCursosEntity(List<CursosEntity> cursosEntity) {
		this.cursosEntity = cursosEntity;
	}

	@Override
	public String toString() {
		return "CategoriasDTO{" +
				"categoria_id=" + categoria_id +
				", nombre='" + nombre + '\'' +
				", descripcion='" + descripcion + '\'' +
				", estado='" + estado + '\'' +
				", cursosEntity=" + cursosEntity +
				'}';
	}

	public interface Register{}
	public interface Modify{}
	public interface ChangeStatus{}

}
