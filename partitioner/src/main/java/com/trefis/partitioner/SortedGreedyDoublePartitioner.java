package com.trefis.partitioner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * This is a partitioner that has been implemented with a greedy algorithm but sorts the data before it does the partitioning
 * The default sort is ascending. It looks for available space first
 * before creating another group. Though this may not be as optimal but it Big O notation is O(n) as it only loops through
 * the items once.
 *
 */
public class SortedGreedyDoublePartitioner extends GreedyDoublePartitioner {
	
	private boolean ascending;
	
	/**
	 * Creates an ascending sorted partitioner
	 */
	public SortedGreedyDoublePartitioner()
	{
		super();
		ascending = true;
	}
	
	/**
	 * Creates a partitioner with the ability to set the sort order first
	 * @param ascending true if the sort will be ascending. false if it will be descending
	 */
	public SortedGreedyDoublePartitioner(boolean ascending)
	{
		this();
		this.ascending = ascending;
	}

	/**
	 * Does a default ascending sort first before actually doing the partition
	 * {@inheritDoc}
	 */
	@Override
	public Map<Integer, List<Double>> partition(List<Double> values, Double maxSum) {
		
		return partition(values, maxSum, ascending);
	}
	
	/**
	 * Allows the ability to sort by a particular order before using the greedy algo
	 * @see SortedGreedyDoublePartitioner#partition(List, Double)
	 * @param values
	 * @param maxSum
	 * @param ascending
	 * @return
	 */
	protected Map<Integer, List<Double>> partition(List<Double> values, Double maxSum, boolean ascending) {
		
		if(values == null)	//defensive null pointer check
			values = new ArrayList<>();
		
		Collections.sort(values);	//sort it first
		
		if(!ascending)
			Collections.reverse(values);	//reverse the order
		
		return super.partition(values, maxSum);
	}

	/**
	 * Get the sort order that is currently set
	 * @return
	 */
	public boolean isAscending() {
		return ascending;
	}

	/**
	 * 
	 * @param ascending set true if you want to set at as ascending. false to be descending
	 */
	public void setAscending(boolean ascending) {
		this.ascending = ascending;
	}

	@Override
	public String toString() {
		return "SortedGreedyDoublePartitioner [ascending=" + ascending + "]";
	}

}
