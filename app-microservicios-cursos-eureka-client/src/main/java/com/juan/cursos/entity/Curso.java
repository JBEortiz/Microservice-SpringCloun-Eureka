package com.juan.cursos.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.juan.user.entity.User;

@Entity
@Table(name = "curso")
public class Curso implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate startDate;
	
	@OneToMany(fetch = FetchType.LAZY)
	private List<User> users;

	public Curso() {
		super();
		this.users= new ArrayList<>();
	}

	public Curso(Long id, String nombre, LocalDate startDate) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.startDate = startDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	public void addUsers(User user) {
		this.users.add(user);
	}
	
	public void removeUsers(User user) {
		this.users.remove(user);
	}

}
