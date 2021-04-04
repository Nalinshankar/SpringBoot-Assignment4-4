package com.assignment.nalin.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.assignment.nalin.entity.Instructor;

@Repository
public interface InstructorRepository extends CrudRepository<Instructor,Long> {

}
