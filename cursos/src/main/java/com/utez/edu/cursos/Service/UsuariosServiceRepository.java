package com.utez.edu.cursos.Service;

import java.util.List;

import com.utez.edu.cursos.utils.Message;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.utez.edu.cursos.Entity.UsuariosDTO;
import com.utez.edu.cursos.Entity.UsuariosEntity;


public interface UsuariosServiceRepository {

	public ResponseEntity<Message> listaUsuarios();
	public ResponseEntity<Message> obtenerUsuarioById(Long id);
	//public ResponseEntity<Message> guardarUsuario(UsuariosDTO usuario);
	public ResponseEntity<Message> actualizarEstatus (Long id);
	public ResponseEntity<Message> actualizarUsuario(UsuariosDTO usuario);

}
