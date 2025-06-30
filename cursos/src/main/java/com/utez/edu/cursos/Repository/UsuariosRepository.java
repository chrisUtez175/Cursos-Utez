package com.utez.edu.cursos.Repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.utez.edu.cursos.Entity.UsuariosEntity;

import jakarta.transaction.Transactional;

@Repository
public interface UsuariosRepository extends JpaRepository<UsuariosEntity, Long>{
	
	@Modifying
	@Transactional 
	@Query("UPDATE UsuariosEntity u SET u.estado = 'Inactivo' WHERE u.id = :id")
	public void actualizarEstatus(@Param("id") Long id);
	
    @Transactional
	@Query("SELECT u FROM UsuariosEntity u WHERE u.id = :id")
	public List<UsuariosEntity> usuarioByID(@Param("id") Long id);

}
