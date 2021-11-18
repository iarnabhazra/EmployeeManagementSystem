package Employee.management.EmployeeManagementSystem.controller;

import Employee.management.EmployeeManagementSystem.expections.ResourceNotFoundException;
import Employee.management.EmployeeManagementSystem.model.Employee;
import Employee.management.EmployeeManagementSystem.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	private EmployeeRepository employeeRepository;
	
	// Get all Employees
	@GetMapping("/employees")
	public List<Employee> getAllEmployees() {
		logger.info("Employees Api is accessed");
		return employeeRepository.findAll();
	}

	// Create Employee Rest API
	@PostMapping("/create")
	public Employee createEmployee(@RequestBody Employee employee) {
		return employeeRepository.save(employee);
	}

	// Get Employees By Id
	@GetMapping("/employee/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee Doesn't Exist"));
		return ResponseEntity.ok(employee);

	}

	// Updating the Employee
	@PutMapping("/update/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employeeDetails) {
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee Not Found"));
		employee.setFirstName(employeeDetails.getFirstName());
		employee.setLastName(employeeDetails.getLastName());
		employee.setPhoneNumber(employeeDetails.getPhoneNumber());
		employee.setEmailId(employeeDetails.getEmailId());
		Employee updatedEmployee = employeeRepository.save(employee);
		return ResponseEntity.ok(updatedEmployee);
	}

	// Deleting the Employee
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id) {
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee Not Found"));
		employeeRepository.delete(employee);
		Map<String, Boolean> response = new HashMap<>();
		response.put("Deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
