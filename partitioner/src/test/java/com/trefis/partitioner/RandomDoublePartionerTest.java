package com.trefis.partitioner;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * Tests a the randomness of the random partitioner test
 *
 */
public class RandomDoublePartionerTest {

	/**
	 * Run the partition a few times and see if the numbers match up
	 */
	@Test
	public void testPartition() {
		RandomDoublePartioner p = new RandomDoublePartioner();
		List<Double> values = new ArrayList<>();
		values.add(18.0);
		values.add(17.0);
		values.add(20.0);
		values.add(19.0);
		values.add(14.0);
		values.add(20.0);
		values.add(2.0);
		values.add(12.0);
		values.add(1.0);
		values.add(1.0);
		values.add(1.0);
		values.add(1.0);
		values.add(1.0);
		values.add(1.0);
		values.add(3.0);
		values.add(4.0);
		values.add(3.0);
		values.add(3.0);
		values.add(3.0);
		values.add(5.0);
		values.add(5.0);
		values.add(5.0);
		values.add(6.0);
		values.add(1.0);
		values.add(2.0);
		values.add(19.0);
		values.add(2.0);
		values.add(20.0);
		values.add(13.0);
		values.add(2.0);
		values.add(2.0);
		values.add(14.0);
		values.add(3.0);
		values.add(3.0);
		values.add(7.0);
		values.add(18.0);
		values.add(9.0);
		values.add(5.0);
		values.add(15.0);
		values.add(7.0);
		values.add(7.0);
		values.add(18.0);
		
		
		int run1 = p.partition(values, 20.0).size();
		int run2 = p.partition(values, 20.0).size();
		int run3 = p.partition(values, 20.0).size();
		int run4 = p.partition(values, 20.0).size();
		int run5 = p.partition(values, 20.0).size();
		
		
		assertFalse(run1 == run2 && run2 == run3 && run3 == run4 && run4 == run5);
	}

}
