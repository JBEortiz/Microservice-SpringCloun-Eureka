package com.juan.user.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.juan.generic.service.GenericServiceImpl;
import com.juan.user.entity.User;
import com.juan.user.repository.UserRepository;

@Service
public class UserServiceImpl extends GenericServiceImpl<User,UserRepository> implements UserService {

	@Override
	@Transactional(readOnly= true)
	public List<User> findByNombreOrApellido(String nombreApellido) {
		return repository.findByNombreOrApellido(nombreApellido);
	}
				
	

}
