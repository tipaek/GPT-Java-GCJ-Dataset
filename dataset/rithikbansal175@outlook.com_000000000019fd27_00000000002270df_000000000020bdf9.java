import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        
        String cameron = "C";
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            Pair[] listA = new Pair[n];
            for(int j = 0; j < n; j++ ) {
                listA[j] = new Pair(in.nextInt(), in.nextInt());
            }
            
            System.out.println("Case #" + i + ": " + returnStatus(listA, n,repeatChar("C",n)));
        }
    }
    
    private static String repeatChar(String charVal, int count) {
        StringBuilder result = new StringBuilder();
        
        for(int i = 0; i < count; i++)
        {
            result.append(charVal);
        }
        
        return result.toString();
    }
    
    private static String returnStatus(Pair[] listA, int count, String workDistribution) {
	
	    ArrayList<Pair[]> firstCall = checkNonOverlappin(listA);
	    ArrayList<Pair[]> secondCall = new ArrayList<Pair[]>();
	    
	    Pair[] temp = firstCall.get(1);

	    if( checkIfSecondArrayIsNotEmpty(firstCall.get(1)) )  
		    secondCall = checkNonOverlappin(firstCall.get(1));
	    else
	    	return workDistribution;
	
    	if( checkIfSecondArrayIsNotEmpty(secondCall.get(1)) ) {
    		return "IMPOSSIBLE";
    	}
    	
    	return determineWorkDistribution(listA, Arrays.asList(firstCall.get(0)) );
    }

    private static String determineWorkDistribution(Pair[] listA, List<Pair> cameron ){
	    StringBuilder result = new StringBuilder();
	
	    for(Pair pair: listA) {
		    if ( cameron.contains(pair) ) 
		    	result.append("C");
		    else
			    result.append("J");
	    }
	
	    return result.toString();
    }

    private static boolean checkIfSecondArrayIsNotEmpty(Pair[] twoList) {	
	    return twoList[0] != null;
    }


    private static ArrayList<Pair[]> checkNonOverlappin(Pair[] listA) {
	    Pair[] nonOverlapping = new Pair[listA.length];
	    Pair[] remaining = new Pair[listA.length];
	    
    	int[] occupiedIndices = new int[24*60 + 1];

        int i =0, j =0;

    	for(Pair pair : listA) {
    	    if(pair == null)
    	        break;
    	        
	    	if( checkIfNonOverlapping(occupiedIndices, pair) ) {
		    	occupiedIndices = occupyInterval(occupiedIndices, pair);
			    nonOverlapping[i++] = pair;
		    } else {
			    remaining[j++] = pair;
		    }
	    }
	
    	ArrayList<Pair[]> result = new ArrayList<>();
    	result.add(nonOverlapping);
    	result.add(remaining);
    	return result;
    }

    private static boolean checkIfNonOverlapping(int[] occupiedIndices, Pair pair) {
    	for( int i = pair.getStart(); i < pair.getEnd(); i++) {
    		if ( occupiedIndices[i] == 1 )
    			return false;
    	}
	
    	return true;
    }

    private static int[] occupyInterval(int[] occupiedIndices, Pair pair) {
        
    	for(int i = pair.getStart(); i < pair.getEnd(); i++ ) {
    		occupiedIndices[i] = 1;
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
	    
	    public String toString(){
	        return this.start + "" + this.end;
	    }

    }
}