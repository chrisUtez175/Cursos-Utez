package com.utez.edu.cursos.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "cursos")
public class CursosEntity {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cursos_id;
	
    @Column(name = "nombre", nullable = true, length = 50)
    private String nombre;
    
    @Column(name = "duracion", nullable = true, length = 100)
    private  String duracion;
    
    @Column(name = "temario", nullable = true, length = 255)
    private String temario;
    
    @Column(name = "descripcion", nullable = true, length = 255)
    private String descripcion;
	
    @Column(name = "estado", nullable = true, length = 255)
    private  boolean estado;
    
    @Column(name = "name_img", nullable = true, length = 255)
    private String name_img ;
	
    @ManyToOne
    @JoinColumn(name = "categoria_id", referencedColumnName = "categoria_id")
    private CategoriasEntity categorias;
   

	public CursosEntity() {
		super();
		// TODO Auto-generated constructor stub
	}


	public CursosEntity( String nombre, String duracion, String temario, String descripcion,
						 boolean estado, CategoriasEntity categorias) {
		super();
		this.nombre = nombre;
		this.duracion = duracion;
		this.temario = temario;
		this.descripcion = descripcion;
		this.estado = estado;
		this.categorias = categorias;
	}


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


	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public String getName_img() {
		return name_img;
	}


	public void setName_img(String name_img) {
		this.name_img = name_img;
	}


	public CategoriasEntity getCategorias() {
		return categorias;
	}


	public void setCategorias(CategoriasEntity categorias) {
		this.categorias = categorias;
	}


	@Override
	public String toString() {
		return "CursosEntity [cursos_id=" + cursos_id + ", nombre=" + nombre + ", duracion=" + duracion + ", temario="
				+ temario + ", descripcion=" + descripcion + ", estado=" + estado + ", name_img=" + name_img
				+ ", categorias=" + categorias + "]";
	}


	
    
    
}
