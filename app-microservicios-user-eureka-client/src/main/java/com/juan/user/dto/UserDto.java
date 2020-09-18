package com.juan.user.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

public class UserDto {

	private String nombre;
	private String apellido;
	private String emial;
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate startDate;
	private String avatar;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmial() {
		return emial;
	}

	public void setEmial(String emial) {
		this.emial = emial;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
}
