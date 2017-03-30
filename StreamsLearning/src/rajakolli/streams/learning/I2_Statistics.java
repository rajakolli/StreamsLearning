package org.streams.examples;

import java.util.DoubleSummaryStatistics;

/*
 * Streams summary statistics
 * 
 *  * The summary statistics classes are designed to be used with streams.
 * 	* They contain a combine() method that combines two summary statistics.
 * 
 * 
 * The java.util package contains three classes to collect statistics:
 * 		* DoubleSummaryStatistics
 * 		* LongSummaryStatistics
 * 		* IntSummaryStatistics
 * 
 * We can use them to compute the summary statistics on any group of numeric data.
 */

public class I2_Statistics {
	//	The following code shows how to compute the summary statistics for incomes.
	
	public static void main(String[] args) {
		DoubleSummaryStatistics incomeStats = Employee.persons()
				.stream()
				.map(Employee::getIncome)
				.collect(DoubleSummaryStatistics::new, 
						DoubleSummaryStatistics::accept,
						DoubleSummaryStatistics::combine);
		System.out.println(incomeStats);

	}

}
