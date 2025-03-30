package com.spring.webmvc.v1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.spring.webmvc.v1.model.Student;
import com.spring.webmvc.v1.repository.StudentServer;
import com.spring.webmvc.v1.service.StudentHelper;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ServiceLayerTest {
	@MockBean
	private StudentServer studentServer;
	
	@InjectMocks
	private StudentHelper studentHelper;
	
	@Test
	public void serviceTest() {
		
		when(studentHelper.register(any(Student.class))).thenReturn(new Student(1,"saicharan","cherukuru",523169,939838));
		Student student = new Student(2,"vyshu","cherukuru",64644,8638746);
		Student studentr=studentHelper.register(student);
		assertNotNull(studentr);
		assertEquals("saicharan",studentr.getName());
		assertEquals("cherukuru",studentr.getPlace());
		
		
	}
	
	

}
