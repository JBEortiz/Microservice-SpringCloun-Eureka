package com.juan.generic.service;

import java.util.List;




public interface GenericService <E> {
	
	List<E> getAll();
	
	void create(E entity);
	
	E findId(Long id);
	 
	void delete(Long id);
	
	
	
	
	
	
	

}
