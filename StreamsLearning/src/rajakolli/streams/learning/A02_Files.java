package org.streams.examples;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class A02_Files {

	public static void main(String[] args) {
		Path dir = Paths.get(".");
		System.out.printf("%nThe file tree for %s%n", 
				dir.toAbsolutePath());
		try (Stream<Path> fileTree = Files.walk(dir)) {
			fileTree.forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
