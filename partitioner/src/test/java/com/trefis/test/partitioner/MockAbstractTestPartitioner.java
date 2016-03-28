package com.trefis.test.partitioner;

import java.util.List;
import java.util.Map;

import com.trefis.partitioner.AbstractDoublePartitioner;

/**
 * Just a mock so that we can test the non abstract classes
 *
 */
public class MockAbstractTestPartitioner extends AbstractDoublePartitioner {

	/**
	 * Does nothing. This is only for testing purposes
	 */
	@Override
	public Map<Integer, List<Double>> partition(List<Double> values, Double partitionCriteria) {
		return null;
	}

}
