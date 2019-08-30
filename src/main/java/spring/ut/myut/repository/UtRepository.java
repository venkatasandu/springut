package spring.ut.myut.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import spring.ut.myut.model.Employee;

@Repository
public interface UtRepository extends JpaRepository<Employee, Integer>{

}
