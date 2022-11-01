package com.example.demo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.repo.EmployeeRepository;

@Service
public class EmployeeService {

	List<Employee> employees;
	Employee emp = new Employee();

	@Autowired
	private EmployeeRepository repo;

	public EmployeeService() {
	}

	public Employee getEmployeeById(Long id) {

		return this.repo.getById(id);
	}

	public Employee getEmployeeByName(String name) {
		employees.stream().filter(e -> e.geteName().equals(name)).forEach(res -> this.emp = res);
		return emp;
	}

	public Page<Employee> getEmployees(Pageable page) {
		return this.repo.findAll(page);
	}

	public Employee createEmployee(Employee emp) {
		this.repo.save(emp);

		return emp;
	}

//	public void updateEmployee(Long eId, Employee emp) {
//
//		Optional<Employee> empl = repo.findById(eId);
//		empl.get().seteName(emp.geteName());
//		empl.get().setDept(emp.getDept());
//		repo.save(empl.get());
//
//	}

	public void deleteEmployee(Long eId) {
		Optional<Employee> empl = this.repo.findById(eId);
		this.repo.delete(empl.get());
	}

	public Employee findEmployeeByName(String name) {
		return repo.getEmployeeByName(name);
	}

	public Employee findEmployeeByNameIgnoreCase(String name) {
		return repo.getEmployeeByNameIgnoreCase(name);
	}
}
