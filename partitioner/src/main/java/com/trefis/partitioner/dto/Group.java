package com.trefis.partitioner.dto;

import java.util.List;

/**
 * Simple POJO for transferring data over the wire to JSON
 *
 */
public interface Group {
	
	/**
	 * The unique identifier of the group
	 * @return
	 */
	public int getId();
	public void setId(int id);
	
	/**
	 * The values that are contained inside the group
	 * @return
	 */
	public List<Double> getValues();
	public void setValues(List<Double> values);
}
