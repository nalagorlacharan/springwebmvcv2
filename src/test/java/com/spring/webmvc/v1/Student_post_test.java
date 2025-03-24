package com.spring.webmvc.v1;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.MockBeans;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.spring.webmvc.v1.controller.StudentController;
import com.spring.webmvc.v1.model.Student;
import com.spring.webmvc.v1.service.StudentHelper;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.*;
@WebMvcTest(StudentController.class)
@ExtendWith(MockitoExtension.class)
public class Student_post_test {
	@MockBean
	private StudentHelper studentHelper;
	@Autowired
	private MockMvc mockMvc;
	@Test
	public void Test()  throws Exception{
		when(studentHelper.register(any(Student.class))).thenReturn(new Student(12,"sai","cherukuru",23,3455));
		
		mockMvc.perform(MockMvcRequestBuilders.post("/student/postsignup")
	            .param("id", "1")  // Parameters are passed as strings
	            .param("name", "vyshu")
	            .param("place", "cherukuru")
	            .param("zipcode", "43534")
	            .param("phoneNumber", "75373637"))
	            .andExpect(MockMvcResultMatchers.status().isOk())
	            .andExpect(MockMvcResultMatchers.view().name("result"))
	            .andExpect(MockMvcResultMatchers.model().attributeExists("result"))
	            .andExpect(MockMvcResultMatchers.model().attribute("result",hasProperty("id",is(12))));
	           	
		
	}
	

}
