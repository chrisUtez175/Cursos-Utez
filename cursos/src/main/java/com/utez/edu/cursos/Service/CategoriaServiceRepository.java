package com.utez.edu.cursos.Service;

import java.util.List;

import com.utez.edu.cursos.Entity.CategoriasDTO;
import com.utez.edu.cursos.Entity.CategoriasEntity;

public interface CategoriaServiceRepository {
	public CategoriasDTO guardarActualizarCategoria(CategoriasDTO categoria);
	public List<CategoriasEntity> listarCategoria();
	public List<CategoriasEntity> actualizarEstatus (long id);
	public List<CategoriasEntity> obtenerCategoriaById(long id);
}
