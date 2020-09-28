package com.juan.user.controller;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.juan.generic.controller.GenericController;
import com.juan.user.entity.User;
import com.juan.user.service.UserService;

@RestController
public class UserController extends GenericController<User, UserService> {

	@GetMapping("/filtrar/{nombreApellido}")
	public ResponseEntity<?> getByNombreOrApellido(@PathVariable String nombreApellido) {
		List<User> userList = null;
		try {
			userList = service.findByNombreOrApellido(nombreApellido);
		} catch (DataAccessException e) {
			e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("error");

		}

		return ResponseEntity.ok(userList);
	}

}
