package com.spring.webmvc.v1.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.webmvc.v1.model.Student;
@Repository
public interface StudentServer extends CrudRepository<Student,Integer> {

}
