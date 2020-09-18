package com.juan.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.juan.user.entity.User;
import com.juan.user.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
				
	@Autowired
	private UserRepository repository;

	@Override
	@Transactional(readOnly = true)
	public List<User> getAll() {

		return repository.findAll();
	}

	@Override
	@Transactional
	public void create(User user) {
		repository.save(user);

	}

	@Override
	@Transactional(readOnly = true)
	public User findId(Long id) {

		return repository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		repository.deleteById(id);
	}

}
