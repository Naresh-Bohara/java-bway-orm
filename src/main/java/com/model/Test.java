package com.model;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test {

	public static void main(String[] args) {
//		add();
		getAllStudents();
	}
	
	static void add() {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		
		Student s = new Student();
		s.setFname("Harish");
		s.setLname("KC");
		s.setAge(20);
		s.setCollege("SPA");
		
		session.save(s);  //insert sql
		session.getTransaction().commit(); // execute sql
	}
	
	// get all students
	static void getAllStudents() {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		
		Criteria ct = session.createCriteria(Student.class);
		List<Student> slist = ct.list();
		System.out.println(slist);
	}
}


