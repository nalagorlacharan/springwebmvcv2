package com.spring.webmvc.v1;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import com.spring.webmvc.v1.model.Student;
import com.spring.webmvc.v1.repository.StudentServer;

@DataJpaTest 
@SpringBootTest// This is used to test JPA repositories
public class StudentServerTest {
    
    @Autowired
    private StudentServer studentServer;  // Inject the actual StudentServer that extends CrudRepository
    
    @Test
    public void testSaveStudent() {
        // Create a new Student object
        Student student = new Student(1, "vyshu", "cherukuru", 66464, 6736373);

        // Save the student using the repository (which is extended by StudentServer)
        Student savedStudent = studentServer.save(student);

        // Assertions
        assertNotNull(savedStudent);  // Ensure the student is saved and returned
        // Check phone number
    }
}

