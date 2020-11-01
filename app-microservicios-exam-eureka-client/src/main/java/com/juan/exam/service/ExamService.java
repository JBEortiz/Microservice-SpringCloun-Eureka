package com.juan.exam.service;

import java.util.List;

import com.juan.exam.entity.Cuestion;
import com.juan.exam.entity.Exam;
import com.juan.generic.service.GenericService;

public interface ExamService extends GenericService<Exam> {

	List<Exam> findByName(String nameExam);

	void setCuestionList(List<Cuestion> cuestionList, Exam exam);

	void addCuestion(Cuestion cuestion, Exam exam);

	void removeCuestion(Cuestion cuestion, Exam exam);

	Exam put(Exam exam, Long id);

}
