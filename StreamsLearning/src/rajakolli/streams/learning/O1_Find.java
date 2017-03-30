package org.streams.examples;

import java.util.List;
import java.util.Optional;

/*
 * The Streams API supports different types of find operations on stream elements.
 * The following methods in the Stream interface are used to perform find operations:
 * 
 * 			Optional<T>   findAny()
 * 			Optional<T>   findFirst()
 * 
 * 
 * The primitive type streams such as IntStream, LongStream, and DoubleStream 
 * 				also contain the same methods that work with a predicate and an optional one for primitive types.
 * All find operations are terminal operations. They are also short-circuiting operations. 
 * 				A short-circuiting operation may not have to process the entire stream to return the result.
 *  
 */

public class O1_Find {
//The following code shows how to perform find operations on streams.
	
	public static void main(String[] args) {
		List<Employee> persons = Employee.persons();
		
		//Find any male
		
		Optional<Employee> anyMale = persons.stream().filter(Employee::isMale).findAny();
		
		if(anyMale.isPresent()) {
			System.out.println("Any male:   " + anyMale.get());
		} else {
			System.out.println("No male found.");
		}
		
		//find first male
		Optional<Employee> firstMale = persons.stream().filter(Employee::isMale).findFirst();
		
		if(firstMale.isPresent()) {
			System.out.println("First male: " + firstMale.get());
		} else {
			System.out.println("No male found.");
			
		}
	}

}
