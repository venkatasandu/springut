package spring.ut.myut.controller;

import static org.mockito.BDDMockito.given;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.*;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import ch.qos.logback.core.status.Status;
import spring.ut.myut.MyutApplication;
import spring.ut.myut.model.Employee;
import spring.ut.myut.service.UtService;

@RunWith(SpringRunner.class)
@WebMvcTest(value=UtController.class)
@ContextConfiguration(classes = MyutApplication.class)
public class UtControllerTest {

	@Autowired
	MockMvc mvc;
	
	@MockBean
	UtService service;
	
	@Autowired
	UtController controller;
	
	@Before
	public void setup() {
		
	}
	
	@Test
	public void verifyEmployees() throws Exception {
		
		Optional<Employee> aliko = Optional.of(new Employee("Aliko"));
		
		//mock(UtService.class);
		
		given(service.employee(1)).willReturn(aliko);
		
		  RequestBuilder requestBuilder = MockMvcRequestBuilders 
				  .get("/employees/1").accept(MediaType.APPLICATION_JSON);
		  
		  ResultActions actions = mvc.perform(requestBuilder);
		  MvcResult mvcResult = actions.andReturn();
		  String expected = "{id:1,name:Aliko,salary:2000}";
		  JSONAssert.assertEquals(expected, mvcResult.getResponse().getContentAsString(), false);
		  
		System.out.println("  .........   ");
	}
	
	@Test
	public void verifyNewEmployee() {
		
		ResultActions resultAction = null;
		//String employeeJson = "{\"id\":\"1\",\"name\":\"Aliko\",\"salary\":\"2000\"}";
		String employeeJson = "{\"id\":1,\"name\":\"Aliko\",\"salary\":2000}";
		Employee e = new Employee("Aliko");
		
		given(service.save(e)).willReturn(e);
		
		RequestBuilder requestBuilder = 
				MockMvcRequestBuilders
				.post("/employees")
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON)
				.content(employeeJson);
		try {
			resultAction = mvc.perform(requestBuilder);
			
			//testing
			//MvcResult result = 
			//MockHttpServletResponse httpresult = result.getResponse();
			assertEquals(HttpStatus.OK.value(), mvc.perform(requestBuilder).andReturn().getResponse().getStatus());
			//assertEquals("http://localhost:9091/employees", mvc.perform(requestBuilder).andReturn().getResponse().getHeader(HttpHeaders.LOCATION));
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		
	}
	
}
