package rajakolli.streams.learning;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/*
 * Streams map() operation creates a one-to-one mapping.
 * Streams flatMap() supports one-to-many mapping. 
  			It maps each element to a stream 
  				and then flatten the stream of streams to a stream.

 */
public class D3_FlatMap {
/*
	The following code flatMaps the stream of string values to a IntStreams, 
			then maps IntStream to Stream of characters.
 */
	public static void main(String[] args) {
		Stream.of("XML", "Java", "CSS")
				.flatMap(name ->  IntStream.range(0, name.length())
				.mapToObj(name::charAt))
				.forEach(System.out::println);

	}

}
