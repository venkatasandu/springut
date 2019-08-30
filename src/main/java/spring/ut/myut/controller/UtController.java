package spring.ut.myut.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import spring.ut.myut.model.Employee;
import spring.ut.myut.service.UtService;

@RestController
public class UtController {

	@Autowired
	UtService service;
	
	@RequestMapping(value = "/employees")
	public ResponseEntity<List<Employee>> allEmployees(){
		return new ResponseEntity<List<Employee>>(service.allEmployees(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/employees/{id}")
	public ResponseEntity<Optional<Employee>> employees(@PathVariable("id") Integer id){
		ResponseEntity<Optional<Employee>> r= new ResponseEntity<Optional<Employee>>(service.employee(id), HttpStatus.OK);
		return r;
	}
	
	@PostMapping("/employees")
	public ResponseEntity<Employee> newEmployee(@RequestBody Employee employee) {
		return new ResponseEntity<Employee>(service.save(employee), HttpStatus.OK);
	}
	
}
