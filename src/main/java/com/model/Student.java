package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student_table")
public class Student {
@Id	//PK
@Column 
@GeneratedValue //AI 
private int id;
@Column(name = "firstName", length = 200, nullable = false)
private String fname;
@Column
private String lname;
@Column
private int age;
@Column
private String college;

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getFname() {
	return fname;
}
public void setFname(String fname) {
	this.fname = fname;
}
public String getLname() {
	return lname;
}
public void setLname(String lname) {
	this.lname = lname;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public String getCollege() {
	return college;
}
public void setCollege(String college) {
	this.college = college;
}
@Override
public String toString() {
	return "\n Student [id=" + id + ", fname=" + fname + ", lname=" + lname + ", age=" + age + ", college=" + college
			+ "]";
}

}
