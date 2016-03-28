package com.trefis.partitioner;

import java.util.List;
import java.util.Map;

/**
 * Partitioner that partitions things based on type and by criteria
 *
 * @param <T> The type of values you want to accept to be portioned
 * @param <C> the criteria that is used for partitioning
 */
public interface Partitioner<T, C> {

	/**
	 * Divide a values into parts such that the partition criteria is met
	 * @param values the list of values that need to be partitioned
	 * @param partitionCriteria using the partition criteria break values so that the partition criteria is satisfied
	 * @return a list of groups of partitioned values
	 */
	public Map<Integer, List<T>> partition(List<T> values, C partitionCriteria);
}
