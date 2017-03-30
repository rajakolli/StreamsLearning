package org.streams.examples;

import java.util.List;
import java.util.stream.Collectors;

/*
 * The joining() method from Collectors class returns a collector that concatenates the stream of CharSequence and returns the result as a String.
 * 
 * The joining() method is overloaded and it has three versions:
 * 
 * 		joining(): concatenates all elements
 * 		joining(CharSequence delimiter) : uses a delimiter to be used between two elements.
 * 		joining(CharSequence delimiter, CharSequence prefix, CharSequence suffix) : 
 * 					uses a delimiter, a prefix and a suffix. The prefix is added to the beginning and the suffix is added to the end.
 * 
 */

public class K1_Join {
//The following code shows how to use the joining() method.
	
	public static void main(String[] args) {
		List<Employee> persons = Employee.persons();
		
		// Example 1 using:  joining(): 	concatenates all elements
		String names = persons.stream()
				.map(Employee::getName)
				.collect(Collectors.joining());
		
		System.out.println("Example 1 using: joining(): " +names);
		
		// Example 2 using:  joining(CharSequence delimiter) : uses a delimiter to be used between two elements.
		String delimitedNames = persons.stream()
				.map(Employee::getName)
				.collect(Collectors.joining(", "));
		
		System.out.println("Example 2 using: joining(CharSequence delimiter): " + delimitedNames);
		
		
		// Example 3 using: joining(CharSequence delimiter, CharSequence prefix, CharSequence suffix) : 
		//  					uses a delimiter, a prefix and a suffix. The prefix is added to the beginning and the suffix is added to the end.
		
		String prefixedNames = persons.stream()
				.map(Employee:: getName)
				.collect(Collectors.joining(", ", "Hello ", ". Goodbye."));
		System.out.println("Example 3 using: joining(CharSequence delimiter, CharSequence prefix, CharSequence suffix): " + prefixedNames);
	}

}
