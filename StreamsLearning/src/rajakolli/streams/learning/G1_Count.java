package rajakolli.streams.learning;
/*
 * Streams support a count operation through the count() 
 * 				method that returns the number of elements in the stream as a long.
 *
 */
public class G1_Count {
//	The following code prints the number of elements in the stream of employee.
	
	public static void main(String[] args) {
		long	personCount	= Employee.persons().stream().count();
		System.out.println(personCount);

	}

}
