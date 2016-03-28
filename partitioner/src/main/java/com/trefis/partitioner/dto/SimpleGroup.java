package com.trefis.partitioner.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * This is simple basic POJO that makes marshaling easier when translating to JSON
 *
 */
@XmlRootElement
public class SimpleGroup implements Group, Serializable {

	private static final long serialVersionUID = 1804182628932606372L;
	
	private int id;
	private List<Double> values;
	
	public SimpleGroup()
	{
		id = -1;
		values = new ArrayList<>();
	}
	
	public SimpleGroup(int id)
	{
		this();
		this.id = id;
	}
	
	@Override
	public List<Double> getValues() {
		return values;
	}

	@Override
	public void setValues(List<Double> values) {
		this.values = values;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SimpleGroup other = (SimpleGroup) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		final int maxLen = 10;
		return "SimpleGroup [id=" + id + ", values="
				+ (values != null ? values.subList(0, Math.min(values.size(), maxLen)) : null) + "]";
	}
	
	
}
