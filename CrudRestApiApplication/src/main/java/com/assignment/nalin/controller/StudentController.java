package com.assignment.nalin.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;
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

import com.assignment.nalin.entity.Student;
import com.assignment.nalin.exception.ResourceNotFoundException;
import com.assignment.nalin.repository.StudentRepository;

import io.swagger.annotations.Api;



@RestController
@RequestMapping("/api/v1")
@Api(value="StudentController to perform Add, Update, Delete, Find All and Find by Id operations ")
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return (List<Student>) studentRepository.findAll();
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable(value = "id") Long studentId)
        throws ResourceNotFoundException {
        Student student = studentRepository.findById(studentId)
          .orElseThrow(() -> new ResourceNotFoundException("Student not found for this id :: " + studentId));
        return ResponseEntity.ok().body(student);
    }
    
    @PostMapping("/students")
    public Student createStudent(@Valid @RequestBody Student student) {
        return studentRepository.save(student);
    }

    @PutMapping("/students/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable(value = "id") Long studentId,
         @Valid @RequestBody Student studentDetails) throws ResourceNotFoundException {
        Student student = studentRepository.findById(studentId)
        .orElseThrow(() -> new ResourceNotFoundException("Student not found for this id :: " + studentId));

        student.setPhoneNumber(studentDetails.getPhoneNumber());
        student.setCourses(studentDetails.getCourses());
        student.setLastName(studentDetails.getLastName());
        student.setFirstName(studentDetails.getFirstName());
        final Student updatedStudent = studentRepository.save(student);
        return ResponseEntity.ok(updatedStudent);
    }

    @DeleteMapping("/students/{id}")
    public Map<String, Boolean> deleteStudent(@PathVariable(value = "id") Long studentId)
         throws ResourceNotFoundException {
        Student student = studentRepository.findById(studentId)
       .orElseThrow(() -> new ResourceNotFoundException("Student not found for this id :: " + studentId));

        studentRepository.delete(student);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
