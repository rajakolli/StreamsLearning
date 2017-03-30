package rajakolli.streams.learning;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class A04_Files_Shoes {

	public static void main(String[] args) {
		BufferedReader breader=null;		
		try{	
				//Path path = Paths.get("src/resources", "Shoelist.csv");
		       	Path path = Paths.get("Shoelist.csv");
		       	
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
		System.out.println("Shoes list");
		List<String> shoes = lines.stream()
				.skip(1)
				.map(line -> Arrays.asList(line.split(",")))
				.map(list -> {String shoe = list.get(0).trim(); return shoe;})
				.collect(Collectors.toList());		
		System.out.println(shoes);
		
		//-------------------------------------------------------------------------------------------
		//Alternatively
		System.out.println("");
		System.out.println("-----------------------------");
		System.out.println(" (or) Shoes list (Alternatively)");
		List<String> shoesList=lines.stream()
			    .skip(1)
			    .map(line -> Arrays.asList(line.split(",")).get(0).trim())	
			    .collect(Collectors.toList());		
		System.out.println(shoesList);

		//-------------------------------------------------------------------------------------------
		// Lets find out the type of shoes made  Brand "Nike"
		System.out.println("");
		System.out.println("-----------------------------");
		System.out.println("Type of shoes made  Brand Nike");
		
		lines.stream()
		  .skip(1)
			  .map(line -> Arrays.asList(line.split(";")))	
			  .filter(movie -> {String brandName=movie.get(1); 
			                    return brandName.trim().equalsIgnoreCase("Nike");})
			  .forEach(list -> {String shoeFor=list.get(2);
			                    System.out.println(" Nike makes " + shoeFor);});
		
		
		//-------------------------------------------------------------------------------------------
		//List the Names of all "Sport-Shoes" shoes from the dataset	
		System.out.println("");
		System.out.println("-----------------------------");
		System.out.println("Names of all the Sport-Shoes");
		List<String> sportShoe=lines.stream()
				   .skip(1)
				   .map(line -> Arrays.asList(line.split(";")))	
				   .filter(list -> {String type=list.get(2); 
			                  return type.trim().equalsIgnoreCase("Sport-Shoes");})
				   .map(shoe -> {String shoeName=shoe.get(0); 
	                               return shoeName;})
				   .collect(Collectors.toList());
		System.out.println(sportShoe);
		
		//-------------------------------------------------------------------------------------------
		//Find out total number of "Mini-Series" movies from the dataset	
		System.out.println("");
		System.out.println("-----------------------------");
		System.out.println("Total number of Sport-Shoes");
		long totalsportShoes=lines.stream()
				.skip(1)
				.map(line -> Arrays.asList(line.split(";")).get(2))	
				.filter(shoeType -> shoeType.trim().equalsIgnoreCase("Sport-Shoes"))
				.count();

			System.out.println("Total Sport-Shoes : "+totalsportShoes);		
	}

}