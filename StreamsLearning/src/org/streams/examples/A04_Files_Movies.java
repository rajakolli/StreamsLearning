package org.streams.examples;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class A04_Files_Movies {

	public static void main(String[] args) {
		BufferedReader breader=null;		
		try{	
				//Path path = Paths.get("src/resources", "SIDBM_movie5.csv");
		       	Path path = Paths.get("IDBM_movie5.csv");
		       	
		       breader = Files.newBufferedReader(path, StandardCharsets.ISO_8859_1);       
		    }catch(IOException exception){
		        		System.out.println("Error occurred while trying to read the file");
		       		System.exit(0);
		     	}
				
		List<String> lines=breader.lines().collect(Collectors.toList());
		//System.out.println(lines);
		

		System.out.println("Movies list");
		
		List<String> movies = lines.stream()
				.skip(1)
				.map(line -> Arrays.asList(line.split(";")))
				.map(list -> {String movie = list.get(0).trim(); return movie;})
				.collect(Collectors.toList());
		System.out.println(movies);
			
		//or
		System.out.println("");
		System.out.println("-----------------------------");
		System.out.println("or Movies list (Alternate way)");
		List<String> movieNames=lines.stream()
			    .skip(1)
			    .map(line -> Arrays.asList(line.split(";")).get(0).trim())	
			    .collect(Collectors.toList());		
		System.out.println(movieNames);

		// Lets find out the name of the director who directed movie "The Great Train Robbery "
		System.out.println("");
		System.out.println("-----------------------------");
		System.out.println("Name of the director who directed movie The Great Train Robbery ");
		
		lines.stream()
		  .skip(1)
			  .map(line -> Arrays.asList(line.split(",")))	
			  .filter(movie -> {String movieName=movie.get(0); 
			                    return movieName.trim().equalsIgnoreCase("The Great Train Robbery");})
			  .forEach(list -> {String director=list.get(2);
			                    System.out.println("The Great Train Robbery " + director);});
		
		
		//List the names of all the "Mini-Series" movies from the dataset	
		System.out.println("");
		System.out.println("-----------------------------");
		System.out.println("names of all the Mini-Series movies");
		List<String> miniSeries=lines.stream()
				   .skip(1)
				   .map(line -> Arrays.asList(line.split(",")))	
				   .filter(list -> {String type=list.get(1); 
			                  return type.trim().equalsIgnoreCase("Mini-Series");})
				   .map(movie -> {String movieName=movie.get(0); 
	                               return movieName;})
				   .collect(Collectors.toList());
		System.out.println(miniSeries);
		
		
		//Find out total number of "Mini-Series" movies from the dataset	
		System.out.println("");
		System.out.println("-----------------------------");
		System.out.println("Total number of Mini-Series movies");
		long totalMiniSeries=lines.stream()
				.skip(1)
				.map(line -> Arrays.asList(line.split(",")).get(1))	
				.filter(movieType -> movieType.trim().equalsIgnoreCase("Mini-Series"))
				.count();

			System.out.println("Total Mini-Series Movies : "+totalMiniSeries);
	}

}
