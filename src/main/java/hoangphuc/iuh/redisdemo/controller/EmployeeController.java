package hoangphuc.iuh.redisdemo.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hoangphuc.iuh.redisdemo.modal.Employee;
import hoangphuc.iuh.redisdemo.repo.EmployeeRepository;

@RestController
@RequestMapping
public class EmployeeController {
	 @Autowired
	    private EmployeeRepository employeeRepository;

	    @PostMapping("/employees")
	    public Employee saveEmployee(@RequestBody Employee employee){
	        employeeRepository.saveEmployee(employee);
	        return employee;
	    }

	    @GetMapping("/employees")
	    public Set<Employee> findAll(){

	        return employeeRepository.findAll();
	    }
	    
	    @GetMapping("/employees/{id}")
	    public Employee findById(@PathVariable("id") Integer id){

	        return employeeRepository.findById(id);
	    }

	    @PutMapping("/employees")
	    public void update(@RequestBody Employee employee){

	        employeeRepository.update(employee);
	    }

	    @DeleteMapping("/employees/{id}")
	    public void delete(@PathVariable("id") Integer id){
	        employeeRepository.delete(id);
	    }

}
