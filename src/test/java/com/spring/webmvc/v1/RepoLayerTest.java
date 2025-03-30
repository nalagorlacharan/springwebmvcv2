package com.spring.webmvc.v1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.spring.webmvc.v1.model.Student;
import com.spring.webmvc.v1.repository.StudentServer;
@DataJpaTest
public class RepoLayerTest {
	
	@Autowired
	private StudentServer studentServer;
	@Test
	public void test() {
		Student studentr=studentServer.save(new Student(1,"saicharan","cherukuru",564547,47353736));
		assertNotNull(studentr);
		assertEquals(1,studentr.getId());
		assertEquals("saicharan",studentr.getName());
		assertEquals("cherukuru",studentr.getPlace());
		
		
	}
	

}
