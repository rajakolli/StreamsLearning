package rajakolli.streams.learning;

/*
 * A map operation applies a function to each element to produce another stream.
 * The number of elements in the input and output streams is the same.
 * The operation does not modify the elements of the input stream.
 * 
 * You can apply the map operation on a stream using one of the following methods of the Stream<T> interface:
 				<R> Stream<R> map(Function<? super T,? extends R> mapper)
				DoubleStream  mapToDouble(ToDoubleFunction<? super T> mapper)
				IntStream     mapToInt(ToIntFunction<? super T> mapper)
				LongStream    mapToLong(ToLongFunction<? super T> mapper)

 * IntStream, LongStream and DoubleStream also define map functions. 
 * 		The methods supporting the map operation on an IntStream are as follows:
				IntStream     map(IntUnaryOperator mapper)
				DoubleStream  mapToDouble(IntToDoubleFunction mapper)
				LongStream    mapToLong(IntToLongFunction   mapper)
				<U> Stream<U> mapToObj(IntFunction<? extends  U>  mapper)
 */
public class C2_Map {
/*
  The following code maps a stream of employees to their names 
  		and prints the mapped stream.
 */
	public static void main(String[] args) {
		Employee.persons()
				.stream()
				.map(Employee::getName)
				.forEach(System.out::println);

	}

}
