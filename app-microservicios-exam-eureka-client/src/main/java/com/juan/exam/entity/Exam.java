package com.juan.exam.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name= "exam")
public class Exam implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nombre;
	//cualquier pregunta que no este asociada a un examen lo va a eliminar con  orphan ya que dara null y no estara asociada a ningun examen
	
	@JsonIgnoreProperties(value= {"exam"}, allowSetters = true)
	@OneToMany(mappedBy = "exam",
			fetch = FetchType.LAZY, 
			cascade = CascadeType.ALL,
			orphanRemoval = true)
	private List<Cuestion> cuestionList;

	public Exam(Long id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	public Exam() {
		this.cuestionList= new ArrayList<Cuestion>();
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

	public List<Cuestion> getCuestionList() {
		return cuestionList;
	}

	public void setCuestionList(List<Cuestion> cuestionList) {
		this.cuestionList = cuestionList;
	}
	//MEJORAR
	public void addCuestion(Cuestion cuestion) {
	this.cuestionList.add(cuestion);
	
	} 
	
	

}
