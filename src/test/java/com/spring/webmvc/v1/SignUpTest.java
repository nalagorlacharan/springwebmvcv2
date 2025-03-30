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
import static org.hamcrest.Matchers.*;

@WebMvcTest(StudentController.class)
@ExtendWith(MockitoExtension.class)
public class SignUpTest {
	@MockBean
	private StudentHelper studentHelper;
	@Autowired
	private MockMvc mockMvc;
	@Test
	public void testSignUp() throws Exception {
		
		mockMvc.perform(MockMvcRequestBuilders.get("/student/signup"))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.view().name("student_signup"))
		.andExpect(MockMvcResultMatchers.model().attributeExists("user"))
		.andExpect(MockMvcResultMatchers.model().attribute("user", hasProperty("id",is(0))));		
	}

}
