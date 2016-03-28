package com.trefis.partitioner;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * Tests to ensure that the partitioner works as expected
 *
 */
public class OneToOneDoublePartionerTest {

	@Test
	public void testPartition() {
		OneToOneDoublePartioner p = new OneToOneDoublePartioner();
		List<Double> values = new ArrayList<>();
		values.add(1.0);
		values.add(1.0);
		values.add(1.0);
		values.add(1.0);
		values.add(1.0);
		assertEquals(5, p.partition(values, 5.0).size());
	}

}
