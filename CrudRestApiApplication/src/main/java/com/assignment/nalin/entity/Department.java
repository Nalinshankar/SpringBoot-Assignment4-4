package com.assignment.nalin.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "departments")
public class Department {
	
	
	
	@EmbeddedId
    private DepartmentId departmentId;
	
//	@NotBlank(message = "name is mandatory")
//    @Size(max = 255)
//    private String name;

//	@NotBlank(message = "location is mandatory")
//    @Size(max = 255)
//    private String location;
	
	@OneToMany(mappedBy = "department",fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<Course> courses = new HashSet<>();
	
	@OneToMany(mappedBy = "department",fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<Instructor> instructors = new HashSet<>();
	
	public Department() {
		
	}

	public Department(DepartmentId departmentId, String name, String location, Set<Course> courses,Set<Instructor> instructors) {

		this.departmentId = departmentId;
		//this.name = name;
		//this.location = location;
		this.courses = courses;
		this.instructors = instructors;
	}

	public DepartmentId getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(DepartmentId departmentId) {
		this.departmentId = departmentId;
	}

//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}

//	public String getLocation() {
//		return location;
//	}
//
//	public void setLocation(String location) {
//		this.location = location;
//	}
	
	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

	public Set<Instructor> getInstructors() {
		return instructors;
	}

	public void setInstructors(Set<Instructor> instructors) {
		this.instructors = instructors;
	}


	

}
