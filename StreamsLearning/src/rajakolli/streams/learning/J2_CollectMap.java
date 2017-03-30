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
* The second form of toMap listed as follows has an extra merged function.
* 			toMap(Function<? super T,? extends K> keyMapper, Function<? super T,? extends U> valueMapper, BinaryOperator<U> mergeFunction)
* 
* The merged function is passed the old and new values for the duplicate key.
* 			The function should merge the two values and return a new value that will be used for the key.
* 
*/
public class J2_CollectMap {
//The following code shows how to concatenate the names of all males and females.
	
	public static void main(String[] args) {
		    	    
		Map<Employee.Gender, String> genderTonameMap = Employee.persons()
				.stream()
				.collect(Collectors.toMap(Employee::getGender, 
										Employee::getName, 
										(oldValue, newValue) -> String.join(", ", oldValue, newValue)));
		System.out.println(genderTonameMap);
				

	}

}
