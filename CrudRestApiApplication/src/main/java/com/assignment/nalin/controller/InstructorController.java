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

import com.assignment.nalin.entity.Instructor;
import com.assignment.nalin.exception.ResourceNotFoundException;
import com.assignment.nalin.repository.InstructorRepository;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/api/v1")
@Api(value="InstructorController to perform Add, Update, Delete, Find All and Find by Id operations ")
public class InstructorController {
	
	@Autowired
    private InstructorRepository instructorRepository;

    @GetMapping("/instructors")
    public List<Instructor> getAllInstructors() {
        return (List<Instructor>) instructorRepository.findAll();
    }

    @GetMapping("/instructors/{id}")
    public ResponseEntity<Instructor> getInstructorById(@PathVariable(value = "id") Long instructorId)
        throws ResourceNotFoundException {
        Instructor instructor = instructorRepository.findById(instructorId)
          .orElseThrow(() -> new ResourceNotFoundException("Instructor not found for this id :: " + instructorId));
        return ResponseEntity.ok().body(instructor);
    }
    
    @PostMapping("/instructors")
    public Instructor createInstructor(@Valid @RequestBody Instructor instructor) {
        return instructorRepository.save(instructor);
    }

    @PutMapping("/instructors/{id}")
    public ResponseEntity<Instructor> updateInstructor(@PathVariable(value = "id") Long instructorId,
         @Valid @RequestBody Instructor instructorDetails) throws ResourceNotFoundException {
        Instructor instructor = instructorRepository.findById(instructorId)
        .orElseThrow(() -> new ResourceNotFoundException("Instructor not found for this id :: " + instructorId));

        instructor.setDepartment(instructorDetails.getDepartment());
        instructor.setCourses(instructorDetails.getCourses());
        instructor.setFirstName(instructorDetails.getFirstName());
        instructor.setLastName(instructorDetails.getLastName());
        instructor.setHeadedBy(instructorDetails.getHeadedBy());
        instructor.setPhoneNumber(instructorDetails.getPhoneNumber());
        final Instructor updatedInstructor = instructorRepository.save(instructor);
        return ResponseEntity.ok(updatedInstructor);
    }

    @DeleteMapping("/instructors/{id}")
    public Map<String, Boolean> deleteInstructor(@PathVariable(value = "id") Long instructorId)
         throws ResourceNotFoundException {
        Instructor instructor = instructorRepository.findById(instructorId)
       .orElseThrow(() -> new ResourceNotFoundException("Instructor not found for this id :: " + instructorId));

        instructorRepository.delete(instructor);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }


}
