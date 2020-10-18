package com.juan.exam.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.juan.exam.entity.Exam;

public interface ExamRepository extends JpaRepository<Exam, Long>{
	
	@Query("select a from Exam a where a.name like %?1%")
    List<Exam> findByName(String nameExam);
}
