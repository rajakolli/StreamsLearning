package rajakolli.streams.examples;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class One3 {

	public static void main(String[] args) {
		 List<Student> students = new ArrayList<Student>();
		  students.add(new Student("John", 35));
		  students.add(new Student("Wendy", 43));
		  students.add(new Student("Scott", 22));
		  students.add(new Student("Joe", 17));
		  students.add(new Student("Brad", 43));

		  Stream<Student> studentStream1 = students.stream();

		  //1. Get all Student Names
		  List<String> listOfNames = studentStream1
				  .map(Student::getName)
				  .collect(Collectors.toList());
		  
		  System.out.println("----------------------------------------------------------------");
		  System.out.println("1. Get all Student Names");
		  System.out.println(listOfNames);
		  

		  //2. Filter names starting with "J"
		  Stream<Student> studentStream2 = students.stream();
		  List<String> listOfNamesStartsWithJ = studentStream2
				  .filter(x -> x.getName().startsWith("J"))
				  .map(Student::getName)
				  .collect(Collectors.toList());
		  
		  System.out.println("----------------------------------------------------------------");
		  System.out.println("2. Filter names starting with J");
		  System.out.println(listOfNamesStartsWithJ);

		  //3. Get List of person objects whose name starts with "J"
		  Stream<Student> studentStream3 = students.stream();
		  List<Student> listOfPersons = studentStream3
				  .filter(x -> x.name.startsWith("J"))
				  .collect(Collectors.toList());

		  System.out.println("----------------------------------------------------------------");
		  System.out.println("3. Get List of person objects whose name starts with");
		  System.out.println(listOfPersons);
		  

		  
		  //4. Sort names using TreeSet
		  Stream<Student> studentStream4 = students.stream();
		  Set<String> setofName = studentStream4
				  .map(Student::getName)
				  .collect(Collectors.toCollection(TreeSet::new));

		  System.out.println("----------------------------------------------------------------");
		  System.out.println("4. Sort names using TreeSet");
		  System.out.println(setofName);
		  
		  
		  //5. Get sum of marks for all students
		  Stream<Student> studentStream5 = students.stream();
		  int totalMarks= studentStream5
				  .collect(Collectors.summingInt(Student::getMarks));

		  System.out.println("----------------------------------------------------------------");
		  System.out.println("5. Get sum of marks for all students");
		  System.out.println(totalMarks);		  
		  
		  
		  //6. Get average of marks for all students
		  Stream<Student> studentStream6 = students.stream();
		  Double avgMarks= studentStream6
				  .collect(Collectors.averagingDouble(Student::getMarks));

		  System.out.println("----------------------------------------------------------------");
		  System.out.println("6. Get average of marks for all students");
		  System.out.println(avgMarks);		  
		  
		  
		  //6.B. Get average of marks for all students (alternative)
		  Stream<Student> studentStream6B = students.stream();
		  Double avgMarks2= studentStream6B
				  .collect(Collectors.averagingDouble(x -> x.marks));

		  System.out.println("----------------------------------------------------------------");
		  System.out.println("6.B. Get average of marks for all students (alternative)");
		  System.out.println(avgMarks2);		  
		  
		  
		  //7. Group by marks
		  Stream<Student> studentStream7 = students.stream();
		  Map<Integer, List<Student>> studentMap = studentStream7
				  .collect(Collectors.groupingBy(x -> x.marks));

		  System.out.println("----------------------------------------------------------------");
		  System.out.println("7. Group by marks");
		  System.out.println(studentMap);
		  System.out.println("---");
		  studentMap.forEach((marks, studentName) -> System.out.format("Students with Marks %s are : %s\n", marks, studentName)); 
	}

}
