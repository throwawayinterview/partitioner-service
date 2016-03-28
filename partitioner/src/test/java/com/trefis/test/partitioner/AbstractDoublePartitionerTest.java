package com.trefis.test.partitioner;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

/**
 * Test cases to ensure that modifications don't break anything
 *
 */
@SuppressWarnings("deprecation")
public class AbstractDoublePartitionerTest {

	/**
	 * Tests for Null pointer exceptions
	 */
	@Test(expected=NullPointerException.class)
	public void testCalculateSumNPE() {
		
		List<Double> data = new ArrayList<>();
		data.add(null);
		
		MockAbstractTestPartitioner m = new MockAbstractTestPartitioner();
		m.calculateSum(data);
	}
	
	/**
	 * Tests for empty values
	 */
	@Test
	public void testCalculateSumEmpty() {
		
		List<Double> data = new ArrayList<>();
		
		MockAbstractTestPartitioner m = new MockAbstractTestPartitioner();
		assertEquals(0.0, m.calculateSum(data), 0.1);
	}
	
	/**
	 * Tests for Sum success
	 */
	@Test
	public void testCalculateSumSuccess() {
		
		List<Double> data = new ArrayList<>();
		data.add(10.8);
		data.add(1.2);
		MockAbstractTestPartitioner m = new MockAbstractTestPartitioner();
		assertEquals(12.0, m.calculateSum(data), 0.1);
	}
	
	/**
	 * Test for sum failure
	 */
	@Test
	public void testCalculateSumFailure() {
		
		List<Double> data = new ArrayList<>();
		data.add(10.8);
		data.add(1.2);
		MockAbstractTestPartitioner m = new MockAbstractTestPartitioner();
		assertNotEquals(14.0, m.calculateSum(data), 0.1);
	}

	/**
	 * Tests if you can add value
	 */
	@Test
	public void testCanAddValueTrue() {
		List<Double> data = new ArrayList<>();
		data.add(10.8);
		data.add(1.2);
		MockAbstractTestPartitioner m = new MockAbstractTestPartitioner();
		assertTrue(m.canAddValue(data, 100, 10.0));
	}
	
	/**
	 * Tests for failures
	 */
	@Test
	public void testCanAddValueFalse() {
		List<Double> data = new ArrayList<>();
		data.add(10.8);
		data.add(1.2);
		MockAbstractTestPartitioner m = new MockAbstractTestPartitioner();
		assertFalse(m.canAddValue(data, 10, 10.0));
	}

	/**
	 * Test for available group
	 */
	@Test
	public void testGetAvaialableGroup() {
		
		List<Double> data = new ArrayList<>();
		data.add(10.8);
		
		Map<Integer, List<Double>> groups = new HashMap<>();
		groups.put(0, data);
	
		MockAbstractTestPartitioner m = new MockAbstractTestPartitioner();
		assertTrue(data == m.getAvaialableGroup(groups, 5, 100));
	}

}
