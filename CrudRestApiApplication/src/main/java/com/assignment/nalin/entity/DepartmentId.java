package com.assignment.nalin.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Embeddable
public class DepartmentId implements Serializable {
	
	
	@NotBlank(message = "name is mandatory")
    @Size(max = 255)
    private String name;
	
	

	@NotBlank(message = "location is mandatory")
    @Size(max = 255)
    private String location;
	
	
	public DepartmentId() {
		
	}


	public DepartmentId(String name, String location) {

		this.name = name;
		this.location = location;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DepartmentId that = (DepartmentId) o;

        if (!name.equals(that.name)) return false;
        return location.equals(that.location);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + location.hashCode();
        return result;
    }
	

}
