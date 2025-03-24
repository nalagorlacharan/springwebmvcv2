package com.spring.webmvc.v1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.spring.webmvc.v1.model.Student;
import com.spring.webmvc.v1.repository.StudentServer;
import com.spring.webmvc.v1.service.StudentHelper;
import static org.mockito.Mockito.when;

@SpringBootTest
public class StudentHelperTest {
	@MockBean
	private StudentServer studentServer;
	@InjectMocks
	private StudentHelper studentHepler;
	@org.junit.Test
	public void Test() {
		when(studentServer.save(any(Student.class))).thenReturn(new Student(1,"sai","cherukuru",5454,636363));
		
		Student studentr=studentHepler.register(new Student(11,"xyz","xxxx",66464,565464));
		assertNotNull(studentr);
		assertEquals(1,studentr.getId());
		assertEquals("sai",studentr.getName());
	}

}
