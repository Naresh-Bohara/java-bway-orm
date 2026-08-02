package com.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class MappingTest {
	
	public static void main(String[] args) {
		oneToOne();
	}
	
	static void oneToOne() {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		
		Address addr = new Address();
		addr.setCountry("nepal");
		addr.setCity("Dhangadhi");
		addr.setState("Sudurpaschim");
		
		session.save(addr);
		
		Employee emp = new Employee();
		emp.setFname("Naresh");
		emp.setLname("Bohara");
		emp.setSalary(120000);
		emp.setAddress(addr);
		
		session.save(emp);
		
		session.getTransaction().commit();
		session.close();
	}
}
