//package com.example.demo.model;
//
//import java.util.List;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.OneToMany;
//
//@Entity
//public class Department {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	private Long id;
//	private String departmentName;
//	
//	@OneToMany(mappedBy = "department")
//	private List<Employee> employees;
//
//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public String getDepartmentName() {
//		return departmentName;
//	}
//
//	public void setDepartmentName(String departmentName) {
//		this.departmentName = departmentName;
//	}
//
//	public List<Employee> getEmployees() {
//		return employees;
//	}
//
//	public void setEmployees(List<Employee> employees) {
//		this.employees = employees;
//	}
//
//	public Department(Long id, String departmentName, List<Employee> employees) {
//		super();
//		this.id = id;
//		this.departmentName = departmentName;
//		this.employees = employees;
//	}
//	
//	public Department() {}
//
//	@Override
//	public String toString() {
//		return "Department [id=" + id + ", departmentName=" + departmentName + ", employees=" + employees + "]";
//	}
//	
//	
//	
//}
