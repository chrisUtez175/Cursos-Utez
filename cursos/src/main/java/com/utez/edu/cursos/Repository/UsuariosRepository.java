package com.utez.edu.cursos.Repository;

import java.util.List;
import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.utez.edu.cursos.Entity.UsuariosEntity;

import jakarta.transaction.Transactional;

@Repository
public interface UsuariosRepository extends JpaRepository<UsuariosEntity, Long>{


	Optional<UsuariosEntity> findByCorreo(String correo);
	boolean existsByCorreo(String correo);

}
