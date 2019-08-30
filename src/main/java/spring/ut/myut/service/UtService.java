package spring.ut.myut.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.ut.myut.model.Employee;
import spring.ut.myut.repository.UtRepository;

@Service
public class UtService {
	
	@Autowired
	UtRepository utRepository;
	
	public List<Employee> allEmployees(){
		return utRepository.findAll();
	}

	public Optional<Employee> employee(Integer id){
		return utRepository.findById(id);
	}

	public Employee save(Employee employee){
		return utRepository.save(employee);
	}
}
