package rajakolli.streams.examples;
import java.util.stream.Collectors;
import java.util.stream.Stream;
public class One1 {

	public static void main(String[] args) {
	    Stream<String> s = Stream.of("1","2","3");
	    
	    double o =  s.collect(Collectors.averagingDouble(n->Double.parseDouble(n)));

	    System.out.println(o);

	}

}
