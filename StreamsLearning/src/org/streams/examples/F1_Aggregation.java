package org.streams.examples;
/*
 * To compute the sum, max, min, average, etc. on a numeric stream, 
 * 		we can map the non-numeric stream into numeric stream types (IntStream, LongStream, or DoubleStream) 
 * 				and then use the specialized methods.
 */
public class F1_Aggregation {
	/*
	 * The following code calculates the sum of the incomes. 
	 * 		mapToDouble() method converts a Stream<Employee> to a DoubleStream. 
	 * 		The sum() method is called on the DoubleStream.
	 */
	public static void main(String[] args) {
		double	totalIncome = Employee.persons()
							.stream()
							.mapToDouble(Employee::getIncome)
							.sum();
		System.out.println(totalIncome);
	}

}
