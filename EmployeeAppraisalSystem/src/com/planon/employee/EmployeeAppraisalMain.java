/**
 * 
 */
package com.planon.employee;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;


/**
 * @author vapola
 *
 */

public class EmployeeAppraisalMain {

	static Logger logger = Logger.getLogger(EmployeeAppraisalMain.class.getName());

	/**
	 * Main class for getting input from user
	 * 
	 */
	public static void main(String[] args) throws IOException {
		EmployeeOperations empOps = new EmployeeOperationsImpl();
		List<Employee> employeeList = new ArrayList<>();
		List<Integer> empIds = new ArrayList<>();
		int numberOfEmployees;
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		try {
			logger.info("Enter number of employees to add");
			numberOfEmployees = Integer.parseInt(in.readLine());
			for (int i = 0; i < numberOfEmployees; i++) {
				logger.info("Enter Employee Id : ");
				Integer id = Integer.parseInt(in.readLine());
				if(!empIds.contains(id)) {
				logger.info("Enter Employee Name : ");
				String name = in.readLine();

				logger.info("Enter Employee Department : ");
				String dept = in.readLine();

				logger.info("Enter Employee Salary : ");
				double salary = Double.parseDouble(in.readLine());
				empIds.add(id);
				employeeList.add(new Employee(id,name, dept, salary, salary));
				}
				else
					throw new Exception("An emp with same empid is present");
			}
			// sorting collection using comparable
			employeeList = empOps.salCalc(employeeList);
			Collections.sort(employeeList);
			empOps.display(employeeList);
		} catch (Exception e) {
			logger.info(e.toString());
		}
	}
}
