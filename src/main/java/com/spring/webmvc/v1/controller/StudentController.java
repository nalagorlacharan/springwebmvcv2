package com.spring.webmvc.v1.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.webmvc.v1.model.Student;
import com.spring.webmvc.v1.service.StudentHelper;
@Controller
@RequestMapping("/student")
public class StudentController {
	@Autowired
	private StudentHelper studentHelper;
	
	   @GetMapping("/signup")
	   public ModelAndView signUp() {
		ModelAndView view = new ModelAndView();
		Student student= new Student();
		view.addObject("user",student);
		view.setViewName("student_signup");
		return view;
		}
	   @PostMapping("/postsignup")
	   public ModelAndView postSignUp(@ModelAttribute("user")Student student) {
		   
		   Student student_result=studentHelper.register(student);
		   ModelAndView view = new ModelAndView();
		   view .addObject("result",student_result);
		   view.setViewName("result");
		   return view;
		   
	   }
	   @GetMapping("/update")
	   public ModelAndView update() {
		   ModelAndView view= new ModelAndView();
		   Student student = new Student(0);
		   view.addObject("user", student);
		   view.setViewName("student-update");
		   return view;
	   }
	       @PostMapping("/postupdate")
	       public ModelAndView postUpdate(@ModelAttribute("user")Student student) {
		   Optional<Student> studentr=studentHelper.retrive(student.getId());
		   ModelAndView view= new ModelAndView();
		   view.addObject("result",studentr.get());
		   view.setViewName("result");
		    return view;
		   
		   
		   
	   }
	   
	   
	   
	
	

}
