package org.streams.examples;

import java.util.stream.Stream;

/*
 * Streams map() operation creates a one-to-one mapping.
 * Streams flatMap() supports one-to-many mapping. 
  			It maps each element to a stream 
  				and then flatten the stream of streams to a stream.

 */
public class C3_FlatMap {

/*
	The following code maps a stream of three numbers: 1, 2, and 3 
			to produce a stream that contains the numbers and their next numbers. 		
			The output stream should be 1,2,2,3,3,4. 
 */
	public static void main(String[] args) {
		Stream.of(1,2,3)
				.flatMap(n -> Stream.of(n, n+1))
				.forEach(System.out::println);

	}

}
