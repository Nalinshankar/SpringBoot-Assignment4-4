package com.assignment.nalin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.nalin.entity.Department;
import com.assignment.nalin.repository.DepartmentRepository;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/api/v1")
@Api(value="DepartmentController to perform Add, Update, Delete, Find All and Find by Id operations ")
public class DepartmentController {
	
	@Autowired
    private DepartmentRepository departmentRepository;

    @GetMapping("/departments")
    public List<Department> getAllDepartments() {
        return (List<Department>) departmentRepository.findAll();
    }

}
