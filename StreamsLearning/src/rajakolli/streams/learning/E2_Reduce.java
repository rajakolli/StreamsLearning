package rajakolli.streams.learning;

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

public class E2_Reduce {

	public static void main(String[] args) {
		
//To compute the sum of the incomes of all employee	
		double sum = Employee.persons()
					.stream()
					.map(Employee::getIncome)
					.reduce(0.0,  Double::sum);
		System.out.println(sum);
					

	}

}
