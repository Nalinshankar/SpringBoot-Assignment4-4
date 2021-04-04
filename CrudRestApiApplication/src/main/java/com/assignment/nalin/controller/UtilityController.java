package com.assignment.nalin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.nalin.entity.Course;
import com.assignment.nalin.entity.Student;
import com.assignment.nalin.service.UtilityService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/v1")
@Api(value="UtilityController to perform to get the list of course for a particular student id\r\n" + 
		" to get the list of students for a particular instructor id\r\n" + 
		" to get the total course duration for a particular student id \r\n" + 
		" ")
public class UtilityController {
	
	@Autowired
	UtilityService utilityService;
	
	@ApiOperation(value = "get the list of course for a particular student id ")
    @GetMapping("/courses/student/{id}")
    public List<Course> getCoursesByStudentId(@PathVariable(value = "id") Long studentId)
         {
    	return  utilityService.findCoursesByStudentId(studentId);
          
    }
    
    @ApiOperation(value = "to get the list of students for a particular instructor ")
    @GetMapping("/student/instructor/{id}")
    public List<Student> getStudentsByinstructorId(@PathVariable(value = "id") Long instructorId)
         {
    	return  utilityService.findStudentsByInstructorId(instructorId);
          
    }
    
    @ApiOperation(value = "to get the total course duration for a particular student id")
    @GetMapping("/course/duration/student/{id}")
    public Long getcourseDurationByStudentId(@PathVariable(value = "id") Long studentId)
         {
    	return  utilityService.findCourseDurationByStudentId(studentId);
          
    }
	 
	 


}
