package rajakolli.streams.learning;

import java.util.Map;
import java.util.stream.Collectors;

/*
 * The groupingBy() method from the Collectors class 
 * 		returns a collector that groups the data before collecting them in a Map. 
 * 	It is similar to a "group by" clause in SQL.
 * 
 * 

The groupingBy() method is overloaded and it has three versions:
 * 		* groupingBy(Function<? super  T,?  extends K>  classifier)
 * 		* groupingBy(Function<? super  T,?  extends K>  classifier,  Collector<? super T,A,D> downstream)
 * 		* groupingBy(Function<? super  T,?  extends K>  classifier, Supplier<M>  mapFactory, Collector<? super T,A,D> downstream)
 * 
 * 
 * In the first two versions, the collector takes care of creating the Map object for you. 
 * The third version allows us to specify a Supplier used as the factory to get the Map object.
 * 
 * 'cassifier' function generates the keys in the map. collector performs a reduction operation on the values associated with each key.
 * The following code shows how to group people by gender and count the number of people in each group.
 * The counting() method of the Collectors class returns a Collector to count the number of elements in a stream.
 * 
 */
public class L4_Group { 
// The following code groups people by gender. Within each gender group, it creates another group based on the month of their births and lists the names of the people born in this group.
	public static void main(String[] args) {
			    
		Map personsByGenderAndDobMonth = Employee.persons()
				.stream()
				.collect(Collectors.groupingBy(Employee::getGender, 
						Collectors.groupingBy(p -> p.getDob().getMonth(),
						Collectors.mapping(Employee::getName, Collectors.joining(", ")))));
		
	    System.out.println(personsByGenderAndDobMonth);

	}

}
