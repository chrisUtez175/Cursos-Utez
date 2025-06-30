package com.utez.edu.cursos.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utez.edu.cursos.Entity.UsuariosDTO;
import com.utez.edu.cursos.Entity.UsuariosEntity;
import com.utez.edu.cursos.Repository.UsuariosRepository;

import jakarta.transaction.Transactional;


@Service
public class UsuariosServiceImpl  implements UsuariosServiceRepository{
	@Autowired
	private UsuariosRepository usuariosRepository;
	
	public UsuariosDTO guardarActualizarUsuario(UsuariosDTO usuario) {
		UsuariosEntity usuarioNuevo = new UsuariosEntity ();
		
		usuarioNuevo.setUsuarios_id(usuario.getUsuarios_id());
		usuarioNuevo.setNombre(usuario.getNombre());
		usuarioNuevo.setApellido_pat(usuario.getApellido_pat());
		usuarioNuevo.setApellido_mat(usuario.getApellido_mat());
		usuarioNuevo.setCorreo(usuario.getCorreo());
		usuarioNuevo.setContraseña(usuario.getContraseña());
		usuarioNuevo.setRol(usuario.getRol());
		usuarioNuevo.setEstado(usuario.getEstado());
		usuariosRepository.save(usuarioNuevo);
		return usuario ;
	}
	
	@Override
	public List<UsuariosEntity> listaUsuarios() {
		return usuariosRepository.findAll();
	}

	@Override
	@Transactional 
	public List<UsuariosEntity> actualizarEstatus(long id) {
		usuariosRepository.actualizarEstatus(id);
		return usuariosRepository.usuarioByID(id);
	}

	@Override
	public List<UsuariosEntity> obtenerUsuarioById(long id) {
		return usuariosRepository.usuarioByID(id);
	}

	
}
	


