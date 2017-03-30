package rajakolli.streams.learning;

import java.util.Comparator;
import java.util.Optional;

/*
 * To compute the sum, max, min, average, etc. on a numeric stream, 
 * 		we can map the non-numeric stream into numeric stream types (IntStream, LongStream, or DoubleStream) 
 * 				and then use the specialized methods.
 */
public class F2_Aggregation {
	/*
	 * To get the minimum and maximum values of a stream, 
	 * 			use the min() and max() methods of the specific stream.
	 */
	public static void main(String[] args) {
		Optional<Employee> person = Employee.persons().stream()
				.max(Comparator.comparing(Employee::getIncome));
		
		if (person.isPresent()) {
			System.out.println("Highest earner: " + person.get());
		} else {
			System.out.println("Could not get the highest earner.");
		}
	}
}
