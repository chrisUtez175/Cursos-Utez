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

import com.utez.edu.cursos.Entity.CursosDTO;
import com.utez.edu.cursos.Entity.CursosEntity;
import com.utez.edu.cursos.Service.CursosServiceRepository;

import jakarta.validation.Valid;

@Controller
public class CursosController {
	
	@Autowired
	CursosServiceRepository cursosServiceRepository;
	
	@RequestMapping(value = "cursos/registrar/curso",method = RequestMethod.POST )
	public ResponseEntity<String> guardarCurso(@Valid  @RequestBody  CursosDTO cursos) {
		cursosServiceRepository.guardarActualizarCursos(cursos);
		return ResponseEntity.ok("curso ingresado");
	}
	
	@RequestMapping(value = "cursos/mostrar/curso",method = RequestMethod.GET )
	public @ResponseBody List<CursosEntity> listarCurso(){
		return cursosServiceRepository.listarCursos();
	}
	
	@RequestMapping(value = "cursos/actualizar/curso",method = RequestMethod.PUT )
	public ResponseEntity<String> actualizarCurso(@RequestBody  CursosDTO cursos) {
		cursosServiceRepository.guardarActualizarCursos(cursos);
		return ResponseEntity.ok("Curso actualizado");
	}
	
	 
	@RequestMapping(value = "cursos/eliminar/curso/{id}", method = RequestMethod.POST )
	public @ResponseBody List<CursosEntity> actualizarEstatus(@PathVariable long id) {
		return cursosServiceRepository.actualizarEstatus(id);
	}
	
	@RequestMapping(value = "cursos/obtener/curso/{id}", method = RequestMethod.GET )
	public @ResponseBody List<CursosEntity> obtenerCursosById(@PathVariable Long id){
		return cursosServiceRepository.obtenerCursosById(id);
	}

}
