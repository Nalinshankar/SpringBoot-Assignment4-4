package controller;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.assignment.nalin.controller.UtilityController;
import com.assignment.nalin.entity.Course;
import com.assignment.nalin.entity.Department;
import com.assignment.nalin.entity.Instructor;
import com.assignment.nalin.entity.Student;
import com.assignment.nalin.service.UtilityService;

@SpringBootTest
@WebMvcTest(UtilityController.class)
public class UtilityControllerTest {
	
	  
	  private MockMvc mockMvc;
	  
	  @Autowired
	  private WebApplicationContext context;
	  
	  @MockBean
		UtilityService utilityService;
	  
	  @BeforeEach
	  public void setup() {
	    this.mockMvc = MockMvcBuilders
	      .webAppContextSetup(this.context)
	      .apply(springSecurity())
	      .build();
	  }
	 
	  @Test
	  public void getCoursesByStudentId() throws Exception {
		  
		    Department department = new Department();
			Instructor  instructor = new Instructor();
			Student st1 = new Student(11l,"Nalin","Shankar","123456");
			Student st2 = new Student(12l,"N","Shankar","123457");
			
			Course c1 = new Course(100l,department,instructor,1l,"computer");		
			Course c2 = new Course(101l,department,instructor,2l,"Networking");
			
			st1.getCourses().add(c1);
			st1.getCourses().add(c2);
			
			c1.getStudents().add(st1);
			c1.getStudents().add(st2);  
			
		    this.mockMvc
		      .perform(
		        get("/api/v1/courses/student/11l")
		          .with(SecurityMockMvcRequestPostProcessors.user("admin").roles("admin"))
		          .with(csrf())
		      )
		      .andExpect(status().isOk());
	  }

}
