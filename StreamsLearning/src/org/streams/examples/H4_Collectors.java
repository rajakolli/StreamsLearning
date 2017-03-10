package org.streams.examples;

import java.util.SortedSet;
import java.util.TreeSet;
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
public class H4_Collectors {
	// 	using Collector interface
	//	We can collect names in a sorted set using the toCollection() method as follows:
	public static void main(String[] args) {
		SortedSet<String> uniqueSortedNames = Employee.persons()
				.stream()
				.map(Employee::getName)
				.collect(Collectors.toCollection(TreeSet::new));
		System.out.println(uniqueSortedNames);

	}

}
