package com.utez.edu.cursos.Service;

import java.util.List;
import java.util.Optional;

import com.utez.edu.cursos.Entity.CursosEntity;
import com.utez.edu.cursos.utils.Message;
import com.utez.edu.cursos.utils.TypesResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.utez.edu.cursos.Entity.UsuariosDTO;
import com.utez.edu.cursos.Entity.UsuariosEntity;
import com.utez.edu.cursos.Repository.UsuariosRepository;

import jakarta.transaction.Transactional;


@Service
public class UsuariosServiceImpl  implements UsuariosServiceRepository{
	private final UsuariosRepository usuariosRepository;
	private static final Logger logger = LoggerFactory.getLogger(CursoServiceImpl.class);

	@Autowired
	public UsuariosServiceImpl(UsuariosRepository usuariosRepository) {
        this.usuariosRepository = usuariosRepository;
    }


	@Override
	public ResponseEntity<Message> listaUsuarios() {
		List<UsuariosEntity> listaUsuarios = usuariosRepository.findAll();
		return new ResponseEntity<>(new Message(listaUsuarios, "Listado de usuarios ", TypesResponse.SUCCESS), HttpStatus.OK);	}

	@Override
	public ResponseEntity<Message> obtenerUsuarioById(Long id) {
		Optional<UsuariosEntity> listaUsuarios = usuariosRepository.findById(id);
		if (listaUsuarios.isPresent()) {
			return new ResponseEntity<>(new Message(listaUsuarios, "Usuario por ID ", TypesResponse.SUCCESS), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(new Message("No hay registros ", TypesResponse.WARNING), HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	public ResponseEntity<Message> actualizarUsuario(UsuariosDTO usuario) {
		Optional<UsuariosEntity> usuarioUpdate = usuariosRepository.findById(usuario.getUsuarios_id());

		if(!usuarioUpdate.isPresent()){
			return new ResponseEntity<>(new Message("El usuario no existe", TypesResponse.ERROR), HttpStatus.NOT_FOUND);
		}
		if(usuario.getNombre().length() > 50){
			return new ResponseEntity<>(new Message("El nombre excede el limite  de caracteres",TypesResponse.WARNING),HttpStatus.BAD_REQUEST);
		}
		if(usuario.getApellido_pat().length() > 100){
			return new ResponseEntity<>(new Message("El apellido peterno excede el limite  de caracteres",TypesResponse.WARNING),HttpStatus.BAD_REQUEST);
		}
		if(usuario.getApellido_mat().length() > 100){
			return new ResponseEntity<>(new Message("El apellido materno excede el limite  de caracteres",TypesResponse.WARNING),HttpStatus.BAD_REQUEST);
		}
		if(usuario.getCorreo().length() > 100){
			return new ResponseEntity<>(new Message("La categoria excede el limite  de caracteres",TypesResponse.WARNING),HttpStatus.BAD_REQUEST);
		}
		if(usuario.getContraseña().length() > 12){
			return new ResponseEntity<>(new Message("La contraseña excede el limite  de caracteres",TypesResponse.WARNING),HttpStatus.BAD_REQUEST);
		}
		if(usuario.getRol().length() > 30){
			return new ResponseEntity<>(new Message("El rol excede el limite  de caracteres",TypesResponse.WARNING),HttpStatus.BAD_REQUEST);
		}

		UsuariosEntity updateUsuario = usuarioUpdate.get();

		updateUsuario.setNombre(usuario.getNombre());
		updateUsuario.setApellido_pat(usuario.getApellido_pat());
		updateUsuario.setApellido_mat(usuario.getApellido_mat());
		updateUsuario.setCorreo(usuario.getCorreo());

		updateUsuario = usuariosRepository.saveAndFlush(updateUsuario);
		if(updateUsuario == null){
			return new ResponseEntity  <>(new Message("El usuario no se actualizo",TypesResponse.ERROR),HttpStatus.BAD_REQUEST);
		}
		logger.info("La actualizacion ha sido realizada correctamente");
		return new ResponseEntity<>(new Message(updateUsuario,"El usuario se actualizo correctamente",TypesResponse.SUCCESS),HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<Message> actualizarEstatus(Long id) {
		Optional<UsuariosEntity> listaUsuarios = usuariosRepository.findById(id);
		if(listaUsuarios.isPresent()){
			UsuariosEntity usuario = listaUsuarios.get();
			usuario.setEstado(!usuario.isEstado());
			usuariosRepository.saveAndFlush(usuario);
			logger.info("La actualización ha sido realizada correctamente");
			return new ResponseEntity<>(new Message(usuario, "El usuario se actualizó correctamente", TypesResponse.SUCCESS), HttpStatus.OK);
		}else{
			logger.info("La actualización no ha sido realizada correctamente");
			return new ResponseEntity<>(new Message("El usuario no se actualizaron correctamente", TypesResponse.WARNING), HttpStatus.BAD_REQUEST);
		}
	}

}
	


