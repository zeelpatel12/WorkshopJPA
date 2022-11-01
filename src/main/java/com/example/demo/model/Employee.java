package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long eId;
	private String eName;
	private String dept;
//	
//	@ManyToOne
//	private Department department; 
	
	public Long geteId() {
		return eId;
	}
	public void seteId(Long eId) {
		this.eId = eId;
	}
	public String geteName() {
		return eName;
	}
	public void seteName(String eName) {
		this.eName = eName;
	}
	
	
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public Employee() {
		
	}
	public Employee(Long eId, String eName, String dept) {
		super();
		this.eId = eId;
		this.eName = eName;
		this.dept = dept;
	}
	@Override
	public String toString() {
		return "Employee [eId=" + eId + ", eName=" + eName + ", dept=" + dept + "]";
	}
	
	
	
	
	
	
}
