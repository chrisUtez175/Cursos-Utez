package com.utez.edu.cursos.Entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "categorias")
public class CategoriasEntity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long categoria_id;
	
    @Column(name = "nombre", nullable = true, length = 50)
	private String nombre;
    
    @Column(name = "descripcion", nullable = true, length = 100)
	private String descripcion;

    @Column(name = "estado", nullable = true ,columnDefinition = "BOOL DEFAULT TRUE")
	private boolean estado;

    
    @OneToMany(mappedBy = "cursos_id", cascade = CascadeType.ALL)
    private List <CursosEntity> cursosEntity;
    
	public CategoriasEntity() {
		super();
	}

	public CategoriasEntity(String nombre, String descripcion, boolean estado, List<CursosEntity> cursosEntity) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.estado = estado;
		this.cursosEntity = cursosEntity;
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

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
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
		return "CategoriasEntity{" +
				"categoria_id=" + categoria_id +
				", nombre='" + nombre + '\'' +
				", descripcion='" + descripcion + '\'' +
				", estado=" + estado +
				", cursosEntity=" + cursosEntity +
				'}';
	}
}
