package com.spring.webmvc.v1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.spring.webmvc.v1.controller.StudentController;
import com.spring.webmvc.v1.service.StudentHelper;

@WebMvcTest(StudentController.class)
@ExtendWith(MockitoExtension.class)
public class StudentTest {
	
	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private StudentHelper studentHelper;
	@Test
	public void test() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/student/signup"))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.view().name("student_signup"))
		.andExpect(MockMvcResultMatchers.model().attributeExists("user"));
			}
	@Test
	public void Test2() throws Exception {
		
		mockMvc.perform(MockMvcRequestBuilders.get("/student/update"))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.view().name("student-update"))
		.andExpect(MockMvcResultMatchers.model().attributeExists("user"))
		.andExpect(MockMvcResultMatchers.model().hasNoErrors());
		
	}
	
	

}
