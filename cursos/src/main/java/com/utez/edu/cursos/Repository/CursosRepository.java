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

}

