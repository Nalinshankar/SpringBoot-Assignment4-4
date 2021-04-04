package com.assignment.nalin.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "instructors")
public class Instructor {
	

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumns({
		@JoinColumn(name = "department_id", nullable = false),
		@JoinColumn(name = "location_id", nullable = false)
		})
    private Department department;
	
	@NotBlank(message = "headedBy is mandatory")
    @Size(max = 255)
    private String headedBy;
	
	@NotBlank(message = "firstName is mandatory")
    @Size(max = 255)
    private String firstName;
	
	@NotBlank(message = "lastName is mandatory")
    @Size(max = 255)
    private String lastName;
	
	@NotBlank(message = "phoneNumber is mandatory")
    @Size(max = 255)
    private String phoneNumber;
	
	@OneToMany(mappedBy = "instructor",fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<Course> courses = new HashSet<>();
	

	public Instructor(Long id, Department department, String headedBy, String firstName, String lastName,
			String phoneNumber, Set<Course> courses) {

		this.id = id;
		this.department = department;
		this.headedBy = headedBy;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.courses = courses;
	}


	public Instructor() {
		
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Department getDepartment() {
		return department;
	}


	public void setDepartment(Department departmentName) {
		this.department = department;
	}


	public String getHeadedBy() {
		return headedBy;
	}


	public void setHeadedBy(String headedBy) {
		this.headedBy = headedBy;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public Set<Course> getCourses() {
		return courses;
	}


	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

}
