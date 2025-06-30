package com.utez.edu.cursos.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.utez.edu.cursos.Entity.UsuariosDTO;
import com.utez.edu.cursos.Entity.UsuariosEntity;
import com.utez.edu.cursos.Service.UsuariosServiceRepository;

import jakarta.validation.Valid;

@Controller
public class UsuariosController {
	
	@Autowired
	UsuariosServiceRepository usuariosService ;
	
	@RequestMapping(value = "cursos/registrar/usuario",method = RequestMethod.POST )
	public ResponseEntity<String> guardarUsuario(@Valid  @RequestBody UsuariosDTO usuario) {
		usuariosService.guardarActualizarUsuario(usuario);
		return ResponseEntity.ok("Usuario ingresado");
	}
	
	@RequestMapping(value = "cursos/mostrar/usuarios",method = RequestMethod.GET )
	public @ResponseBody List<UsuariosEntity> listarUsuarios(){
		return usuariosService.listaUsuarios();
	}
	
	@RequestMapping(value = "cursos/actualizar/usuario",method = RequestMethod.POST )
	public ResponseEntity<String> actualizarUsuario (@Valid @RequestBody  UsuariosDTO usuario) {
		 usuariosService.guardarActualizarUsuario(usuario);
		return ResponseEntity.ok("Usuario actualizado");
	}
	
	 
	@RequestMapping(value = "cursos/eliminar/usuario/{id}", method = RequestMethod.POST )
	public @ResponseBody List<UsuariosEntity> actualizarEstatus(@PathVariable long id) {
		return usuariosService.actualizarEstatus(id);
	}
	
	@RequestMapping(value = "cursos/obtener/usuario/{id}", method = RequestMethod.GET )
	public @ResponseBody List<UsuariosEntity> obtenerUsuarioById(@PathVariable Long id){
		return usuariosService.obtenerUsuarioById(id);
	}


}
