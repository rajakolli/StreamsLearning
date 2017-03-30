package rajakolli.streams.learning;

/*
* The filter operation produces a filtered stream, 
 		a subset of the input stream, 
 		whose elements evaluate to true for the specified predicate.
* A predicate is a function that accepts an element and returns a boolean value.
* The filtered stream has the same type as the input stream.
* If the predicate evaluates to false for all elements, 
 		it produces an empty stream.
*/

//print Male employees whose salary is > 5000 (combining 2 filters with &&
public class B2_Filter {

	public static void main(String[] args) {
		Employee.persons()
		.stream()
		.filter(p -> p.isMale() && p.getIncome() > 5000.0)
		.map(Employee::getName)
		.forEach(System.out::println);

	}

}
