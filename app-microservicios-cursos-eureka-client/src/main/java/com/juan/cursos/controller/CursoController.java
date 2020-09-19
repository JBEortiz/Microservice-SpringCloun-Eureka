package com.juan.cursos.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.juan.cursos.entity.Curso;
import com.juan.cursos.service.CursoService;
import com.juan.generic.controller.GenericController;
import com.juan.user.entity.User;

@RestController
public class CursoController extends GenericController<Curso, CursoService> {

	
	
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
			cursoList.addUsers(user);
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
		cursoList.removeUsers(user);

		return ResponseEntity.ok("Se ha eliminado correctamente");
	}
}
