package com.juan.user.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.juan.generic.service.GenericService;
import com.juan.user.entity.User;


@Service
public interface UserService extends GenericService<User> {
	
	public List<User> findByNombreOrApellido(String nombreApellido);
	
	
	
	

}
