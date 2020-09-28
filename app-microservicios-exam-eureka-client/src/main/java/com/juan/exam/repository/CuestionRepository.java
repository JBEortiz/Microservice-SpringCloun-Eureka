package com.juan.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.juan.exam.entity.Cuestion;


public interface CuestionRepository extends JpaRepository<Cuestion, Long>{

}
