package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.DaoI;
import com.example.demo.model.Student;

@Service
public class ServiceImpl implements ServiceI {

	@Autowired
	private DaoI d;
	
	@Override
	public void addStudent(Student student) {
		
		System.out.println("In Add Stdent");
		d.addStudent(student);
	}

	@Override
	public List<Student> login(Student student) {
		
		List<Student> list=d.login(student);
		return list;
	}

	@Override
	public Student edit(int id) {
		
		System.out.println("In Edit service");
		Student s= d.edit(id);
		return s;
	}

	@Override
	public List<Student> update(Student student) {
		List<Student> list= d.update(student);
		return list;
	}

	@Override
	public List<Student> delete(int id) {
		List<Student> list=d.delete(id);
		return list;
	}



}
