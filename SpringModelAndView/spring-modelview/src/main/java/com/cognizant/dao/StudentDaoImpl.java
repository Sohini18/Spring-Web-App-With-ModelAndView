package com.cognizant.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cognizant.model.Student;

@Repository
@Qualifier("StudentDao")
public class StudentDaoImpl implements StudentDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public String insert(Student s)
	{
		int r=jdbcTemplate.update("INSERT INTO STUDENT(id,name) VALUES(?,?)",s.getId(),s.getName());
		if(r>0)
			return "Success";
		else
			return "Fail";
	}

	public String delete(int id) {
		int r=jdbcTemplate.update("DELETE FROM STUDENT WHERE id=?",id);
		if(r>0)
			return "Success";
		else
			return "Fail";
	}
	
	public String update(Student s) {
		int id=s.getId();
		int r=jdbcTemplate.update("UPDATE STUDENT SET name=? WHERE id=?",s.getName(),id);
		if(r>0)
			return "Success";
		else
			return "Fail";
	}
	public List<Student> getAll() {
		
		List<Student> list=jdbcTemplate.query("SELECT * FROM STUDENT",new BeanPropertyRowMapper(Student.class));
		return list;
	}

}
