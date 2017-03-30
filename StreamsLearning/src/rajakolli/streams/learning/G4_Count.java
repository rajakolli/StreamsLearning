package rajakolli.streams.learning;
/*
 * Streams support a count operation through the count() 
 * 				method that returns the number of elements in the stream as a long.
 *
 */
public class G4_Count {
// The following code uses the reduce() method to implement the count operation.
	
	public static void main(String[] args) {
		long personCount = Employee.persons()
				.stream()
				.reduce(0L, (partialCount, person) -> partialCount + 1L, Long::sum);
		System.out.println(personCount);

	}

}
