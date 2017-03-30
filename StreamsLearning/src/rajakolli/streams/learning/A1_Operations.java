package rajakolli.streams.learning;

// simple streams example using peek, filter, map and reduce 

import java.util.stream.Stream;

public class A1_Operations {

	public static void main(String[] args) {
		int sum = Stream.of(1,2,3,4,5)
				.peek(e -> System.out.println("Current integer in the stream: " + e))
				.filter(n -> n % 2 == 1)
				.peek(e -> System.out.println("Filtered ODD integer in the stream is: " + e))
				.map(n -> n * n)
				.peek(e -> System.out.println("Mapped intefer SQUARE is: " + e))
				.reduce(0, Integer::sum);
		System.out.println("Sum = " + sum);

	}

}
