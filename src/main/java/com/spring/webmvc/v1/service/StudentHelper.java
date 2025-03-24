package com.spring.webmvc.v1.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.spring.webmvc.v1.model.Student;
import com.spring.webmvc.v1.repository.StudentServer;
@Controller
public class StudentHelper {
	
	@Autowired
	private StudentServer studentServer;
	
	public Student register(Student student) {
		return studentServer.save(student);
	}
	
	public Student modify(Student student) {
		return studentServer.save(student);
	}
	public void remove(int id) {
		studentServer.deleteById(id);
	}
	public Optional<Student> retrive(int id){
		return studentServer.findById(id);
	}
	

}
