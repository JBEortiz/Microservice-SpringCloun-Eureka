package com.juan.user.controller;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.juan.user.dto.UserDto;
import com.juan.user.entity.User;
import com.juan.user.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService service;

	private ModelMapper modelMapper = new ModelMapper();

	@GetMapping
	public ResponseEntity<?> findAllUsersDTO() {

		List<User> user = new ArrayList<>();
		List<UserDto> userDto = new ArrayList<>();

		try {
			user = service.getAll();
		} catch (DataAccessException e) {
			e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("error");

		}
		if (user.isEmpty()) {
			return ResponseEntity.ok("No hay users");
		}
		for (User users : user) {

			userDto.add(modelMapper.map(users, UserDto.class));

		}
		return ResponseEntity.ok(userDto);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> findUserById(@PathVariable Long id) {
		User userId = new User();
		UserDto userDto = new UserDto();
		try {
			userId = service.findId(id);
		} catch (DataAccessException e) {
			e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("error");

		}
		if (userId == null) {
			return ResponseEntity.ok("No hay user");
		}
		userDto = modelMapper.map(userId, UserDto.class);
		return ResponseEntity.ok(userDto);

	}

	@PostMapping
	public ResponseEntity<?> createUser(@RequestBody UserDto userDto) {
		User user = modelMapper.map(userDto, User.class);

		try {
			service.create(user);
		} catch (DataAccessException exception) {

			exception.getMessage().concat(": ").concat(exception.getMostSpecificCause().getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("problemas con la conexion");
		}

		return ResponseEntity.status(HttpStatus.CREATED).body(user);

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
