package com.juan.user.service;

import org.springframework.stereotype.Service;

import com.juan.generic.service.GenericServiceImpl;
import com.juan.user.entity.User;
import com.juan.user.repository.UserRepository;

@Service
public class UserServiceImpl extends GenericServiceImpl<User,UserRepository> implements UserService {
				
	

}
