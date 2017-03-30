package rajakolli.streams.learning;

import java.util.List;

/*
 * The Streams API supports different types of match operations on stream elements.
 * The following methods in the Stream interface are used to perform match operations:
 * 
 * 			boolean allMatch(Predicate<? super T> predicate)
 * 			boolean anyMatch(Predicate<? super T> predicate)
 * 			boolean noneMatch(Predicate<? super  T> predicate)
 * 
 * 
 * The primitive type streams such as IntStream, LongStream, and DoubleStream 
 * 				also contain the same methods that work with a predicate and an optional one for primitive types.
 * All match operations are terminal operations. They are also short-circuiting operations. 
 * 				A short-circuiting operation may not have to process the entire stream to return the result.
 *   
 */
public class P1_Match {
//The following code shows how to perform match operations on streams.
	public static void main(String[] args) {
		List<Employee> persons = Employee.persons();
		
		//check if all persons are males
		boolean allMales = persons.stream().allMatch(Employee::isMale);
		System.out.println("All males: " + allMales);
		
		//check if any person was born in 1971
		boolean anyOneBornIn1971 = persons.stream().anyMatch(p -> p.getDob().getYear() == 1971);
		System.out.println("Anyone born in 1971: " + anyOneBornIn1971);

	}

}
