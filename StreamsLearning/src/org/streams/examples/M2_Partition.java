package org.streams.examples;

import java.util.Map;
import java.util.stream.Collectors;

/*
 * Partitioning is a special case of grouping.
 * Grouping data is based on the keys returned from a function. There could be many groups.
 * Partitioning only takes care of two groups based on a predicate. The value evaluated to true is one group, false is another group.
 * 		partitioningBy() method, which collects data in a Map whose keys are always of the type Boolean, is overloaded in two versions.
 *   
 *   
 *   The first version of the partitionedBy() method returns a collector that performs the partitioning based on the predicate.
 *   			*	partitioningBy(Predicate<? super T> predicate)
 *   
 *   The second version allows us to specify another collector that can perform a reduction operation.
 *   
 *   			*	partitioningBy(Predicate<? super T> predicate,  Collector<? super T,A,D> downstream)
 */
public class M2_Partition {
// The following code shows how to partition employee by gender, and collects their names in a comma-separated string:
	public static void main(String[] args) {
		Map<Boolean, String> partionedByMaleGender = Employee.persons()
				.stream()
				.collect(Collectors.partitioningBy(Employee::isMale, 
						Collectors.mapping(Employee::getName
								, Collectors.joining(", "))));
		System.out.println(partionedByMaleGender);
						

	}

}
