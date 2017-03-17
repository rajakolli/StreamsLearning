package org.streams.learning;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {

	 public static void main(String[] args) 
    { 
		
		String fileName = "src/main/resources/META-INF/csv/guitar-db.csv";
		try (Stream<String> lines = Files.lines(Paths.get(fileName)))
		{

			List<List<String>> values = lines
						.skip(1)
						.map(line -> Arrays.asList(line.split(";")))
						.filter(list -> list.get(2).equals("electric")) // keep only items where the type is "acoustic"
						.collect(Collectors.toList());
						
				values.forEach((l)->System.out.println(l.get(3)));
				


/*			
			    Stream<String> s = Stream.of("1","2","3");
			    double o =  s.collect(Collectors.averagingDouble(n->Double.parseDouble(n)));
			    System.out.println(o);
				
*/
				
		}
		catch (IOException e) {
			e.printStackTrace();
		}

    } 
}