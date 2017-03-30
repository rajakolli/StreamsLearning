package rajakolli.streams.learning;
/*
 * Streams support a count operation through the count() 
 * 				method that returns the number of elements in the stream as a long.
 *
 */
public class G2_Count {
//The following code uses the map() method to count the number of elements in a stream.
	
	public static void main(String[] args) {
		long personCount = Employee.persons()
				.stream()
				.mapToLong(P -> 1L)
				.sum();	
	System.out.println(personCount);
	}

}
