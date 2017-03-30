package rajakolli.streams.examples;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import java.util.stream.Stream;


public class Average {

	public static void main(String[] args) {
		
		//List<Double> simpleList = Arrays.asList(1.1,2.1,2.2,3.1,1.5,5.3);
		//List<Double> simpleList = Arrays.asList(2.0, 3.0, 1.0, 2.0, 3.0, 1.0);
	    List<Double> simpleList = Arrays.asList(2.1, 3.1, 1.1, 2.1, 3.1, 1.1);
		
		Double average = simpleList.stream().mapToDouble(val -> val).average().getAsDouble();
	    System.out.println("average of test is : " +average);

	    
	    String[][] names = { {"Sam", "Smith"},
                {"Robert", "Delgro"},
                {"James", "Gosling"},
              };
	    /*
	    for (String[] a : names) {
	        for (String s : a) {
	            System.out.println(s);
	        }
	    }
	    */
	    
	    //Arrays.asList(names).stream().forEach(System.out::println);
	    //Stream.of(names).map(Arrays::toString).forEach(System.out::println);
	    //System.out.println(Arrays.deepToString(names));
	    
	    /*
	    Stream.of(names)
	    .flatMap(Stream::of)
	        .forEach(System.out::println);
	    
	    */
	    Arrays.stream(names)
	    .map(a -> String.join(" ", a))
	        .forEach(System.out::println);
	    

	    System.out.println(
	    	    Arrays.stream(names)
	    	        .map(a -> String.join(" ", a))
	    	            .collect(Collectors.joining(", "))
	    	);
	    

	    
	}

}
