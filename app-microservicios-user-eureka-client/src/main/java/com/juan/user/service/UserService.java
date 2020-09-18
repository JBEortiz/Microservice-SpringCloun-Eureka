package com.juan.user.service;

import java.util.List;

import com.juan.user.entity.User;



public interface UserService  {
	
	List<User> getAll();
	
	void create(User user);
	
	User findId(Long id);
	 
	void delete(Long id);
	
	
	
	
	

}
