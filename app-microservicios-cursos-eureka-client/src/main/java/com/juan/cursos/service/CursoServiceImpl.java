package com.juan.cursos.service;

import org.springframework.stereotype.Service;

import com.juan.cursos.entity.Curso;
import com.juan.cursos.repository.CursoRepository;
import com.juan.exam.entity.Exam;
import com.juan.generic.service.GenericServiceImpl;
import com.juan.user.entity.User;
@Service
public class CursoServiceImpl extends GenericServiceImpl<Curso,CursoRepository> implements CursoService{

	@Override
	public void addUsers(User user, Curso curso) {
		curso.getUsers().add(user);
		
	}

	@Override
	public void removeUsers(User user,Curso curso) {
		curso.getUsers().remove(user);
		
	}

	@Override
	public void addExams(Exam exam,Curso curso) {
		curso.getExams().add(exam);
		
	}

	@Override
	public void removeExams(Exam exam,Curso curso) {
		curso.getExams().remove(exam);
		
	}

}
