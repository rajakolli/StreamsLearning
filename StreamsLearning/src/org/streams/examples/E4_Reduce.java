package org.streams.examples;

import java.util.Currency;

/*
 * The reduce() operation combines all elements in a stream to produce a single value.
 * The reduce operation takes two parameters called a seed (initial value) and an accumulator.
 * The accumulator is a function. If the stream is empty, the seed is the result.
 * The seed and an element are passed to the accumulator, which returns partial result. 
 * 			And then the partial result and the next element are passed to the accumulator function.
 * This repeats until all elements are passed to the accumulator. 
 * 			The last value returned from the accumulator is the result of the reduce operation.
 * The stream-related interfaces contain two methods called reduce() and collect() to perform generic reduce operations.
 * Methods such as sum(), max(), min(), count(), 
 * 			are defined in IntStream, LongStream, and DoubleStream interfaces.
 * count() method is available for all types of streams.
 * The Stream<T> interface contains a reduce() method to perform the reduce operation. 
 * 			The method has three overloaded versions:
 * 				T  reduce(T identity, BinaryOperator<T> accumulator)
 * 				<U> U reduce(U identity, BiFunction<U,? super  T,U> accumulator, BinaryOperator<U> combiner)
 * 				Optional<T> reduce(BinaryOperator<T> accumulator)
 */


/*
 * Java Streams API supports map reduce operations in parallel.
 * When using the following reduce method, each thread accumulates the partial results using the accumulator. 
 * 			At the end, the combiner is used to combine the partial results from all threads to get the result.
 * 
 * 			<U> U reduce(U identity, BiFunction<U,? super  T,U> accumulator, BinaryOperator<U> combiner)
 */

public class E4_Reduce {

// The following code shows how the sequential and parallel reduce operation works.
	
	public static void main(String[] args) {
		double	sum = Employee.persons()
							.stream()
							.reduce(
									0.0, 
									(Double partialSum, Employee p) -> {
										double accumulated = partialSum + p.getIncome();
										System.out.println(Thread.currentThread().getName()
											+ " -  Accumulator: partialSum = " + partialSum
											+ ", person = " + p + ", accumulated = " +	accumulated);
									return accumulated;
							}, 
								(a, b) -> {
									double combined = a + b;
									System.out.println(Thread.currentThread().getName()
										+ " - Combiner: a = " + a + ", b = " + b
										+ ", combined = " + combined);
										return combined;
								});
		System.out.println("--------------------------------------------------------------------");
		System.out.println(sum);
		
		sum = Employee
				.persons()
				.parallelStream()
				.reduce(
						0.0,
						(Double partialSum, Employee p) -> {
							double	accumulated	= partialSum = p.getIncome();
							System.out.println(Thread.currentThread().getName()
								+ "  - Accumulator: partialSum = " + partialSum
								+ ", person = " + p + ", accumulated = " + accumulated);
							return accumulated;
						},
						(a, b) -> {
							double combined = a + b;
							System.out.println(Thread.currentThread().getName()
								+ "  -Combiner: a = " + a + ", b = " + b
								+ ", combined = " + combined);
							return combined;
						});
	}
}
