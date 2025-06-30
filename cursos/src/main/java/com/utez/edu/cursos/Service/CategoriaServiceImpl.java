package com.utez.edu.cursos.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utez.edu.cursos.Entity.CategoriasDTO;
import com.utez.edu.cursos.Entity.CategoriasEntity;
import com.utez.edu.cursos.Repository.CategoriaRepository;

@Service
public class CategoriaServiceImpl  implements CategoriaServiceRepository{
	
	@Autowired
	CategoriaRepository categoriaRepository;
	
	
	public CategoriasDTO guardarActualizarCategoria(CategoriasDTO categoria) {
		CategoriasEntity categoriasNuevas = new CategoriasEntity();
		
		categoriasNuevas.setCategoria_id(categoria.getCategoria_id());
		categoriasNuevas.setNombre(categoria.getNombre());
		categoriasNuevas.setDescripcion(categoria.getDescripcion());
		categoriasNuevas.setEstado(categoria.getEstado());
		categoriaRepository.save(categoriasNuevas);
		return categoria;
	}

	
	public List<CategoriasEntity> listarCategoria() {
		return categoriaRepository.findAll() ;
	}


	@Override
	public List<CategoriasEntity> actualizarEstatus(long id) {
		categoriaRepository.actualizarEstatus( id);
		return categoriaRepository.categoriaByID( id);
	}

	@Override
	public List<CategoriasEntity> obtenerCategoriaById(long id) {
		 return categoriaRepository.categoriaByID(id);
	}

	

}
