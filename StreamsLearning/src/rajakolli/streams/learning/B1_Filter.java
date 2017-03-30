package org.streams.examples;

/*
	* The filter operation produces a filtered stream, 
	 		a subset of the input stream, 
	 		whose elements evaluate to true for the specified predicate.
	* A predicate is a function that accepts an element and returns a boolean value.
	* The filtered stream has the same type as the input stream.
	* If the predicate evaluates to false for all elements, 
	 		it produces an empty stream.
 */


//Filter female employees and print them to standard output.

public class B1_Filter {

	public static void main(String[] args) {
		Employee.persons()
			.stream()
			.filter(Employee::isFemale)
			.map(Employee::getName)
			.forEach(System.out::println);

	}

}
