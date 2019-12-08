package com.example.demo.dao;

import java.util.List;

import com.example.demo.model.Student;

public interface DaoI {
	
	public void addStudent(Student student);
	List<Student> login(Student student);
	Student edit(int id);
	List<Student> update(Student student);
	List<Student> delete(int id);
}
