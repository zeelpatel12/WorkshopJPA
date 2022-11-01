package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

	public Employee findByeName(String eName);
	
	@Query(value = "select e from Employee e where lower(e.eName) =lower(:eName)", nativeQuery = false)
	public Employee getEmployeeByNameIgnoreCase(@Param(value="eName")String eName);
	
	@Query(value = "select * from Employee where name =?",nativeQuery=true)
	public Employee getEmployeeByName(@Param("name")String name);
}
