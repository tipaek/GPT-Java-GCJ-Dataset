import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        ArrayList<Pair> listA =  new ArrayList<>();
        String cameron = "C";
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            for(int j = 0; j < n; j++ ) {
                listA.add(new Pair(in.nextInt(), in.nextInt()));
            }
            
            System.out.println("Case #" + i + ": " + returnStatus(listA, n,repeatChar("C",n)));
        }
    }
    
    private static String repeatChar(String charVal, int count) {
        StringBuilder result = new StringBuilder();
        
        for(int i =0; i < count; i++)
        {
            result.append(charVal);
        }
        
        return result.toString();
    }
    
    private static String returnStatus(ArrayList<Pair> listA, int count, String workDistribution) {
	
	    ArrayList<ArrayList<Pair>> firstCall = checkNonOverlappin(listA);
	    ArrayList<ArrayList<Pair>> secondCall = new ArrayList<ArrayList<Pair>>();
	
	    if( checkIfSecondArrayIsNotEmpty(firstCall) )  
		    secondCall = checkNonOverlappin(firstCall.get(1));
	    else
	    	return workDistribution;
	
    	if( checkIfSecondArrayIsNotEmpty(secondCall) ) {
    		return "IMPOSSIBLE";
    	}
    	
    	return determineWorkDistribution(listA, firstCall.get(0) );
    }

    private static String determineWorkDistribution(ArrayList<Pair> listA, List<Pair> cameron ){
	    StringBuilder result = new StringBuilder();
	
	    for(Pair pair: listA) {
		    if ( cameron.contains(pair) ) 
		    	result.append("C");
		    else
			    result.append("J");
	    }
	
	    return result.toString();
    }

    private static boolean checkIfSecondArrayIsNotEmpty(ArrayList<ArrayList<Pair>> twoList) {	
	    return twoList.get(1) != null || !twoList.get(1).isEmpty();
    }


    private static ArrayList<ArrayList<Pair>> checkNonOverlappin(ArrayList<Pair> listA) {
	    ArrayList<Pair> nonOverlapping = new ArrayList<>();
	    ArrayList<Pair> remaining	= new ArrayList<>();
	
    	ArrayList<Integer> occupiedIndices = new ArrayList<>();
	
    	for(Pair pair : listA) {
	    	if( checkIfNonOverlapping(occupiedIndices, pair) ) {
		    	occupiedIndices = occupyInterval(occupiedIndices, pair);
			    nonOverlapping.add(pair);
		    } else {
			    remaining.add(pair);
		    }
	    }
	
    	ArrayList<ArrayList<Pair>> result = new ArrayList<ArrayList<Pair>>();
    	result.add(nonOverlapping);
    	result.add(remaining);
    	return result;
    }

    private static boolean checkIfNonOverlapping(List<Integer> occupiedIndices, Pair pair) {
    	for( int i = pair.getStart(); i < pair.getEnd(); i++) {
    	    if(i >= occupiedIndices.size())
    	       return true;
    	       
    		if ( occupiedIndices.get(i) == 1 )
    			return false;
    	}
	
    	return true;
    }

    private static ArrayList<Integer> occupyInterval(ArrayList<Integer> occupiedIndices, Pair pair) {
    	for(int i = pair.getStart(); i < pair.getEnd(); i++ ) {
    	    occupiedIndices.ensureCapacity(pair.getEnd());
    		occupiedIndices.add(i, 1);
    	}
	
    	return occupiedIndices;
    }


    public static class Pair{
    	int start;
    	int end;
	
    	Pair(){
    		start = 0;
		    end = 1;
	    }
	
	    Pair(int start, int end) {
	    	this.start = start;
	    	this.end = end;
	    }
    	
	    public int getStart() {
	    	return this.start;
	    }
	
    	public int getEnd() {
    		return this.end;
    	}
	
	    @Override
	    public boolean equals(Object o) {
	        
	        if(o != this || !(o instanceof Pair))
	            return false;
	        
	    	Pair newValue = (Pair) o;
	    	
	    	return this.start == newValue.getStart() && this.end == newValue.getEnd();
	    }

    }
}