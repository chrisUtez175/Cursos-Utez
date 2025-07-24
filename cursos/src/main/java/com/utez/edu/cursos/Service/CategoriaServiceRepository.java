package com.utez.edu.cursos.Service;

import com.utez.edu.cursos.Entity.CategoriasDTO;
import com.utez.edu.cursos.utils.Message;
import org.springframework.http.ResponseEntity;

public interface CategoriaServiceRepository {
	public  ResponseEntity<Message> guardarCategoria(CategoriasDTO categoria);
	public ResponseEntity<Message> listarCategoria();
	public ResponseEntity<Message> obtenerCategoriaById(Long id);
	public ResponseEntity<Message> updateCategoria(CategoriasDTO categoria);
	public ResponseEntity<Message> actualizarEstatus(Long id);

}
