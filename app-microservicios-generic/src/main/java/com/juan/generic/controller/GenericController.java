package com.juan.generic.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.juan.generic.service.GenericService;

public class GenericController<E, S extends GenericService<E>> {

	@Autowired
	protected S service;

	@GetMapping
	public ResponseEntity<?> findAllUsersDTO() {

		List<E> entity = new ArrayList<>();

		try {
			entity = service.getAll();
		} catch (DataAccessException e) {
			e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("error");

		}
		if (entity.isEmpty()) {
			return ResponseEntity.ok("No existen registros");
		}

		return ResponseEntity.ok(entity);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> findUserById(@PathVariable Long id) {

		E entity;

		try {
			entity = service.findId(id);
		} catch (DataAccessException e) {
			e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("error");

		}
		if (entity == null) {
			return ResponseEntity.ok("No existen registros");
		}

		return ResponseEntity.ok(entity);

	}

	@PostMapping
	public ResponseEntity<?> createUser(@RequestBody E entity) {

		try {
			service.create(entity);
		} catch (DataAccessException exception) {

			exception.getMessage().concat(": ").concat(exception.getMostSpecificCause().getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("problemas con la conexion");
		}

		return ResponseEntity.status(HttpStatus.CREATED).body(entity);

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteRelationShip(@PathVariable Long id) {
         
		try {
			service.delete(id);
		} catch (DataAccessException exception) {
			exception.getMessage().concat(": ").concat(exception.getMostSpecificCause().getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("error");
		}

		return ResponseEntity.ok("Se ha eliminado con exito");
	}

}
