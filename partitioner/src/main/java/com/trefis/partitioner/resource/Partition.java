package com.trefis.partitioner.resource;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.trefis.partitioner.GreedyDoublePartitioner;
import com.trefis.partitioner.OneToOneDoublePartioner;
import com.trefis.partitioner.Partitioner;
import com.trefis.partitioner.RandomDoublePartioner;
import com.trefis.partitioner.SortedGreedyDoublePartitioner;
import com.trefis.partitioner.dto.SimpleGroup;

/**
 * Rest service that allows for a list of numbers to be partitioned into smaller subsets based on a max sum.
 * This is a generic service that currently support multiple partitioning algorithms
 * 
 * Root resource (exposed at "partition" path)
 */
@Path("partition")
@Produces(MediaType.APPLICATION_JSON)
public class Partition {
	
	/*
	 * Instance members that does the different partitioning
	 */
	private Partitioner<Double, Double> oneToOnePartitioner = new OneToOneDoublePartioner(); 
	private Partitioner<Double, Double> greedyPartitioner = new GreedyDoublePartitioner(); 
	private Partitioner<Double, Double> randomPartitioner = new RandomDoublePartioner();
	private Partitioner<Double, Double> sortedPartitioner = new SortedGreedyDoublePartitioner();
	private Partitioner<Double, Double> reverseSortedPartitioner = new SortedGreedyDoublePartitioner(false);
	
	/**
	 * Converts a comma separated list of numbers into a list of doubles.
	 * @param concatinatedValue the comma separated value
	 * @return a list of Doubles in the order a which it was provided. Values that cannot be parsed will be converted into nulls
	 */
	protected List<Double> getValues(String concatinatedValue)
	{
		String[] values = concatinatedValue.split(",");
		List<Double> result = new ArrayList<>();
		
		for(String value : values)
		{
			Double d = Double.parseDouble(value);
			result.add(d);
		}
		
		return result;
	}
	
	
	/**
	 * Takes the results set of the partitions and then puts it into a nice format so that it can be converted to JSON
	 * much easier
	 * @param data the actual broken down data by groups
	 * @return a simple data transfer object for passing the data via JSON much easier
	 */
	protected List<SimpleGroup> convertToSimpleGroups(Map<Integer, List<Double>> data)
	{
		List<SimpleGroup> groups = new ArrayList<>();
		
		for(int i : data.keySet())
		{
			SimpleGroup group = new SimpleGroup(i);
			group.setValues(data.get(i));
			groups.add(group);
		}
		
		return groups;
	}
    
	/**
	 * Get request that takes a comma separated string as a list of values and then breaks them into smaller subsets based whose sum
	 * cannot be larger than the provided max sum. An optional algo can be provided to alter the partitioning algorithm. 
	 * @param values the comma separated list of doubles that will be used to determine the original data set
	 * @param maxSum this is the maximum sum that each subset must be smaller or equal to
	 * @param algo [optional] This is an optional field. You can use this to choose the partition algorithm. Available options are
	 * "oneToOne", "greedy", "random", "sortedGreedy" or "reverseSortedGreedy". The default is "greedy"
	 * @return
	 */
    @GET
    public Response partition(@HeaderParam("values") String values, @HeaderParam("maxSum") double maxSum, @HeaderParam("algo") String algo) {
        
    	//not the best logging but just doing the best for now
    	System.out.println("Request for algo [" + algo + "] with a maxSum [" + maxSum + "] using values [" + values + "]");
    	
    	if(algo == null) algo = "";
    	
    	Partitioner<Double, Double> partitioner = null;
    	
    	switch(algo)
    	{
	    	case "oneToOne": partitioner = oneToOnePartitioner; break;
	    	case "greedy": partitioner = greedyPartitioner; break;
	    	case "random": partitioner = randomPartitioner; break;
	    	case "sortedGreedy": partitioner = sortedPartitioner; break;
	    	case "reverseSortedGreedy": partitioner = reverseSortedPartitioner; break;
	    	default: partitioner = greedyPartitioner;
    	}
    	
    	try
    	{
	    	List<Double> valuesAsList = getValues(values);
	    	
	    	Map<Integer, List<Double>> result = partitioner.partition(valuesAsList, maxSum);
	    	
	    	System.out.println("Algo [" + algo + "] partitioned the request into [" + result.size() + "] parts [" + result.values() + "]");
	    	
	    	return Response.ok().entity(new GenericEntity<List<SimpleGroup>>(convertToSimpleGroups(result)){}).build();
    	}
    	catch(Exception ex)	//Generic catch for now. Can provide multiple errors later on
    	{
    		System.out.println("Something went wrong");	//not the best logging but for this it works
    		ex.printStackTrace();
    		
    		return Response.serverError().build();
    	}
        
    }
    
}
