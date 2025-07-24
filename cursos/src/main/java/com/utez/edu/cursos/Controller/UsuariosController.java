package com.utez.edu.cursos.Controller;

import java.util.List;

import com.utez.edu.cursos.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.utez.edu.cursos.Entity.UsuariosDTO;
import com.utez.edu.cursos.Entity.UsuariosEntity;
import com.utez.edu.cursos.Service.UsuariosServiceRepository;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/usuarios")
public class UsuariosController {

	private final UsuariosServiceRepository usuariosService ;

	@Autowired
	public UsuariosController(UsuariosServiceRepository usuariosService) {
        this.usuariosService = usuariosService;
    }
	/*
    @RequestMapping(value = "cursos/registrar/usuario",method = RequestMethod.POST )
	public ResponseEntity<String> guardarUsuario(@Valid  @RequestBody UsuariosDTO usuario) {
		usuariosService.guardarActualizarUsuario(usuario);
		return ResponseEntity.ok("Usuario ingresado");
	}
	 */
	
	//@RequestMapping(value = "mostrar/usuarios",method = RequestMethod.GET )
	@GetMapping("mostrar/usuarios")
	public  ResponseEntity<Message> listarUsuarios(){
		return usuariosService.listaUsuarios();
	}
	
	//@RequestMapping(value = "actualizar/usuario",method = RequestMethod.POST )
	@PutMapping("actualizar/usuario")
	public  ResponseEntity<Message> actualizarUsuario (@Valid @RequestBody  UsuariosDTO usuario) {
		return usuariosService.actualizarUsuario(usuario);
	}
	
	 
	//@RequestMapping(value = "cursos/eliminar/usuario/{id}", method = RequestMethod.POST )
	@PostMapping("/eliminar/usuario/{id}")
	public  ResponseEntity<Message> actualizarEstatus(@PathVariable long id) {
		return usuariosService.actualizarEstatus(id);
	}
	
	//@RequestMapping(value = "cursos/obtener/usuario/{id}", method = RequestMethod.GET )
	@GetMapping("/obtener/usuario/{id}")
	public  ResponseEntity<Message> obtenerUsuarioById(@PathVariable Long id){
		return usuariosService.obtenerUsuarioById(id);
	}


}
