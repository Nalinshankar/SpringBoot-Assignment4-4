package com.assignment.nalin.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.assignment.nalin.entity.Course;

@Repository
public interface CourseRepository extends CrudRepository<Course, Long> {

	List<Course> findByInstructorId(Long id);
}
