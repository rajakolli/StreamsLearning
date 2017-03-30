package rajakolli.streams.learning;

import java.util.Optional;
import java.util.stream.Stream;

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
 * The third version of the reduce() listed as follows method is used to perform a reduction operation without default value.
 * 			reduce(BinaryOperator<T> accumulator)
 * 
 * The third version of the reduce() listed as follows method is used to perform a reduction operation without default value.
 * If the stream is empty, we cannot use default value as 0.
 * Optional<T> is used to wrap the result or the absence of a result.
 */

public class E5_Reduce {
//Streams Reduce without default value
	//The following code shows how to compute the maximum of integers in a stream:
	
	public static void main(String[] args) {
		Optional<Integer> max = Stream.of(1,2,3,4,5).reduce(Integer::max);
		if(max.isPresent()) {
			System.out.println("max = " + max.get());
		} else {
			System.out.println("max is not defined.");
		}
		
		max = Stream.<Integer> empty().reduce(Integer::max);
		if (max.isPresent()) {
			System.out.println("max = " + max.get());
		} else {
			System.out.println("max is not defined.");
		}

	}

}
