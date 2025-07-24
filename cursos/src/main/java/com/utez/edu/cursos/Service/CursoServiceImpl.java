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

import com.utez.edu.cursos.Entity.CategoriasEntity;
import com.utez.edu.cursos.Entity.CursosDTO;
import com.utez.edu.cursos.Entity.CursosEntity;
import com.utez.edu.cursos.Repository.CursosRepository;

@Service
public class CursoServiceImpl  implements CursosServiceRepository{
	private final CursosRepository cursosRepository;
	private static final Logger logger = LoggerFactory.getLogger(CursoServiceImpl.class);

	@Autowired
	public CursoServiceImpl(CursosRepository cursosRepository) {
        this.cursosRepository = cursosRepository;
    }

	@Override
	public ResponseEntity<Message> listarCursos() {
		List<CursosEntity> listaCursos = cursosRepository.findAll();
		return new ResponseEntity<>(new Message(listaCursos, "Listado de cursos ", TypesResponse.SUCCESS), HttpStatus.OK);
	}

	@Override
	public  ResponseEntity<Message> obtenerCursosById(Long id) {
		Optional<CursosEntity> listaCursos = cursosRepository.findById(id);
		if (listaCursos.isPresent()) {
			return new ResponseEntity<>(new Message(listaCursos, "Categoria por id ", TypesResponse.SUCCESS), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(new Message("No hay registros ", TypesResponse.WARNING), HttpStatus.BAD_REQUEST);
		}
	}


	@Override
	public ResponseEntity<Message> guardarCursos(CursosDTO cursos) {
		if(cursos.getNombre().length() > 50){
			return new ResponseEntity<>(new Message("La categoria excede el limite  de caracteres",TypesResponse.WARNING),HttpStatus.BAD_REQUEST);
		}
		if(cursos.getDuracion().length() > 100){
			return new ResponseEntity<>(new Message("La categoria excede el limite  de caracteres",TypesResponse.WARNING),HttpStatus.BAD_REQUEST);
		}
		if(cursos.getTemario().length() > 255){
			return new ResponseEntity<>(new Message("La categoria excede el limite  de caracteres",TypesResponse.WARNING),HttpStatus.BAD_REQUEST);
		}
		if(cursos.getDescripcion().length() > 255){
			return new ResponseEntity<>(new Message("La categoria excede el limite  de caracteres",TypesResponse.WARNING),HttpStatus.BAD_REQUEST);
		}


		CursosEntity cursosNuevos = new CursosEntity(cursos.getNombre(),cursos.getDuracion(),cursos.getTemario(),cursos.getDescripcion(),true,cursos.getCategorias());
		cursosNuevos = cursosRepository.save(cursosNuevos);

		if(cursosNuevos== null){
			return new ResponseEntity  <>(new Message("El curso no se registró",TypesResponse.ERROR),HttpStatus.BAD_REQUEST);
		}

		logger.info("El registro ha sido realizada correctamente");
		return new ResponseEntity<>(new Message(cursosNuevos,"El curso se registró correctamente",TypesResponse.SUCCESS),HttpStatus.CREATED);

	}


	@Override
	public ResponseEntity<Message> actualizarCursos(CursosDTO cursos) {
		Optional<CursosEntity> cursoUpdate = cursosRepository.findById(cursos.getCursos_id());
		if(!cursoUpdate.isPresent()){
			return new ResponseEntity<>(new Message("El curso no existe", TypesResponse.ERROR), HttpStatus.NOT_FOUND);
		}


		if(cursos.getNombre().length() > 50){
			return new ResponseEntity<>(new Message("La categoria excede el limite  de caracteres",TypesResponse.WARNING),HttpStatus.BAD_REQUEST);
		}
		if(cursos.getDuracion().length() > 100){
			return new ResponseEntity<>(new Message("La categoria excede el limite  de caracteres",TypesResponse.WARNING),HttpStatus.BAD_REQUEST);
		}
		if(cursos.getTemario().length() > 255){
			return new ResponseEntity<>(new Message("La categoria excede el limite  de caracteres",TypesResponse.WARNING),HttpStatus.BAD_REQUEST);
		}
		if(cursos.getDescripcion().length() > 255){
			return new ResponseEntity<>(new Message("La categoria excede el limite  de caracteres",TypesResponse.WARNING),HttpStatus.BAD_REQUEST);
		}

        CursosEntity cursoSave = cursoUpdate.get();
        cursoSave.setNombre(cursos.getNombre());
        cursoSave.setDuracion(cursos.getDuracion());
        cursoSave.setTemario(cursos.getTemario());
        cursoSave.setDescripcion(cursos.getDescripcion());

        cursoSave = cursosRepository.saveAndFlush(cursoSave);

		if(cursoSave == null){
			return new ResponseEntity  <>(new Message("El curso no se actualizo",TypesResponse.ERROR),HttpStatus.BAD_REQUEST);
		}

		logger.info("La actualizacion ha sido realizada correctamente");
		return new ResponseEntity<>(new Message(cursoSave,"El curso se actualizo correctamente",TypesResponse.SUCCESS),HttpStatus.CREATED);

	}

	@Override
	public ResponseEntity<Message> actualizarEstatus(Long id) {
		Optional<CursosEntity> listCursosOptional = cursosRepository.findById(id);
		if(listCursosOptional.isPresent()) {
			CursosEntity curso = listCursosOptional.get();
			curso.setEstado(!curso.isEstado());
			curso =  cursosRepository.saveAndFlush(curso);
			logger.info("La actualización ha sido realizada correctamente");
			return new ResponseEntity<>(new Message(curso, "El curso se actualizó correctamente", TypesResponse.SUCCESS), HttpStatus.OK);
		}else{
			logger.info("La actualización no ha sido realizada correctamente");
			return new ResponseEntity<>(new Message("El curso no se actualizaron correctamente", TypesResponse.WARNING), HttpStatus.BAD_REQUEST);
		}
	}


	/*
	@Override
	public List<CursosEntity> actualizarEstatus(long id) {
		cursosRepository.actualizarEstatus(id);
		return cursosRepository.cursosByID(id) ;
	}

	@Override
	public List<CursosEntity> obtenerCursosById(long id) {
		return cursosRepository.cursosByID(id) ;
	}
	*/
}
