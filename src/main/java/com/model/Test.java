package com.model;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

public class Test {

	public static void main(String[] args) {
//		add();
//		getAllStudents();
		updateStudent();
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
		// select * from student
		Criteria ct = session.createCriteria(Student.class);
//						ct.add(Restrictions.eq("college", "KMC"));
						ct.add(Restrictions.gt("age", 23));
		List<Student> slist = ct.list();
		System.out.println(slist);
	}
	
	// update student
	static void updateStudent() {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		
		Student s = (Student) session.get(Student.class, 2);
		s.setAge(40);
		s.setCollege("AMC");
		
		session.update(s); // update sql
		session.getTransaction().commit();
		session.close();
	}
}


