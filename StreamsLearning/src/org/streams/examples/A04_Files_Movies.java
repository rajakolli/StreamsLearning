package org.streams.examples;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
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
		
		//-------------------------------------------------------------------------------------------
		System.out.println("");
		System.out.println("-----------------------------");
		System.out.println("Movies list");
		
		List<String> movies = lines.stream()
				.skip(1)
				.map(line -> Arrays.asList(line.split(";")))
				.map(list -> {String movie = list.get(0).trim(); return movie;})
				.collect(Collectors.toList());
		System.out.println(movies);
			
		//-------------------------------------------------------------------------------------------
		//or
		System.out.println("");
		System.out.println("-----------------------------");
		System.out.println("or Movies list (Alternate way)");
		List<String> movieNames=lines.stream()
			    .skip(1)
			    .map(line -> Arrays.asList(line.split(";")).get(0).trim())	
			    .collect(Collectors.toList());		
		System.out.println(movieNames);

		//-------------------------------------------------------------------------------------------
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
		
		//-------------------------------------------------------------------------------------------
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
		
		//-------------------------------------------------------------------------------------------
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
			
		//-------------------------------------------------------------------------------------------
		//List of all the "Feature Film" released in 1922 	
		System.out.println("");
		System.out.println("-----------------------------");
		System.out.println("List of all the Feature Film released in 1922");
		List<String> featureFilm2000List=lines.stream()
			     .skip(1)
			     .map(line -> Arrays.asList(line.split(",")))	
			     .filter(movie -> {String movieType=movie.get(1).trim(); 
		                             return (!movieType.equals("")&& 
                                 movieType.equalsIgnoreCase("Feature Film"));})
			     .filter(list -> {String year=list.get(7).trim();
		                            return (!year.equals("")&& 
                                                 year.equals("1922"));})
			     .map(movie -> {String name=movie.get(0); return name;})
			     .collect(Collectors.toList());				   
		System.out.println(featureFilm2000List);
		
		
		//-------------------------------------------------------------------------------------------
		//List of all the "Feature Film" released in 1922 & having IMDB rating greater than or equal to 7
		System.out.println("");
		System.out.println("-----------------------------");
		System.out.println("List of all the Feature Film released in 1922  & having IMDB rating greater than or equal to 7");
		List<String> featureFilm2000ListIMDB77=lines.stream()
	    		.skip(1)
	    		.map(line -> Arrays.asList(line.split(",")))	
	    		.filter(movie -> {String type=movie.get(1).trim();
	    			            return (!type.equals("")&& 
	                                        type.equalsIgnoreCase("Feature Film"));})
	    		.filter(movie -> {String year=movie.get(7).trim();
	    				     return (!year.equals("")&& year.equals("1922"));})
	    		.filter(movie -> {String imdb=movie.get(4).trim();
	    				     return (!imdb.equals("")&&
	                                        Float.parseFloat(imdb) >= 7);})
	    		.map(movie ->    {String movieName=movie.get(0).trim();
	    				     return movieName;})
	    		.collect(Collectors.toList());		
		System.out.println(featureFilm2000ListIMDB77);
		
		//-------------------------------------------------------------------------------------------
		//Find out the minimum runtime of a movie from the dataset, 
		//		In other words what is the minimum duration of any movie among all the movies
		System.out.println("");
		System.out.println("-----------------------------");
		System.out.println("Minimum duration of any movie among all the movies");
		String minimumRuntime=lines.stream()
	  			  .skip(1)
	  			  .map(line -> {String runtime=line.split(",")[6]; 
	                                      return runtime.trim();})	
	  			  .filter(movieRuntime -> !movieRuntime.equals(""))
	  			  .min(Comparator.comparing(time -> Float.parseFloat(time)))
	  			  .get();  				      
	  		
		System.out.println("Minimum Runtime "+minimumRuntime);
		
		//-------------------------------------------------------------------------------------------
		//Find out the maximum  runtime of a movie from the dataset, 
		//		In other words what is the maximum duration of any movie among all the movies
		System.out.println("");
		System.out.println("-----------------------------");
		System.out.println("Maximum duration of any movie among all the movies");		
		String maximumRuntime=lines.stream()
			       .skip(1)
			       .map(line -> {String runtime=line.split(",")[6]; 
                                      return runtime.trim();})	
			       .filter(movieRuntime -> !movieRuntime.equals(""))
			       .max(Comparator.comparing(time -> Float.parseFloat(time)))
			       .get();
			      
		System.out.println("Maximum Runtime "+maximumRuntime);
		
		
		//-------------------------------------------------------------------------------------------
		//List down the Top 5 voted movies on IMDB
		System.out.println("");
		System.out.println("-----------------------------");
		System.out.println("Maximum duration of any movie among all the movies");	
		lines.stream()
	     .skip(1)
	     .map(line -> Arrays.asList(line.split(",")) )
	     .filter(movie -> {String imdbVotes=movie.get(9).trim();
	    		                 return !imdbVotes.equals("");})     		                              
	     .sorted((movie1,movie2) -> {String m1Votes=movie1.get(9).trim();
	    		                    String m2Votes=movie2.get(9).trim();
	    	       return Integer.valueOf(m2Votes).compareTo(Integer.valueOf(m1Votes));} )
	     .limit(5)
	     .forEach(movie -> {System.out.println(movie.get(0)+" --- "+movie.get(9));});
	}

}
