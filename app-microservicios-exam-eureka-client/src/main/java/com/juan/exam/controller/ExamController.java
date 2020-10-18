package com.juan.exam.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.juan.exam.entity.Cuestion;
import com.juan.exam.entity.Exam;
import com.juan.exam.service.ExamService;
import com.juan.generic.controller.GenericController;

@RestController
public class ExamController extends GenericController<Exam, ExamService> {

	@PutMapping("/{id}")
	public ResponseEntity<?> put(@RequestBody Exam exam, @PathVariable Long id) {

		Exam examId;
		try {
			examId = service.findId(id);
		} catch (DataAccessException e) {
			e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("error");

		}
		if (examId == null) {
			 ResponseEntity.ok("No existen registros de examenes");
		}
		examId.setName(exam.getName());
		List<Cuestion> listCuestion = new ArrayList<Cuestion>();
		examId.getCuestionList().forEach(e -> {
			if (!exam.getCuestionList().contains(e)) {
				listCuestion.add(e);
			}
		});
		listCuestion.forEach(exam::removeCuestion);
		examId.setCuestionList(exam.getCuestionList());
		service.create(examId);
		return ResponseEntity.ok(examId);
	}
	
	
	
	@GetMapping("/filtrar/{nameExam}")
	public ResponseEntity<?> getByNameExam(@PathVariable String nameExam) {
		List<Exam> examList = null;
		try {
			examList = service.findByName(nameExam);
		} catch (DataAccessException e) {
			e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage());
			 ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("error");

		}

		return ResponseEntity.ok(examList);
	}


}
