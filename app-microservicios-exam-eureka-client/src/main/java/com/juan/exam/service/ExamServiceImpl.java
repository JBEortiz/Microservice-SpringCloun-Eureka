package com.juan.exam.service;

import org.springframework.stereotype.Service;

import com.juan.exam.entity.Exam;
import com.juan.exam.repository.ExamRepository;
import com.juan.generic.service.GenericServiceImpl;
@Service
public class ExamServiceImpl extends GenericServiceImpl<Exam, ExamRepository>implements ExamService{

}