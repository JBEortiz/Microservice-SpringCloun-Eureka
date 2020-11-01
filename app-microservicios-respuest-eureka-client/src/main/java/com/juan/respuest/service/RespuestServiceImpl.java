package com.juan.respuest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.juan.respuest.entity.Respuest;
import com.juan.respuest.repository.RespuestRepository;


@Service	
public class RespuestServiceImpl implements RespuestService {
	
	@Autowired
	RespuestRepository repository;

	@Override
	@Transactional
	public Iterable<Respuest> saveAll(Iterable<Respuest> respuest) {
		return repository.saveAll(respuest);
	}
	
}
