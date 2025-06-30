package com.utez.edu.cursos.Entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuario_curso")
public class UsuarioCurso {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = true)
    private UsuariosEntity usuario;

    @ManyToOne
    @JoinColumn(name = "curso_id", nullable = true)
    private CursosEntity curso;
    
    @Column(name = "fecha_inscripcion", nullable = true, length = 255)
    private LocalDate fechaInscripcion;
}
