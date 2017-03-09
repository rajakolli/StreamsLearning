package org.streams.examples;

import java.util.stream.Stream;

/*
 * Streams map() operation creates a one-to-one mapping.
 * Streams flatMap() supports one-to-many mapping. 
  			It maps each element to a stream 
  				and then flatten the stream of streams to a stream.

 */
public class C4_FlatMap {
/*
	The following code shows how to convert a stream of strings to a stream of characters.
	
	The code maps the strings to IntStream returns from chars() method of the String class.
	The output of the map() method is Stream<IntStream>.
	The flatMap() method maps the Stream<IntStream> to Stream<Stream<Character>> and finally, 
		flattens it to produce a Stream<Character>.
	The code above generates the following result.
 */
	public static void main(String[] args) {
		Stream.of("XML", "Java", "CSS")
				.map(name -> name.chars())
				.flatMap(IntStream -> IntStream.mapToObj(n -> (char)n))
				.forEach(System.out::println);
		

	}

}
