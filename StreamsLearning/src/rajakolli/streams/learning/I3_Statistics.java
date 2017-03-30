package rajakolli.streams.learning;

import java.util.DoubleSummaryStatistics;
import java.util.stream.Collectors;

/*
 * Numeric Stream summary statistics
 * 
 *   The Collectors class contains methods to compute the summary statistics for the specific type of numeric data.
 *  		* Collectors.summarizingDouble() returns a DoubleSummaryStatistics.
 *  		* Collectors.summarizingLong() returns a LongSummaryStatistics.
 *  		* Collectors.summarizingInt() returns a IntSummaryStatistics.
 *  
 *  The Collectors class contains methods such as 
 *  	* counting(), 
 *  	* summingDouble(), 
 *  	* summingInt(), 
 *  	* summingLong(), 
 *  	* averagingDouble(), 
 *  	* averagingLong(),
 *  	* averagingInt(), 
 *  	* minBy(), 
 *  	* and maxBy() 
 *  that return a collector to perform a specific type of summary computation.
 */

public class I3_Statistics {
	// The following code shows how to calculate the summary statistics for income.
	public static void main(String[] args) {
		DoubleSummaryStatistics incomeStats = Employee.persons()
				.stream()
				.collect(Collectors.summarizingDouble(Employee::getIncome));
		System.out.println(incomeStats);

	}

}
