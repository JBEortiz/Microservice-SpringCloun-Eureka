package com.juan.cursos.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.juan.cursos.entity.Curso;
import com.juan.cursos.service.CursoService;
import com.juan.exam.entity.Exam;
import com.juan.generic.controller.GenericController;
import com.juan.user.entity.User;

@RestController
public class CursoController extends GenericController<Curso, CursoService> {

	//MEJORAR ARREGLAR
	//MEJORAR ARREGLAR
	//MEJORAR ARREGLAR
	//MEJORAR ARREGLAR
	
	@PutMapping("/{id}/users")
	public ResponseEntity<?> assignUser(@RequestBody List<User> users, @PathVariable Long id) {
		Curso curso = null;
		try {
			curso = service.findId(id);
		} catch (Exception e) {
			// TODO: handle exception
		}

		if (curso == null) {
			return ResponseEntity.ok("No pudo ser asignado con exito");
		}
		Curso cursoList = curso;
		users.forEach(user -> {
			service.addUsers(user, cursoList);
		});
		service.create(cursoList);
		return ResponseEntity.ok(cursoList);
	}

	@PutMapping("/{id}/delete")
	public ResponseEntity<?> deleteUser(@RequestBody User user, @PathVariable Long id) {
		Curso curso = null;
		try {
			curso = service.findId(id);
		} catch (Exception e) {
			// TODO: handle exception
		}
		if (curso == null) {
			return ResponseEntity.ok("No existe este registro para poder eliminarlo");

		}
		Curso cursoList = curso;
		service.removeUsers(user, cursoList);
		

		return ResponseEntity.ok("Se ha eliminado correctamente");
	}
	
	@PutMapping("/{id}/usersExams")
	public ResponseEntity<?> assignExams(@RequestBody List<Exam> exams, @PathVariable Long id) {
		Curso curso = null;
		try {
			curso = service.findId(id);
		} catch (Exception e) {
			// TODO: handle exception
		}

		if (curso == null) {
			return ResponseEntity.ok("No pudo ser asignado con exito");

		}
		Curso cursoList = curso;
		exams.forEach(exam -> {
			service.addExams(exam, cursoList);
		});
		service.create(cursoList);
		return ResponseEntity.ok(cursoList);
	}

	@PutMapping("/{id}/deleteExams")
	public ResponseEntity<?> deleteExams(@RequestBody Exam exam, @PathVariable Long id) {
		Curso curso = null;
		try {
			curso = service.findId(id);
		} catch (Exception e) {
			// TODO: handle exception
		}
		if (curso == null) {
			return ResponseEntity.ok("No existe este examen para poder eliminarlo");

		}
		Curso cursoList = curso;
		service.removeExams(exam, cursoList);
		return ResponseEntity.ok("Se ha eliminado correctamente");
	}
}
