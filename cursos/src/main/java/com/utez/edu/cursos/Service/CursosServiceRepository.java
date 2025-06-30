package com.utez.edu.cursos.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.utez.edu.cursos.Entity.CursosDTO;
import com.utez.edu.cursos.Entity.CursosEntity;

@Service
public interface CursosServiceRepository {
	
	public CursosEntity guardarActualizarCursos(CursosDTO cursos);
	public List<CursosEntity> listarCursos();
	public List<CursosEntity> actualizarEstatus (long id);
	public List<CursosEntity> obtenerCursosById(long id);
}
