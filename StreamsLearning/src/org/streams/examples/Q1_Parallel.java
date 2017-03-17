package org.streams.examples;
/*
 * Streams can be sequential or parallel.
 * Operations on a sequential stream are processed in serial by one thread.
 * Operations on a parallel stream are processed in parallel using multiple threads.
 * Most of the methods in the Streams API produce sequential streams by default. 
 * 		To create a parallel stream from a collection such as a List or a Set, 
 * 				call the parallelStream() method of the Collection interface.
 * Use the parallel() method on a stream to convert a sequential stream into a parallel stream.
 * Use the sequential() method on a stream to convert a parallel stream into a sequential stream.
 * 
 */
import java.util.stream.Collectors;

public class Q1_Parallel {
// The following code shows how to do serial processing of the stream:
	public static void main(String[] args) {
		String	names = Employee.persons()
				.stream()
				.filter(Employee::isMale)
				.map(Employee::getName)
				.collect(Collectors.joining(", "));
		System.out.println(names);
		
		names = Employee.persons()
				.parallelStream()
				.filter(Employee::isMale)
				.map(Employee::getName)
				.collect(Collectors.joining(", "));
		System.out.println(names);

	}

}
