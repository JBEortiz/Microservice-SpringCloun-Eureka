package com.juan.respuest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.juan.respuest.entity.Respuest;
import com.juan.respuest.service.RespuestService;

@RestController
public class RespuestaController {

	@Autowired
	private RespuestService service;
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Iterable<Respuest> respuests){
		Iterable<Respuest> respuestsDb =null;
		try {
			respuestsDb = service.saveAll(respuests);
		} catch (DataAccessException exception) {

			exception.getMessage().concat(": ").concat(exception.getMostSpecificCause().getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("problemas con la conexion");
		}
		
		return ResponseEntity.ok(respuestsDb);
	}
}
