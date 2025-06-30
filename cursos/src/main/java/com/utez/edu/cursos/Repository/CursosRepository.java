package com.utez.edu.cursos.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.utez.edu.cursos.Entity.CursosEntity;

import jakarta.transaction.Transactional;

@Repository
public interface CursosRepository extends  JpaRepository<CursosEntity, Long> {
	@Modifying
	@Transactional 
	@Query("UPDATE CursosEntity c SET c.estado = 'Inactivo' WHERE c.id = :id")
	public void actualizarEstatus(@Param("id") Long id);
	
    @Transactional
	@Query("SELECT u FROM CursosEntity u WHERE u.id = :id")
	public List<CursosEntity> cursosByID(@Param("id") Long id);
}

