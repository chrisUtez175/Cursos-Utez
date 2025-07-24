package com.utez.edu.cursos.Controller;

import java.util.List;

import com.utez.edu.cursos.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.utez.edu.cursos.Entity.CategoriasDTO;
import com.utez.edu.cursos.Entity.CategoriasEntity;
import com.utez.edu.cursos.Service.CategoriaServiceRepository;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/cursos")
public class CategoriasController {

	private final CategoriaServiceRepository categoriaService ;

	@Autowired
	public CategoriasController(CategoriaServiceRepository categoriaService) {
        this.categoriaService = categoriaService;
    }

	//@RequestMapping(value = "cursos/registrar/categoria",method = RequestMethod.POST )
	@PostMapping("/registrar/categoria")
	public ResponseEntity<Message> guardarCategoria(@Valid @RequestBody  CategoriasDTO categoria) {
		return categoriaService.guardarCategoria(categoria);
	}
	
	//@RequestMapping(value = "cursos/mostrar/categoria",method = RequestMethod.GET )
	@GetMapping("/mostrar/categorias")
	public ResponseEntity<Message> listarCategoria(){
		return categoriaService.listarCategoria();
	}
	
	//@RequestMapping(value = "cursos/actualizar/categoria",method = RequestMethod.POST )
	@PutMapping("/actualizar/categoria")
	public  ResponseEntity<Message> actualizarCategoria(@Valid @RequestBody  CategoriasDTO categoria) {
		return 	categoriaService.updateCategoria(categoria);
	}
	 
	//@RequestMapping(value = "cursos/eliminar/categoria/{id}", method = RequestMethod.POST )
	@DeleteMapping("/eliminar/categoria/{id}")
	public ResponseEntity<Message> actualizarEstatus(@PathVariable long id) {
		return categoriaService.actualizarEstatus(id);
	}
	
	//@RequestMapping(value = "cursos/obtener/categoria/{id}", method = RequestMethod.GET )
	@GetMapping("/obtener/categoria/{id}")
	public ResponseEntity<Message> obtenerCategoriaById(@PathVariable Long id){
		return categoriaService.obtenerCategoriaById(id);
	}
	
}
