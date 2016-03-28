package com.trefis.partitioner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Partitions the data to ensure that only one value will be in a group by itself.
 * Even though this not an effective algorithm it can be used to benchmark other algos
 *
 */
public class OneToOneDoublePartioner extends AbstractDoublePartitioner {

	/**
	 * Takes a list of values and divides them into groups. The resulting groups are such that the 
	 * sum of the values in the subset are less than a provided maxSum.
	 * @param values a list of doubles that need to be partitioned
	 * @param maxSum each group must not exceed this sum when the individual values are added
	 * @return A list that contains many groupings of values that are less than the provided maxSum
	 * @throws IllegalArgumentExpection if the maxSum is less than or equal to zero
	 * @throws NullPointerException if values contain a null value
	 * @throws NullPointerException if maxPartitionSize is null
	 */
	@Override
	public Map<Integer, List<Double>> partition(List<Double> values, Double maxSum) {
		
		if(values == null)	//defensive null pointer check
			values = new ArrayList<>();
		
		if(maxSum == null)
			throw new NullPointerException("Max sum cannot be null");
		
		if(maxSum <= 0)	//check for invalid sum
			throw new IllegalArgumentException("Max total [" + maxSum + "] cannot be less than or equal to zero");
			
		Map<Integer, List<Double>> groups = new HashMap<>();
		
		for(int i = 0; i < values.size(); i++)
		{
			Double value = values.get(i);
			if(value == null)
				throw new NullPointerException("Values cannot contain null values");
			
			if(value > maxSum)
				throw new IllegalArgumentException("Value [" + value + "] cannot be partitioned as it is greater than max total sum [" + maxSum + "]");
			
			if(value < 0)
				throw new IllegalArgumentException("Value [" + value + "] cannot be less than or equal to zero");
			
			List<Double> group = new ArrayList<>();
			group.add(value);
			groups.put(i, group);
		}
		
		return groups;
	}

}
