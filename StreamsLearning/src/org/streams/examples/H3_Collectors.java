package org.streams.examples;

import java.util.Set;
import java.util.stream.Collectors;

/*
 * Collector interface
 * 	The second version of the collect() takes an instance of the Collector interface as an argument.
 * 
 * 	Streams API provides a utility class called Collectors that provides out-of-box implementations for commonly used collectors.
 * 
 * Three of the most commonly used methods of the Collectors class are toList(), toSet(), and toCollection().
 * 		The toList() method returns a Collector that collects the data in a List.
 * 		The toSet() method returns a Collector that collects data in a Set.
 * 		The toCollecton() takes a Supplier that returns a Collection to be used to collect data.
 */
public class H3_Collectors {
	
	// 	using Collector interface
	//	The following code collects all names in a Set<String> which keeps only unique elements..
	public static void main(String[] args) {
		
		Set<String> uniqueNames  = Employee.persons()
                .stream()
                .map(Employee::getName)
                .collect(Collectors.toSet());
		System.out.println(uniqueNames);

	}

}
