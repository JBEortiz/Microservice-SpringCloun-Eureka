package com.juan.cursos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.juan.cursos.entity.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long>{

}
