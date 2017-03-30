package rajakolli.streams.learning;

import java.util.OptionalDouble;

/*
 * To compute the sum, max, min, average, etc. on a numeric stream, 
 * 		we can map the non-numeric stream into numeric stream types (IntStream, LongStream, or DoubleStream) 
 * 				and then use the specialized methods.
 */
public class F3_Aggregation {
/*
 * The following code prints the highest income in the employee list using the max() method of the DoubleStream:
 */
	public static void main(String[] args) {
		OptionalDouble income = Employee.persons()
				.stream()
				.mapToDouble(Employee::getIncome).max();
		
		if(income.isPresent()) {
			System.out.println("Highest income: " + income.getAsDouble());
		} else {
			System.out.println("Could not get the highest income.");
		}
	}
}
