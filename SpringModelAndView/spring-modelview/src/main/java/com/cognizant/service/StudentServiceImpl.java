package com.cognizant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.dao.StudentDao;
import com.cognizant.model.Student;


@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDao dao;
	
	
	public String insert(Student s) {
		
		return dao.insert(s);
	}

	public String delete(int id) {
		
		return dao.delete(id);
	}

	public String update(Student s) {
		
		return dao.update(s);
	}

	public List<Student> getAll() {
		
		return dao.getAll();
	}


}
