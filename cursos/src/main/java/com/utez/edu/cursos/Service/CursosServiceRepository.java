package com.utez.edu.cursos.Service;

import java.util.List;

import com.utez.edu.cursos.utils.Message;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.utez.edu.cursos.Entity.CursosDTO;
import com.utez.edu.cursos.Entity.CursosEntity;

@Service
public interface CursosServiceRepository {
	public ResponseEntity<Message> listarCursos();
	public ResponseEntity<Message> obtenerCursosById(Long id);
	public ResponseEntity<Message> guardarCursos(CursosDTO cursos);
	public ResponseEntity<Message> actualizarEstatus (Long id);
	public ResponseEntity<Message> actualizarCursos(CursosDTO cursos);

}
