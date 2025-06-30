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
	
    @Column(name = "nombre", nullable = true, length = 255)
	private String nombre;
    
    @Column(name = "descripcion", nullable = true, length = 255)
	private String descripcion;

    @Column(name = "estado", nullable = true, length = 255)
	private String estado;

    
    @OneToMany(mappedBy = "cursos_id", cascade = CascadeType.ALL)
    private List <CursosEntity> cursosEntity;
    
	public CategoriasEntity() {
		super();
	}

	public CategoriasEntity(Long categoria_id, String nombre, String descripcion, String estado) {
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
		return "CategoriasEntity [categoria_id=" + categoria_id + ", nombre=" + nombre + ", descripcion=" + descripcion
				+ ", estado=" + estado + "]";
	}
    
    

}
