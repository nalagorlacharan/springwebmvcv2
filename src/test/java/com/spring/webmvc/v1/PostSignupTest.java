package com.spring.webmvc.v1;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

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
import com.spring.webmvc.v1.model.Student;
import com.spring.webmvc.v1.service.StudentHelper;
import static org.hamcrest.Matchers.*;
@WebMvcTest(StudentController.class)
@ExtendWith(MockitoExtension.class)
public class PostSignupTest {
	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private StudentHelper studentHelper;
	@Test
	public void testPostSignUp() throws Exception {
		
		when(studentHelper.register(any(Student.class))).thenReturn(new Student(1,"saicharan","cherukuru",523169,939838));
		 
		 mockMvc.perform(MockMvcRequestBuilders.post("/student/postsignup")
	                .param("id", "2")  // Converted numbers to Strings
	                .param("name", "vyshu")
	                .param("place", "cherukuru")
	                .param("zipcode", "523169")
	                .param("phoneNumber", "630366"))
	            .andExpect(MockMvcResultMatchers.status().isOk())  // HTTP 200 OK
	            .andExpect(MockMvcResultMatchers.view().name("result"))  // Expect view name "result"
	            .andExpect(MockMvcResultMatchers.model().attributeExists("result"))  // Ensure "result" exists in model
	            .andExpect(MockMvcResultMatchers.model().attribute("result", hasProperty("id", is(1))))
	            .andExpect(MockMvcResultMatchers.model().attribute("result", hasProperty("name", is("saicharan")))); // Checking name="saicharan// Checking id=1
		
	}
	
	

}
