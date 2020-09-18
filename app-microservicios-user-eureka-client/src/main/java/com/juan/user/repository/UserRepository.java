package com.juan.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.juan.user.entity.User;

public interface UserRepository  extends JpaRepository<User, Long>{

}
