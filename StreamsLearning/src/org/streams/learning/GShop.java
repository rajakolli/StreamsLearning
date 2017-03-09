package org.streams.learning;

import java.util.List;

public class GShop {


	/*public double getAvgPriceByType(List<String[]> data, String type) {
		// TODO complete this method
		
		return 0;
	}*/
	
	public double getAvgPriceByType (List<List<String>> values, String dataType) {
		//List<List> returnList = new ArrayList();
		double total = 0.0;
		int totalCount = 0;
		//double average = 0.0;
		
		/*
		List<Double> dblList = Arrays.asList(1.1,2.1,2.2,3.1,1.5,5.3);
	    Double average = dblList.stream().mapToDouble(val -> val).average().getAsDouble();
	    
	    
	    System.out.println("average of test is : " +average);
	    */
		
		if (values!=null && values.size()!=0) {
			for (List l : values) {
				if (dataType == "") {
					try {
						totalCount ++;
						total += Double.parseDouble((String)l.get(l.size()-1));
					} catch (Exception e ) {
						totalCount --;
					} 
				}
				else if (l.contains(dataType)) {
					//System.out.println(l.get(l.size()-1));
					//double d = Double.parseDouble((String)l.get(l.size()-1));
					total += Double.parseDouble((String)l.get(l.size()-1));
					//returnList.add(l);
					totalCount ++;
				}
				
				
			}
		}
		if(total > 0.0 && totalCount >0) {
			System.out.println("TotalCount " + totalCount);
			System.out.println("Final Total " + total/totalCount);
			return total/totalCount;
		} else {
			return 0;
		}
		
		
		/*for (List list: returnList ) {
			System.out.println("l is" + list);
			for (String s : list) {
				System.out.println("String s " + s);
			}
		}*/
	}

}
