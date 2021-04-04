package com.assignment.nalin.repository;

import org.springframework.data.repository.CrudRepository;

import com.assignment.nalin.entity.Department;
import com.assignment.nalin.entity.DepartmentId;

public interface DepartmentRepository extends CrudRepository<Department, DepartmentId> {

}
