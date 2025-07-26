package com.utez.edu.cursos.Controller;

import java.util.List;

import com.utez.edu.cursos.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.utez.edu.cursos.Entity.CursosDTO;
import com.utez.edu.cursos.Entity.CursosEntity;
import com.utez.edu.cursos.Service.CursosServiceRepository;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/cursos")
public class CursosController {
	
	private final CursosServiceRepository cursosServiceRepository;

	@Autowired
	public CursosController(CursosServiceRepository cursosServiceRepository) {
        this.cursosServiceRepository = cursosServiceRepository;
    }

    //@RequestMapping(value = "cursos/registrar/curso",method = RequestMethod.POST )
	@PostMapping("/registrar/curso")
	public ResponseEntity<Message> guardarCurso(@Valid  @RequestBody  CursosDTO cursos) {
		return cursosServiceRepository.guardarCursos(cursos);

	}
	
	//@RequestMapping(value = "cursos/mostrar/curso",method = RequestMethod.GET )
	@GetMapping("/mostrar/curso")
	public ResponseEntity<Message>listarCurso(){
		return cursosServiceRepository.listarCursos();
	}
	
	//@RequestMapping(value = "cursos/actualizar/curso",method = RequestMethod.PUT )
	@PutMapping("/actualizar/curso")
	public ResponseEntity<Message> actualizarCurso(@RequestBody  CursosDTO cursos) {
		return cursosServiceRepository.actualizarCursos(cursos);
	}
	
	 
	//@RequestMapping(value = "cursos/eliminar/curso/{id}", method = RequestMethod.POST )
	@DeleteMapping("/eliminar/curso/{id}")
	public ResponseEntity<Message> actualizarEstatus(@PathVariable long id) {
		return cursosServiceRepository.actualizarEstatus(id);
	}
	
	//@RequestMapping(value = "cursos/obtener/curso/{id}", method = RequestMethod.GET )
	@GetMapping("/obtener/curso/{id}")
	public ResponseEntity<Message> obtenerCursosById(@PathVariable Long id){
		return cursosServiceRepository.obtenerCursosById(id);
	}

}
