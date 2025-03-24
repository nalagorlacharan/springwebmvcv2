package com.spring.webmvc.v1.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class Student {
	
	@Id
	private int id;
	private String name;
	private String place;
	private long zipcode;
	private long phoneNumber;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public long getZipcode() {
		return zipcode;
	}
	public void setZipcode(long zipcode) {
		this.zipcode = zipcode;
	}
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Student(int id, String name, String place, long zipcode, long phoneNumber) {
		super();
		this.id = id;
		this.name = name;
		this.place = place;
		this.zipcode = zipcode;
		this.phoneNumber = phoneNumber;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(int id) {
		super();
		this.id = id;
	}
	
	

}
