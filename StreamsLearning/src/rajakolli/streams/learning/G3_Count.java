package rajakolli.streams.learning;
/*
 * Streams support a count operation through the count() 
 * 				method that returns the number of elements in the stream as a long.
 *
 */
public class G3_Count {
// The following code uses the map() and reduce() methods to implement the count operation.
	
	public static void main(String[] args) {
		long personCount = Employee.persons()
				.stream()
				.map(p -> 1L)
				.reduce(0L, Long::sum);
		
		System.out.println(personCount);

	}

}
