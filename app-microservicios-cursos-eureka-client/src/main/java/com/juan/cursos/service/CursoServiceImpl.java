package com.juan.cursos.service;

import org.springframework.stereotype.Service;

import com.juan.cursos.entity.Curso;
import com.juan.cursos.repository.CursoRepository;
import com.juan.generic.service.GenericServiceImpl;
@Service
public class CursoServiceImpl extends GenericServiceImpl<Curso,CursoRepository> implements CursoService{

}
