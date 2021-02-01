package com.planon.employee;

import java.util.List;

public interface EmployeeOperations {
	
	void display(List<Employee> employeeList);
	
	public List<Employee> salCalc(List<Employee> employeeSet);
	
}
