package rajakolli.streams.learning;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;



public class A01_Files {
// The following code shows how to read contents of a file using a stream.
	public static void main(String[] args) {
		Path path = Paths.get("Shoelist.csv");
		
		try (Stream<String> lines = Files.lines(path)) {
			
			//lines.forEach(System.out::println);
			lines.filter(p -> p.contains("He-Shoes")).forEach(System.out::println);
	
		/*
			List<String> shoes = lines.collect(Collectors.toList());
			shoes.forEach(System.out::println);
	    */
			
		} catch (IOException e) {
		e.printStackTrace();
	}

	}
}
