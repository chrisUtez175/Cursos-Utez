package com.utez.edu.cursos.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import com.utez.edu.cursos.utils.Message;
import com.utez.edu.cursos.utils.TypesResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.utez.edu.cursos.Entity.CategoriasDTO;
import com.utez.edu.cursos.Entity.CategoriasEntity;
import com.utez.edu.cursos.Repository.CategoriaRepository;

@Service
public class CategoriaServiceImpl  implements CategoriaServiceRepository{

	private final CategoriaRepository categoriaRepository;
	private static final Logger logger = LoggerFactory.getLogger(CategoriaServiceImpl.class);

	@Autowired
    public CategoriaServiceImpl(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }
	public ResponseEntity<Message> listarCategoria() {
		List<CategoriasEntity> listaCategoria = categoriaRepository.findAll();
		return new ResponseEntity<>(new Message(listaCategoria, "Listado de categorias ", TypesResponse.SUCCESS), HttpStatus.OK);
	}

	@Override
	public  ResponseEntity<Message> obtenerCategoriaById(Long id) {
		List<CategoriasEntity> listCategoria = categoriaRepository.findAllById(Collections.singleton(id));
		if (listCategoria.isEmpty()) {
			return new ResponseEntity<>(new Message(listCategoria, "Categoria por id ", TypesResponse.SUCCESS), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(new Message("No hay registros ", TypesResponse.WARNING), HttpStatus.BAD_REQUEST);
		}
	}


	public ResponseEntity<Message> guardarCategoria(CategoriasDTO categoria) {
		if(categoria.getNombre().length() > 50){
			return new ResponseEntity<>(new Message("La categoria excede el limite  de caracteres",TypesResponse.WARNING),HttpStatus.BAD_REQUEST);
		}
		if(categoria.getDescripcion().length() > 100){
			return new ResponseEntity<>(new Message("La categoria excede el limite  de caracteres",TypesResponse.WARNING),HttpStatus.BAD_REQUEST);
		}

		CategoriasEntity categoriasNuevas = new CategoriasEntity(categoria.getNombre(),categoria.getDescripcion(),true,categoria.getCursosEntity());
		categoriasNuevas =  categoriaRepository.saveAndFlush(categoriasNuevas);
		if(categoriaRepository == null){
			return new ResponseEntity  <>(new Message("La Categoria no se registró",TypesResponse.ERROR),HttpStatus.BAD_REQUEST);
		}
		logger.info("El registro ha sido realizada correctamente");
		return new ResponseEntity<>(new Message(categoriasNuevas,"La Categoria  se registró correctamente",TypesResponse.SUCCESS),HttpStatus.CREATED);
	}
	@Override
	public ResponseEntity<Message> updateCategoria(CategoriasDTO categoria) {
		Optional<CategoriasEntity> categoriaUpdate = categoriaRepository.findById(categoria.getCategoria_id());

		if(!categoriaUpdate.isPresent()){
			return new ResponseEntity<>(new Message("La respuesta no existe",TypesResponse.ERROR),HttpStatus.NOT_FOUND);
		}
		if(categoria.getNombre().length() > 50){
			return new ResponseEntity<>(new Message("La categoria excede el limite  de caracteres",TypesResponse.WARNING),HttpStatus.BAD_REQUEST);
		}
		if(categoria.getDescripcion().length() > 100){
			return new ResponseEntity<>(new Message("La categoria excede el limite  de caracteres",TypesResponse.WARNING),HttpStatus.BAD_REQUEST);
		}

		CategoriasEntity updatedCategoria = categoriaUpdate.get();
		updatedCategoria.setDescripcion(categoria.getDescripcion());
		updatedCategoria.setNombre(categoria.getNombre());
		updatedCategoria=categoriaRepository.saveAndFlush(updatedCategoria);

		if(updatedCategoria == null){
			return new ResponseEntity<>(new Message("La categoria no se actualizó",TypesResponse.ERROR),HttpStatus.BAD_REQUEST);
		}

		logger.info("La actualización ha sido realizada correctamente");
		return new ResponseEntity<>(new Message(updatedCategoria,"Las categorias se actualizó correctamente",TypesResponse.SUCCESS),HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Message> actualizarEstatus(Long id) {
		Optional<CategoriasEntity> listCategoriasOptional = categoriaRepository.findById(id);
		if(listCategoriasOptional.isPresent()) {
			CategoriasEntity categoria = listCategoriasOptional.get();
			categoria.setEstado(!categoria.isEstado());
			categoria =  categoriaRepository.saveAndFlush(categoria);
			logger.info("La actualización ha sido realizada correctamente");
			return new ResponseEntity<>(new Message(categoria, "La categoria se actualizó correctamente", TypesResponse.SUCCESS), HttpStatus.OK);
		}else{
			logger.info("La actualización no ha sido realizada correctamente");
			return new ResponseEntity<>(new Message("Las categorias no se actualizaron correctamente", TypesResponse.WARNING), HttpStatus.BAD_REQUEST);
		}
	}



	

}
