package com.trefis.partitioner;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class GreedyDoublePartionerTest {

	
	/**
	 * Expecting that it works correctly.
	 */
	@Test
	public void testPartition() {
		
		GreedyDoublePartitioner p = new GreedyDoublePartitioner();
		List<Double> values = new ArrayList<>();
		values.add(1.0);
		values.add(1.0);
		values.add(1.0);
		values.add(1.0);
		values.add(1.0);
		assertEquals(1, p.partition(values, 5.0).size());
	}

}
