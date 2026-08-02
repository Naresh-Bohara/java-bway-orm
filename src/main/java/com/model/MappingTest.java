package com.model;

import java.util.Arrays;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class MappingTest {
	
	public static void main(String[] args) {
//		oneToOne();
//		oneToMany();
		manyToMany();
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
	
	static void oneToMany() {
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

		
		Phone p1 = new Phone();
		p1.setNumber("9812345678");
		p1.setType("NCELL");
		p1.setEmployee(emp);
		session.save(p1);
		
		Phone p2 = new Phone();
		p2.setNumber("9742123456");
		p2.setType("NTC");
		p2.setEmployee(emp);
		session.save(p2);
		
		emp.setPhoneList(Arrays.asList(p1, p2));
		
		session.save(emp);
		session.getTransaction().commit();
		session.close();
	}
	
	static void manyToMany() {
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

		
		Phone p1 = new Phone();
		p1.setNumber("9812345678");
		p1.setType("NCELL");
		p1.setEmployee(emp);
		session.save(p1);
		
		Phone p2 = new Phone();
		p2.setNumber("9742123456");
		p2.setType("NTC");
		p2.setEmployee(emp);
		session.save(p2);
		
		Department d1 = new Department();
		d1.setName("QA");
		session.save(d1);
		
		Department d2 = new Department();
		d2.setName("Sales");
		session.save(d2);
		
		emp.setDeptList(Arrays.asList(d1,d2));
		
		emp.setPhoneList(Arrays.asList(p1, p2));
		
		session.save(emp);
		session.getTransaction().commit();
		session.close();
	}
}
