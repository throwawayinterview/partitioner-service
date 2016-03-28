package com.trefis.partitioner.resource;

import static org.junit.Assert.*;

import java.util.List;

import javax.ws.rs.core.Response;

import org.junit.Test;

import com.trefis.partitioner.dto.SimpleGroup;

public class PartitionTest {

	@Test
	public void testPartition() {
		Partition p = new Partition();
		
		Response response = p.partition("1,2,3,4", 5, "greedy");
		Object o = response.getEntity();
		List<SimpleGroup> groups = (List<SimpleGroup>) o;
		
		assertEquals(3, groups.size());
	}

}
