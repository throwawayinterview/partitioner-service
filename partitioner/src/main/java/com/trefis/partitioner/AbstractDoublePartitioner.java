package com.trefis.partitioner;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Using Doubles this partitioner implements many of the helper methods that are needed
 * for doing any basic partitioning on Doubles.
 * 
 */
public abstract class AbstractDoublePartitioner implements Partitioner<Double, Double> {

	/**
	 * Calculates the sum of a group of values
	 * @param group the group that you would like to calculate the sum of
	 * @return the total for the sum of the group
	 * @throws NullPointerException if the group contains a null value 
	 */
	public double calculateSum(List<Double> group)
	{
		if(group == null) return 0;
		
		double sum = 0;
		
		for(Double value : group)
		{
			if(value == null)
				throw new NullPointerException("group cannot contain null values");
			
			sum += value;
		}
		
		return sum;
	}
	
	/**
	 * Checks a particular group to see if a value can be added based on the inclusive maxSum
	 * @param group the group that you want to add a value to
	 * @param maxSum the inclusive total of the group.
	 * @param value the value that you would check to see if it can be added to the group
	 * @return true if value can be added to the group without going over the max sum
	 */
	public boolean canAddValue(List<Double> group, double maxSum, double value)
	{
		return maxSum - calculateSum(group) - value >= 0;
	}
	
	/**
	 * Goes through the available groups to see if there is space available in any of the existing groups. If no space is available then
	 * a new group is added and return.
	 * @param groups the groups that are currently available
	 * @param value the values that needs to be added
	 * @param maxSum the max sum of a particular group
	 * @return
	 */
	public List<Double> getAvaialableGroup(Map<Integer, List<Double>> groups, double value, double maxSum)
	{
		for(int i = 0; i < groups.size(); i++)
		{
			List<Double> group = groups.get(i);
			
			if(canAddValue(group, maxSum, value))
				return group;
		}
		
		//if you are here then you have not found a group. So create one and add it to the list
		List<Double> group = new ArrayList<>();
		groups.put(groups.size(), group);
		
		return group;
	}
}
