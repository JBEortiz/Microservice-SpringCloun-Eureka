package com.juan.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.juan.exam.entity.Exam;

public interface ExamRepository extends JpaRepository<Exam, Long>{

}
