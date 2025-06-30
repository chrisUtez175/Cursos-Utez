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

import com.utez.edu.cursos.Entity.CategoriasDTO;
import com.utez.edu.cursos.Entity.CategoriasEntity;
import com.utez.edu.cursos.Service.CategoriaServiceRepository;

import jakarta.validation.Valid;

@Controller
public class CategoriasController {
	@Autowired
	CategoriaServiceRepository categoriaService ;
	
	@RequestMapping(value = "cursos/registrar/categoria",method = RequestMethod.POST )
	public ResponseEntity<String> guardarActualizarCategoria(@Valid @RequestBody  CategoriasDTO categoria) {
		categoriaService.guardarActualizarCategoria(categoria);
		return ResponseEntity.ok("Categoria ingresada"); 
	}
	
	@RequestMapping(value = "cursos/mostrar/categoria",method = RequestMethod.GET )
	public @ResponseBody List<CategoriasEntity> listarCategoria(){
		return categoriaService.listarCategoria();
	}
	
	@RequestMapping(value = "cursos/actualizar/categoria",method = RequestMethod.POST )
	public  ResponseEntity<String> actualizarCategoria(@Valid @RequestBody  CategoriasDTO categoria) {
		categoriaService.guardarActualizarCategoria(categoria);
		return ResponseEntity.ok("Categoria actualizada"); 
 
	}
	 
	@RequestMapping(value = "cursos/eliminar/categoria/{id}", method = RequestMethod.POST )
	public @ResponseBody List<CategoriasEntity> actualizarEstatus(@PathVariable long id) {
		return categoriaService.actualizarEstatus(id);
	}
	
	@RequestMapping(value = "cursos/obtener/categoria/{id}", method = RequestMethod.GET )
	public @ResponseBody List<CategoriasEntity> obtenerCategoriaById(@PathVariable Long id){
		return categoriaService.obtenerCategoriaById(id);
	}
	
}
