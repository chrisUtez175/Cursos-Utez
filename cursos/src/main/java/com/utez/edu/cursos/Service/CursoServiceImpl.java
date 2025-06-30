package com.utez.edu.cursos.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utez.edu.cursos.Entity.CategoriasEntity;
import com.utez.edu.cursos.Entity.CursosDTO;
import com.utez.edu.cursos.Entity.CursosEntity;
import com.utez.edu.cursos.Repository.CursosRepository;

@Service
public class CursoServiceImpl  implements CursosServiceRepository{
	
	@Autowired
	CursosRepository cursosRepository;
	
	@Override
	public CursosEntity guardarActualizarCursos(CursosDTO cursos) {
		CursosEntity cursosNuevos = new CursosEntity();
		CategoriasEntity categoriasAsociada = new CategoriasEntity();
		categoriasAsociada.setCategoria_id(cursos.getCategoria());
		
		cursosNuevos.setCursos_id(cursos.getCursos_id());
		cursosNuevos.setNombre(cursos.getNombre());
		cursosNuevos.setDuracion(cursos.getDuracion());
		cursosNuevos.setTemario(cursos.getTemario());
		cursosNuevos.setDescripcion(cursos.getDescripcion());
		cursosNuevos.setEstado(cursos.getEstado());
		cursosNuevos.setName_img(cursos.getName_img());
		cursosNuevos.setCategorias(categoriasAsociada);
		
		return cursosRepository.save(cursosNuevos);
	}

	@Override
	public List<CursosEntity> listarCursos() {
		return cursosRepository.findAll();
	}

	@Override
	public List<CursosEntity> actualizarEstatus(long id) {
		cursosRepository.actualizarEstatus(id);
		return cursosRepository.cursosByID(id) ;
	}

	@Override
	public List<CursosEntity> obtenerCursosById(long id) {
		return cursosRepository.cursosByID(id) ;
	}

}
