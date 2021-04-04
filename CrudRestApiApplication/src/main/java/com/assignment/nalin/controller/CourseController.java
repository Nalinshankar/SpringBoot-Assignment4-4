package com.assignment.nalin.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.nalin.entity.Course;
import com.assignment.nalin.exception.ResourceNotFoundException;
import com.assignment.nalin.repository.CourseRepository;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/api/v1")
@Api(value="CourseController to perform Add, Update, Delete, Find All and Find by Id operations ")
public class CourseController {
	
	@Autowired
    private CourseRepository courseRepository;

    @GetMapping("/courses")
    public List<Course> getAllCourses() {
        return (List<Course>) courseRepository.findAll();
    }

    @GetMapping("/courses/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable(value = "id") Long courseId)
        throws ResourceNotFoundException {
        Course course = courseRepository.findById(courseId)
          .orElseThrow(() -> new ResourceNotFoundException("Course not found for this id :: " + courseId));
        return ResponseEntity.ok().body(course);
    }
    
    @PostMapping("/courses")
    public Course createCourse(@Valid @RequestBody Course course) {
        return courseRepository.save(course);
    }

    @PutMapping("/courses/{id}")
    public ResponseEntity<Course> updateCourse(@PathVariable(value = "id") Long courseId,
         @Valid @RequestBody Course courseDetails) throws ResourceNotFoundException {
        Course course = courseRepository.findById(courseId)
        .orElseThrow(() -> new ResourceNotFoundException("Course not found for this id :: " + courseId));

        course.setDepartment(courseDetails.getDepartment());
        course.setDuration(courseDetails.getDuration());
        course.setInstructor(courseDetails.getInstructor());
        course.setName(courseDetails.getName());
        course.setStudents(courseDetails.getStudents());
        final Course updatedCourse = courseRepository.save(course);
        return ResponseEntity.ok(updatedCourse);
    }

    @DeleteMapping("/courses/{id}")
    public Map<String, Boolean> deleteCourse(@PathVariable(value = "id") Long courseId)
         throws ResourceNotFoundException {
        Course course = courseRepository.findById(courseId)
       .orElseThrow(() -> new ResourceNotFoundException("Course not found for this id :: " + courseId));

        courseRepository.delete(course);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}
