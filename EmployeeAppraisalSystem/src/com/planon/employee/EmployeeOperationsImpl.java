package com.planon.employee;

import java.util.List;

public class EmployeeOperationsImpl implements EmployeeOperations {

	@Override
	public List<Employee> salCalc(List<Employee> employeeSet) {
		for (Employee emp : employeeSet) {
			double incSal = emp.getActualSal() + (emp.getActualSal() * Constants.salCalc.get(emp.getDept()) / 100);
			emp.setIncSal(incSal);
		}
		return employeeSet;
	}

	@Override
	public void display(List<Employee> employeeSet) {
		System.out.println("Name\tDepartment\tSalary");
		for (Employee e : employeeSet) {
			System.out.println(e.getEmpName() + "\t" + e.getDept() + "\t" + e.getIncSal());
		}
	}

}
