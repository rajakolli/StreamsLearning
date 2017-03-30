package rajakolli.streams.learning;

import java.util.DoubleSummaryStatistics;


/*
 * The java.util package contains three classes to collect statistics:
 * 		* DoubleSummaryStatistics
 * 		* LongSummaryStatistics
 * 		* IntSummaryStatistics
 * 
 * We can use them to compute the summary statistics on any group of numeric data.
 */
public class I1_Statistics {
// The following code shows how to compute the statistics on a number of double values.
	public static void main(String[] args) {
		DoubleSummaryStatistics stats  = new DoubleSummaryStatistics();
		stats.accept(100.0);
	    stats.accept(300.0);
	    stats.accept(230.0);
	    stats.accept(532.0);
	    stats.accept(422.0);
	    
	    long count = stats.getCount();
	    double sum = stats.getSum();
	    double min = stats.getMin();
	    double max = stats.getMax();
	    double avg = stats.getAverage();
	    
	    System.out.printf( "count=%d, sum=%.2f, min=%.2f, average=%.2f, max=%.2f", count, sum, min, avg, max);

	}

}
