package com.example.demo.controller;


import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

@Controller
public class EmployeeController {

	Logger log = LogManager.getLogger();
	
	@Autowired
	EmployeeService service;
	
//	@GetMapping("/employee")
//	public ModelAndView getEmployee() {
////		Employee emp  = new Employee(122,"jhon","eng");
////		log.warn("inside the controller ");
////		ModelAndView mv = new ModelAndView("employee");
////		mv.addObject("employee", emp);
//		return mv;
//	}
	
	@GetMapping("/getEmployee/{id}")
	public ModelAndView getEmployeeById(@PathVariable Long id) {
		Employee emp = service.getEmployeeById(id);
		
		if(emp.geteId()!=0) {
			ModelAndView mv = new ModelAndView("employee");
			mv.addObject("employee",emp);
			return mv;
		} else {
			ModelAndView mv = new ModelAndView("notFound");
			mv.addObject("message","Not Found 404");
			return mv;
		}
	}
	
	@GetMapping("/getEmployeeByName")
	public ModelAndView getEmployeeByName(@RequestParam("name") String name) {
		Employee emp = service.getEmployeeByName(name);
		if(emp.geteId()!=0) {
			ModelAndView mv = new ModelAndView("employee");
			mv.addObject("employee",emp);
			return mv;
		} else {
			ModelAndView mv = new ModelAndView("notFound");
			mv.addObject("message","Not Found 404");
			return mv;
		}
	}
	
	@GetMapping("/create")
	public ModelAndView addEmployee() {
		Employee employee = new Employee();
		log.info("Inside the get create controller");
		ModelAndView mv = new ModelAndView("form","emp",employee);
		return mv;
	}
	
//	@GetMapping("/view")
//	public ModelAndView getEmployees() {
//		List<Employee>employee = service.getEmployees();
//		ModelAndView mv = new ModelAndView("viewEmployee");
//		mv.addObject("employees",employee);
//		return mv;
//	}
	
	@PostMapping("/create")
	public ModelAndView createEmployee(@ModelAttribute Employee employee) {
		log.warn("here "+employee.toString());
		Employee emp = service.createEmployee(employee);
		log.info("Inside post create controller");
		Page<Employee>employees = service.getEmployees(PageRequest.of(0,3,Sort.by(Direction.ASC,"eName")));
		return new ModelAndView("viewEmployee","employees",employees);
	}
	
	@GetMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable Long id) {
		service.deleteEmployee(id);
		Page<Employee>employees = service.getEmployees(PageRequest.of(0,3,Sort.by(Direction.ASC,"eName")));
		return new ModelAndView("viewEmployee","employees",employees);
	}
	
	@GetMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable Long id) {
		Employee employee = service.getEmployeeById(id);
		return new ModelAndView("editForm","employee",employee);
	}
	
	@PostMapping("/update")
	public ModelAndView editForm(@ModelAttribute Employee employee) {
		log.info("emploee "+employee);
		//service.updateEmployee(employee.geteId(), employee);
		Page<Employee>employees = service.getEmployees(PageRequest.of(0,3,Sort.by(Direction.ASC,"eName")));
		log.info("emploee "+employees);
		return new ModelAndView("viewEmployee","employees",employees);
	}
	
	@GetMapping("/view")
	public ModelAndView viewByName(@RequestParam(name="name") String name) {
		return new ModelAndView("viewEmployee","employees",service.findEmployeeByNameIgnoreCase(name));
	}
	@GetMapping("/viewAll")
	public ModelAndView view() {
		return new ModelAndView("viewEmployee","employees",service.getEmployees(PageRequest.of(0,5,Sort.by(Direction.ASC,"eName"))));
	}

}
