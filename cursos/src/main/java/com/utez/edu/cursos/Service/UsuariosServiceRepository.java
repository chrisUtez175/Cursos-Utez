package com.utez.edu.cursos.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.utez.edu.cursos.Entity.UsuariosDTO;
import com.utez.edu.cursos.Entity.UsuariosEntity;


@Service
public interface UsuariosServiceRepository {
	public UsuariosDTO guardarActualizarUsuario(UsuariosDTO usuario);
	public List<UsuariosEntity> listaUsuarios();
	public List<UsuariosEntity> actualizarEstatus (long id);
	public List<UsuariosEntity> obtenerUsuarioById(long id);
}
