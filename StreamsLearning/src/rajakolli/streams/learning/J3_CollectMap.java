package rajakolli.streams.learning;

import java.util.Map;
import java.util.stream.Collectors;

/*
 * We can collect data from a stream to a Map.
 * 
 * The toMap() overloaded in three versions method of the Collectors class returns a collector to collect data in a Map.
 * 			toMap(Function<? super T,? extends K> keyMapper, Function<? super T,? extends U> valueMapper)
 * 			toMap(Function<? super T,? extends K> keyMapper, Function<? super T,? extends U> valueMapper, BinaryOperator<U> mergeFunction)
 * 			toMap(Function<? super T,? extends K> keyMapper, Function<? super T,? extends U> valueMapper, BinaryOperator<U> mergeFunction, Supplier<M>  mapSupplier)
 * 
 */


/* 
* The third version listed as follows allows us to use a Supplier to provide a Map object.
* 			toMap(Function<? super T,? extends K> keyMapper, Function<? super T,? extends U> valueMapper, BinaryOperator<U> mergeFunction, Supplier<M>  mapSupplier)
* 
*/
public class J3_CollectMap {
//The following code summarizes the number of people by gender.
	public static void main(String[] args) {
		Map<Employee.Gender, Long> countByGender = Employee.persons()
				.stream()
				.collect(Collectors.toMap(Employee::getGender, p -> 1L, (oldCount, newColunt) -> newColunt+oldCount));
		
		System.out.println(countByGender);

	}

}
