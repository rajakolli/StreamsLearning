package org.streams.examples;

public class A2_Operations {

	public static void main(String[] args) {
		Employee.persons()
			.stream()
			.filter(Employee::isFemale)
			.forEach(System.out::println);

	}

}

