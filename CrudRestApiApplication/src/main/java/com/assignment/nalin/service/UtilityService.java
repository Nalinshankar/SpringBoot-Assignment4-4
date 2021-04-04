package com.assignment.nalin.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.nalin.entity.Course;
import com.assignment.nalin.entity.Instructor;
import com.assignment.nalin.entity.Student;
import com.assignment.nalin.repository.CourseRepository;
import com.assignment.nalin.repository.InstructorRepository;
import com.assignment.nalin.repository.StudentRepository;

@Service
public class UtilityService {
	
	 @Autowired
	    private StudentRepository studentRepository;
	 
	 @Autowired
	    private CourseRepository courseRepository;
	 
	 @Autowired
	    private InstructorRepository instructorRepository;
	 
	 //to get the list of course for a particular student id 
	 
	 public List<Course> findCoursesByStudentId(Long id){
		 
		 Student student = studentRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("student not found"));
		 
		 List<Course> courses = (List<Course>) student.getCourses();
		 return courses;
	 }
	 
	 //to get the list of students for a particular instructor id
	public List<Student> findStudentsByInstructorId(Long id) {

		Instructor instructor = instructorRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("instructor not found"));
		List<Course> courses = courseRepository.findByInstructorId(id);
		List<Student> allStudents = new ArrayList<>();
		
		for( Course c : courses ) {
			List<Student> students = (List<Student>) c.getStudents();
			allStudents.addAll(students);
		}

		return allStudents;
	}
	 
	 //to get the total course duration for a particular student id
	
	 //to get the list of students for a particular instructor id
		public Long findCourseDurationByStudentId(Long id) {

			List<Course> courses = findCoursesByStudentId(id);
			 Long duration = courses.stream().mapToLong(c ->c.getDuration().longValue()).sum();
			return duration;
		}

}
