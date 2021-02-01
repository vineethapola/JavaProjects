package com.planon.employee;

public class Employee implements Comparable<Employee> {
	
	private Integer empId;
	private String empName;
	private String dept;
	private double actualSal;
	private double incSal;
	
	
	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public double getActualSal() {
		return actualSal;
	}

	public void setActualSal(double actualSal) {
		this.actualSal = actualSal;
	}

	public double getIncSal() {
		return incSal;
	}

	public void setIncSal(double incSal) {
		this.incSal = incSal;
	}

	public Employee(Integer empId,String empName, String dept, double actualSal, double incSal) {
		this.empId = empId;
		this.empName = empName;
		this.dept = dept;
		this.actualSal = actualSal;
		this.incSal = incSal;
	}

	@Override
	public int compareTo(Employee emp) {
		return Double.compare(emp.incSal, incSal);
	}

}
