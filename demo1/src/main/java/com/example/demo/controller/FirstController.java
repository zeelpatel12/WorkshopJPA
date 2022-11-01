//package com.example.demo.controller;
//
//import javax.websocket.server.PathParam;
//
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.example.demo.model.Employee;
//import com.example.demo.service.EmployeeService;
//
//
//@RestController
//public class FirstController {
//
//	Logger log = LogManager.getLogger();
//	
//	@Autowired
//	EmployeeService service;
//	
//	@GetMapping("/hello")
//	public String geSt() {
//		return "asdf";
//	}
//	
//	@PostMapping("/create")
//	public Employee createEmployee(@RequestBody Employee emp) {
//		service.createEmployee(emp);
//		return emp;
//	}
//	
//	@DeleteMapping("/delete/{id}")
//	public String deleteEmployee(@PathVariable Long id) {
//		service.deleteEmployee(id);
//		return "Employee Deleted Successfully";
//	}
//}
