package com.juan.cursos.service;

import com.juan.cursos.entity.Curso;
import com.juan.exam.entity.Exam;
import com.juan.generic.service.GenericService;
import com.juan.user.entity.User;

public interface CursoService extends GenericService<Curso>{

	
	void addUsers(User user,Curso curso);
	
	void removeUsers(User user,Curso curso);
	
	void addExams(Exam exam,Curso curso);
	
	void removeExams(Exam exam,Curso curso);
}
