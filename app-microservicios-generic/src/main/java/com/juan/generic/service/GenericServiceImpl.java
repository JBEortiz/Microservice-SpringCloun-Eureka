package com.juan.generic.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


public class GenericServiceImpl<E,J extends JpaRepository<E,Long>> implements GenericService<E> {
	/**
	 * TODO Serivicio Genérico para poder ser usado por todos los microservicios 
	 * Eureka-Cliend, actuando como libreria 
	 * 
	 *  Para poder utilizarlo como libreria debemos coger estos tres elementos
	 *  del pom.xml y añadirlos como dependencias donde queramos utilizarlo
	 *  
	 * <groupId>com.juan.user</groupId>
	 * <artifactId>app-microservicios-generic</artifactId>
	 * <version>0.0.1-SNAPSHOT</version> 
	 */
	
	@Autowired
	protected J repository;

	@Override
	@Transactional(readOnly = true)
	public List<E> getAll() {

		return repository.findAll();
	}

	@Override
	@Transactional
	public void create(E entity) {
		repository.save(entity);

	}

	@Override
	@Transactional(readOnly = true)
	public E findId(Long id) {

		return (E) repository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void  delete(Long id) {
		  repository.deleteById(id);
	}

	

}
