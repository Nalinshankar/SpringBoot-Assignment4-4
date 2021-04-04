package com.assignment.nalin.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.assignment.nalin.entity.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {
	
	

}
