package com.juan.user.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.juan.user.entity.User;

public interface UserRepository  extends JpaRepository<User, Long>{

	@Query("select a from User a where a.nombre like %?1% or a.apellido like %?1%")
	public List<User> findByNombreOrApellido(String nombreApellido);
	
}
