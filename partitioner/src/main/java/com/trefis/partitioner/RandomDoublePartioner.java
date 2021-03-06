package com.trefis.partitioner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * This is a partitioner that has been implemented that randomly tries assign the values. It looks for available space first
 * before creating another group. Though this may not be as optimal but it Big O notation is O(n) as it only loops through
 * the items once.
 *
 */
public class RandomDoublePartioner extends AbstractDoublePartitioner {

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
			throw new IllegalArgumentException("Max sum [" + maxSum + "] cannot be less than or equal to zero");
			
		Map<Integer, List<Double>> groups = new HashMap<>();
		
		for(int i = 0; i < values.size(); i++)
		{
			Double value = values.get(i);
			if(value == null)
				throw new NullPointerException("Values cannot contain null values");
			
			if(value > maxSum)
				throw new IllegalArgumentException("Value [" + value + "] cannot be partitioned as it is greater than max sum  [" + maxSum + "]");
			
			if(value < 0)
				throw new IllegalArgumentException("Value [" + value + "] cannot be less than or equal to zero");
			
			List<Double> group = null;
			
			//randomly get a group if there already are groups
			if(groups.size() > 0)
				group = groups.get(new Random().nextInt(groups.size()));
			
			//If group can be used then add it
			if(group != null && canAddValue(group, maxSum, value))
				group.add(value);
			else
			{	//if not then create a new group and add it
				group = new ArrayList<>();
				group.add(value);
				groups.put(groups.size(), group);
			}
		}
		
		return groups;
	}

}
