package com.juan.exam.service;

import java.util.List;

import com.juan.exam.entity.Exam;
import com.juan.generic.service.GenericService;

public interface ExamService extends GenericService<Exam> {
	
	 List<Exam> findByName(String nameExam);

}
