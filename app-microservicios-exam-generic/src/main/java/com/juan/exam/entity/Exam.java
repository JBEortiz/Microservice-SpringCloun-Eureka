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
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "exam")
public class Exam implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty
	private String name;
	// cualquier pregunta que no este asociada a un examen lo va a eliminar con
	// orphan ya que dara null y no estara asociada a ningun examen

	@JsonIgnoreProperties(value = { "exam" }, allowSetters = true)
	@OneToMany(mappedBy = "exam", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Cuestion> cuestionList;

	public Exam(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	
	public Exam() {
		this.cuestionList = new ArrayList<Cuestion>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Cuestion> getCuestionList() {
		return cuestionList;
	}

	public void setCuestionList(List<Cuestion> cuestionList) {
		this.cuestionList.clear();
	    cuestionList.forEach(c-> this.addCuestion(c));
	}

	// MEJORAR
	public void addCuestion(Cuestion cuestion) {
		this.cuestionList.add(cuestion);
		cuestion.setExam(this);
	}

	public void removeCuestion(Cuestion cuestion) {
		this.cuestionList.remove(cuestion);
		cuestion.setExam(null);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cuestionList == null) ? 0 : cuestionList.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Exam other = (Exam) obj;
		if (cuestionList == null) {
			if (other.cuestionList != null)
				return false;
		} else if (!cuestionList.equals(other.cuestionList))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
		
//	// MEJORAR
//	public void setCuestionList(List<Cuestion> cuestionList) {
//		this.cuestionList.clear();
//	    cuestionList.forEach(c-> this.addCuestion(c));
//	}
//
//
//	public void addCuestion(Cuestion cuestion) {
//		this.cuestionList.add(cuestion);
//		cuestion.setExam(this);
//	}
//
//	public void removeCuestion(Cuestion cuestion) {
//		this.cuestionList.remove(cuestion);
//		cuestion.setExam(null);
//	}

	
	

}
