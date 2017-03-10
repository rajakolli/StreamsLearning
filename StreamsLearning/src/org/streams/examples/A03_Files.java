package org.streams.examples;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class A03_Files {

	public static void main(String[] args) {
			Path path = Paths.get("Shoelist.csv");
			
			//try (Stream<String> lines = Files.lines(path)) {
			try (Stream<String> lines = Files.lines(path)) {
				lines.forEach(System.out::println);
				
				
				//List<String> data =  lines.toArray(String[]::new);


				//lines.filter(p -> p.contains("He-Shoes")).forEach(System.out::println);
				//lines.map(Shoes::getName).forEach(System.out::println);
				
/*
				List<String> result = lines.collect(Collectors.toList());
				result.forEach(System.out::println);
*/
				
//				result.stream().map(Shoes::getName)

//				List<Shoes> shoes = Arrays.asList( lines.map(e -> e.toCharArray()));
//				shoes.forEach(System.out::println);
				//shoes.forEach(System.out::println);
				//List<Shoes> shoes = Arrays.asList(lines.collect(ArrayList::new, ArrayList::add, ArrayList::addAll));
				//List<Shoes> shoes = lines.collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
						
				//lines.map(Shoes::getName).
				
				
				
				
		} catch (IOException e) {
			e.printStackTrace();
		}

		}
		
		public class Shoes {


			private String name;
			private String brand;
			private String type;
			private double cost;
			
			 public Shoes(String line) {
				 String[] words =line.split(",");
				 
				    this.name = words[0];
				    this.brand = words[1];
				    this.type = words[2];
				    this.cost = Double.parseDouble(words[3]);
				  }
			
			public String getName() {
				return name;
			}
			public void setName(String name) {
				this.name = name;
			}
			public String getBrand() {
				return brand;
			}
			public void setBrand(String brand) {
				this.brand = brand;
			}
			public String getType() {
				return type;
			}
			public void setType(String type) {
				this.type = type;
			}
			public double getCost() {
				return cost;
			}
			public void setCost(double cost) {
				this.cost = cost;
			}
			
		}

	}
