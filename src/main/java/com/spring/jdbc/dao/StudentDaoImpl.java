package com.spring.jdbc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.spring.jdbc.entities.Student;

@Component("studentDao")
public class StudentDaoImpl implements StudentDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	@Override
	public int insert(Student student) {
		String query="insert into student(id,name,city) values(?,?,?)";
		int r = this.jdbcTemplate.update(query,student.getId(),student.getName(),student.getCity());
		return r;
	}
	@Override
	public int change(Student student) {
		String query="update student set name=?,city=? where id=?";
		int r = this.jdbcTemplate.update(query,student.getName(),student.getCity(),student.getId());
		return r;
	}
	@Override
	public int delete(int studentID) {
		// delete operation
		String query="delete from student where id=?";
		int r = this.jdbcTemplate.update(query,studentID);
		return r;
	}
	@Override
	public Student getStudent(int studentId) {
		//select single student data
		//we need the jdbcTemplate method known as queryForObject()
		//this methods need rowMapper... so what is this rowMapper
		//it is interface which converts the resultSet data into the
		//user defined object but we need to implement this interface in 
		//RowMapperImpl class
		String query="select * from student where id=?;";
		RowMapper<Student> rowMapper = new RowMapperImpl();
		
		Student student = this.jdbcTemplate.queryForObject(query, rowMapper,studentId);
		//now this will return the student object with id "studentId"
		return student;
		//student object we have returned here
	}
	@Override
	public List<Student> getAllStudent() {
		// Selecting multiple student
		String query ="select * from student";
		List<Student> studentList = this.jdbcTemplate.query(query, new RowMapperImpl());
		
		return studentList;
	}
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
}
