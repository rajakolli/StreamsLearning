package org.streams.examples;

import java.util.List;

// increase the salary of female employees by 10%

	public class A3_Operations {

		public static void main(String[] args) {
			List<Employee> person = Employee.persons();
			System.out.println("Before increasing the income: " + person);
			
			person.stream()
			.filter(Employee::isFemale)
			.forEach(p -> p.setIncome(p.getIncome() * 1.10));
			
			System.out.println("After increasing the income: " + person);
	
		}
		

	}

