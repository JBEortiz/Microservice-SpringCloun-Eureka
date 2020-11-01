package com.juan.exam.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.juan.exam.entity.Cuestion;
import com.juan.exam.entity.Exam;
import com.juan.exam.repository.ExamRepository;
import com.juan.generic.service.GenericServiceImpl;
@Service
public class ExamServiceImpl extends GenericServiceImpl<Exam, ExamRepository>implements ExamService{

	@Override
	@Transactional(readOnly= true)
	public List<Exam> findByName(String nameExam) {
		return repository.findByName(nameExam);
	}
		
	
	@Override
	@Transactional
	public void setCuestionList(List<Cuestion> cuestionList, Exam exam) {
		cuestionList.clear();
		cuestionList.forEach(c-> addCuestion(c,exam));
		
	}

	@Override
	@Transactional
	public void addCuestion(Cuestion cuestion, Exam exam) {
		exam.getCuestionList().add(cuestion);
		cuestion.setExam(exam);
	}

	@Override
	@Transactional
	public void removeCuestion(Cuestion cuestion, Exam exam) {
		exam.getCuestionList().remove(cuestion);
	}
	
	@Override
	@Transactional
	public Exam put( Exam exam, Long id) {

		Exam examId = repository.findById(id).get();
		if (examId == null) {
			//LOG
			System.out.println("no hay registros");
		}
		examId.setName(exam.getName());
		List<Cuestion> listCuestion = new ArrayList<Cuestion>();
		examId.getCuestionList().forEach(e -> {
			if (!exam.getCuestionList().contains(e)) {
				listCuestion.add(e);
			}
		});
		listCuestion.forEach(c-> {
			addCuestion(c, examId);
		});
		
		repository.save(examId);
		return examId;
	}

}
