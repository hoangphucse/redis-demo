package hoangphuc.iuh.redisdemo.repo;

import java.util.List;
import java.util.Set;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.stereotype.Repository;

import hoangphuc.iuh.redisdemo.modal.Employee;

@Repository
public class EmployeeRepository {

	private HashOperations hashOperations;// crud hash
	private RedisTemplate redisTemplate;
	private ListOperations listOperations;
	private SetOperations setOperations;

	public EmployeeRepository(RedisTemplate redisTemplate) {

		this.hashOperations = redisTemplate.opsForHash();
		this.redisTemplate = redisTemplate;
		this.listOperations = redisTemplate.opsForList();
		this.setOperations = redisTemplate.opsForSet();

	}
	
	public Set<Employee> findAll() {
		return setOperations.members("EMPLOYEE");
	}


	public void saveEmployee(Employee employee) {

		hashOperations.put("EMPLOYEE", employee.getId(), employee);
	}



	public Employee findById(Integer id) {

		Set<Employee> employees = this.findAll();
		for (Employee employee : employees) {
			if (employee.getId() == id)
				return employee;
		}
		return null;
	}

	public void update(Employee employee) {
		saveEmployee(employee);
	}

	public void delete(Integer id) {
		hashOperations.delete("EMPLOYEE", id);
	}
}
