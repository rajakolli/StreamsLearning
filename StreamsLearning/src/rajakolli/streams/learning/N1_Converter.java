package org.streams.examples;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/*
 * 
 * We can convert the result of the collector to a different type.
 * 			collectingAndThen() method of the Collectors class is defined as follows.
 *   
 */
public class N1_Converter {
// The following code returns an unmodifiable view of the collected data.
	public static void main(String[] args) {
		List<String> names = Employee.persons()
				.stream()
				.map(Employee::getName)
				.collect(Collectors.collectingAndThen(Collectors.toList(),
						result -> Collections.unmodifiableList(result)));
		
		System.out.println(names);

	}

}
