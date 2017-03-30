package org.streams.examples;
/*
 * We can collect data from a stream to a Map.
 * 
 * The toMap() overloaded in three versions method of the Collectors class returns a collector to collect data in a Map.
 * 			toMap(Function<? super T,? extends K> keyMapper, Function<? super T,? extends U> valueMapper)
 * 			toMap(Function<? super T,? extends K> keyMapper, Function<? super T,? extends U> valueMapper, BinaryOperator<U> mergeFunction)
 * 			toMap(Function<? super T,? extends K> keyMapper, Function<? super T,? extends U> valueMapper, BinaryOperator<U> mergeFunction, Supplier<M>  mapSupplier)
 * 
 */

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/* 
* The second form of toMap listed as follows has an extra merged function.
* 			toMap(Function<? super T,? extends K> keyMapper, Function<? super T,? extends U> valueMapper, BinaryOperator<U> mergeFunction)
* 
* The merged function is passed the old and new values for the duplicate key.
* 			The function should merge the two values and return a new value that will be used for the key.
* 
*/
public class J4_CollectMap {
//The following code get the highest earner by gender in a Map.
	public static void main(String[] args) {
		Map<Employee.Gender, Employee> highestEarnerByGender = Employee.persons()
				.stream()
				.collect(Collectors.toMap(Employee::getGender, 
										Function.identity(), 
										(oldPerson, newPerson) -> oldPerson.getIncome() > oldPerson.getIncome() ? newPerson : oldPerson));
		System.out.println(highestEarnerByGender);

	}

}
