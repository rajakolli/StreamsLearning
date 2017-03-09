package org.streams.learning;
import java.util.stream.Stream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.io.IOException;

public class ShoeAverage {

	 public static void main(String[] args) 
     { 
		//Shoelist csv file assumed in current location of the class
		String fileName = "Shoelist.csv";
		try (Stream<String> lines = Files.lines(Paths.get(fileName)))
		{
			
			List<List<String>> values = lines
						.skip(1)
						.map(line -> Arrays.asList(line.split(",")))
						.filter(list -> list.get(2).startsWith("He-Shoes")) // keep only items where the name like "Male"
						.collect(Collectors.toList());


		    values.forEach((l)->System.out.println(l.get(3)));
		}
		catch (IOException e) {
			e.printStackTrace();
		}

     } 
}
