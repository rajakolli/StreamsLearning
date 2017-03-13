package org.streams.examples;

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
* The first version takes two arguments. Both arguments are a Function.
* 			toMap(Function<? super T,? extends K> keyMapper, Function<? super T,? extends U> valueMapper)
* 
* The first argument maps the stream elements to keys in the map.
* The second argument maps stream elements to values in the map.
* If duplicate keys are found, an IllegalStateException is thrown.
* 
* 
*/

public class J1_CollectMap {
/*
 * 
 * The following code collects a employee's data in a Map<long,String> whose keys are the employee's ids and values are employee's names.
 *			toMap(Function<? super T,? extends K> keyMapper, Function<? super T,? extends U> valueMapper)
 * 
 */
	public static void main(String[] args) {
		Map<Long, String> idToNameMap	= Employee.persons()
				.stream()
				.collect(Collectors.toMap(Employee::getId, Employee::getName));
		System.out.println(idToNameMap);

	}

}
