package com.cognizant.dao;

import java.util.List;

import com.cognizant.model.Student;

public interface StudentDao {

	public String insert(Student s);
	public String delete(int id);
	public String update(Student s);
	public List<Student> getAll();
	

}
