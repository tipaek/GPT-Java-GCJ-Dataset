import java.util.*;

import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int cc = 1; cc <= t; ++cc) {
    	int C = in.nextInt();
    	int D = in.nextInt();
    	TreeMap<Integer,HashSet<Integer>> order_node = new TreeMap<>();
    	for(int i=1;i<C;i++)
    	{
    		int orderval = -in.nextInt();
    		if(!order_node.containsKey(orderval))
    		{
    			order_node.put(orderval, new HashSet<>());
    		}
    		order_node.get(orderval).add(i);
    	}
    	HashMap<intPair,Integer> linkName= new HashMap<>();
    	HashMap<Integer,TreeSet<Integer>> connectionsForNode = new HashMap<>();
    	HashMap<Integer,Integer> linkValue = new HashMap<>();
    	for(int j=0;j<D;j++)
    	{
    		int n1 = in.nextInt();
    		int n2 = in.nextInt();
    		linkName.put(new intPair(n1-1,n2-1), j);
    		linkName.put(new intPair(n2-1,n1-1), j);
    		addLink(connectionsForNode,n1-1,n2-1);
    	}
    	TreeSet<Integer> updatedNode =  new TreeSet<>();
    	updatedNode.add(0);
    	HashMap<Integer,Integer> node_triggerTime = new HashMap<Integer,Integer>();
    	node_triggerTime.put(0,0);
    	int longestTriggerTime = 0;
    	for(Map.Entry<Integer, HashSet<Integer>> pair : order_node.entrySet())
    	{
    		HashSet<Integer> nodesToAdd = pair.getValue();
    		int timeToTarget =0;
    		for(Integer nodeToAdd : nodesToAdd)
    		{
    			HashSet<Integer> triggeredReachableNodes = new HashSet<Integer>(updatedNode);
    			triggeredReachableNodes.retainAll(connectionsForNode.get(nodeToAdd));
    			int timeUpstream = node_triggerTime.get(triggeredReachableNodes.iterator().next());
    			int candidateTime = Math.max(longestTriggerTime+1, timeUpstream+1);
    			timeToTarget = Math.max(timeToTarget, candidateTime);
    		}
    		if (timeToTarget==0)
    				throw new IllegalStateException();
    		for(Integer nodeToAdd : nodesToAdd)
    		{
    			HashSet<Integer> triggeredReachableNodes = new HashSet<Integer>(updatedNode);
    			triggeredReachableNodes.retainAll(connectionsForNode.get(nodeToAdd));
    			int nodeFrom = triggeredReachableNodes.iterator().next();
    			int timeUpstream = node_triggerTime.get(nodeFrom);
    			linkValue.put(linkName.get(new intPair(nodeToAdd,nodeFrom)), timeToTarget-timeUpstream);
    			node_triggerTime.put(nodeToAdd, timeToTarget);
    			updatedNode.add(nodeToAdd);
    		}
    		longestTriggerTime = timeToTarget;
    	}
        System.out.print("Case #"+cc+":");

    	for(int i=0;i<D;i++)
    	{
    		int valToPrint = longestTriggerTime+1;
    		if(linkValue.containsKey(i))
    		{
    			valToPrint = linkValue.get(i);
    		}
    		System.out.print(" "+valToPrint);
    	}
    	
        System.out.println();
        
        
      }
    }
  public static void addLink(HashMap<Integer,TreeSet<Integer>> connectionsForNode,int n1,int n2)
  {
	  if(!connectionsForNode.containsKey(n1))
	  {
		  connectionsForNode.put(n1, new TreeSet<>());
	  }
	  if(!connectionsForNode.containsKey(n2))
	  {
		  connectionsForNode.put(n2, new TreeSet<>());
	  }  
	  connectionsForNode.get(n1).add(n2);
	  connectionsForNode.get(n2).add(n1);
  }
  
  public static class intPair
  {
	  public int a;
	  public int b;
	  public intPair(int a,int b)
	  {
		  this.a = a;
		  this.b = b;
	  }
	    public boolean equals(Object o) {
	        if (o instanceof intPair) {
	        	intPair p = (intPair)o;
	            return p.a == a && p.b == b;
	        }
	        return false;
	    }
	    public int hashCode() {
	        return new Integer(a).hashCode() * 31 + new Integer(b).hashCode();
	    }
  }
}
