import java.util.Scanner;

public class Solution {

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
	    
	    int numCases = sc.nextInt();
	    
	    int[] cases = new int[numCases];
		   
	    String out = "";
	    

	    for (int c = 0; c < numCases; c++)
	    { 
	    	
	    	String unNest = sc.next();
	    	
	    	int unnestLen = unNest.length();
	    	String temp = unNest; // just the nums but correct
	    	
	    	String nested = unNest; // with the paran
	    	
	    	int[] indexList = new int[unnestLen]; // the indexes of each num in Nested
	    	
	    	while(Integer.parseInt(temp) != 0)
	    	{
	    		// look for the longest non-zero chain, then nest that
	    		// find start 
	    		// find end
	    		// nest
	    		// adjust indexList
	    		int startInd = 0; // str starts at ind (of temp) including index startInd
	    		int endInd = 1; // ends at up to but not including?
	    		
	    		boolean isFirstNonZ = true;
	    		for (int r = 0; r < unnestLen; r++)
	    		{
	    			if (!(temp.charAt(r) == '0')) // because of the above while, this will always happen
	    			{
	    				if (isFirstNonZ == true)
	    				{
	    					startInd = r;
	    					isFirstNonZ = false;
	    				}
	    			}
	    			else // you found a 0...
	    			{
	    				if (!isFirstNonZ)
	    				{
	    					endInd = r;
	    					break;
	    				}
	    			}	
	    		}
	    		
	    		// change nest to be nested
    		    nested = nested.substring(0, startInd) + "(" +  nested.substring(startInd, endInd) + ")" + nested.substring(endInd + nested.length() + 1);

	    		
	    		// update indexes
	    		for (int r = startInd; r < unnestLen; r++) 
    		    {
    		    	if (r < endInd)
    		    	{
    		    		indexList[r]++;
    		    	}
    		    	else // >= end
    		    	{
    		    		indexList[r] += 2;
    		    	}
    		    }
	    		
	    		// update temp sub one
	    		for (int r = startInd, n = endInd; r < n; r++) // even solves the up to not including! wow
	    		{
	    		    temp = temp.substring(0, r) + (Character.valueOf(temp.charAt(r)) - 1) + temp.substring(r + 1);
	    		}
	    			
	    			
	    	}
	    	
	    	out += "Case #" + (c + 1) + ": " + nested + "\n";

	    }
	    	
	    System.out.print(out);
	}

}
