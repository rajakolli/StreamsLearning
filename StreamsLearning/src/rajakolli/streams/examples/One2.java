package rajakolli.streams.examples;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import java.util.stream.Collectors;

public class One2 {

	public static void main(String[] args) {

		Employee e1 = new Employee("Mikalai", "Development");
		Employee e2 = new Employee("Volha", "HR");
		Employee e3 = new Employee("Anastasia", "Management");
		Employee e4 = new Employee("Daria", "Management");
		Employee e5 = new Employee("Ivan", "Management");

		Stream<Employee> str = Stream.of(e1, e2, e3, e4, e5);

		// Group Employees by department
		Map<String, List<Employee>> map = str.collect(Collectors.groupingBy(Employee::getDepartment));

		System.out.println(map.get("Management"));

	}

}
