package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Student;

@Repository
public class DaoImpl implements DaoI {

	@Autowired
	private SessionFactory sf;
	
	@Override
	public void addStudent(Student student) {
		
		Session session = sf.openSession();
		session.beginTransaction();
		session.save(student);
		session.getTransaction().commit();
		session.close();
		
	}

	@Override
	public List<Student> login(Student student) {
		
		Boolean flag=false;
		Session session=sf.openSession();
		
		Query query =session.createQuery("From Student");
		List<Student> list= query.getResultList();
		
		for (Student stu : list) {
			if(student.getUname().equals(stu.getUname()) && stu.getPass().equals(stu.getPass()))
			{
				System.out.println("Checked");
				flag=true;
				
				break;
			}
		}
			if(flag==true)
			{
				return list;
			}
		return new ArrayList<>();
		
	}

	@Override
	public Student edit(int id) {
		
		Session session = sf.openSession();
		Student student=session.get(Student.class, id);
		System.out.println(student);
		return student;
	}

	@Override
	public List<Student> update(Student student) {
		
		Session session= sf.openSession();
		session.beginTransaction();
		session.update(student);
		session.getTransaction().commit();
		session.close();
		
		Session session2=sf.openSession();
		
		Query query= session2.createQuery("from Student");
		List<Student> list= query.getResultList();
		System.out.println("DaoImpl Update list");
		
		return list;
		
	}

	@Override
	public List<Student> delete(int id) {
		System.out.println("In DaoImpl delete");
		
		Session session = sf.openSession();
		
		session.beginTransaction();
		Student s=session.get(Student.class, id);
		session.delete(s);
		session.getTransaction().commit();
		session.close();
		
		Session session2=sf.openSession();
		
		Query query= session2.createQuery("from Student");
		List<Student> list= query.getResultList();
		System.out.println("DaoImpl delete list");
		
		return list;
	}

	

	


}
