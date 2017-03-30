package rajakolli.streams.learning;

import java.util.ArrayList;
import java.util.List;

/*
 * To group data in a Stream we can use collect() method of the Stream<T> interface.
 * The collect() method is overloaded with two versions:
 * 
 * <R> R collect(Supplier<R> supplier, BiConsumer<R,? super T> accumulator, BiConsumer<R,R> combiner)
 * <R,A> R collect(Collector<?  super T,A,R> collector)
 * 
 * The first version of the collect() method takes three arguments:
 * 			A supplier that supplies a mutable container to store the results.
 * 			An accumulator that accumulates the results into the mutable container.
 * 			A combiner that combines the partial results when used in parallel.
 * 
 * We use the following steps to collect the employee names in an ArrayList<String>.
 * 		First, create a supplier which returns an ArrayList<String> 
 * 			using either of the following statements to create the supplier:
 * 				Supplier<ArrayList<String>> supplier = () -> new ArrayList<>();
 * 				or
 * 				Supplier<ArrayList<String>> supplier = ArrayList::new;
 * 
 * 		Second, create an accumulator that receives two arguments which is the container returned from 
 * 			the supplier(ArrayList<String> in this case). and the element of the stream.
 * 
 * The accumulator adds the names to the list.
 * 		BiConsumer<ArrayList<String>, String>  accumulator = (list, name)  ->  list.add(name);
 * 		BiConsumer<ArrayList<String>, String>  accumulator = ArrayList::add;
 * 
 * Finally, a combiner combines the results into one ArrayList<String>.
 * The combiner is used only in a parallel stream.
 */
public class H1_Collectors {
//The following code shows how to use the collect() method to collect the names of all employee in a list.
	
	public static void main(String[] args) {
		List<String> names = Employee.persons()
				.stream()
				.map(Employee::getName)
				.collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
		System.out.println(names);
	

	}

}
