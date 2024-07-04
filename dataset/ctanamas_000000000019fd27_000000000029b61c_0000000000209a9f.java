import java.util.Scanner;
public class Solution {

	public static void main(String[] args)
	{
        Scanner sc = new Scanner(System.in);
	    
	    int numCases = sc.nextInt();
	   
	    String out = "";
	    

	    for (int c = 0; c < numCases; c++)
	    { 
	    	
	    	String unNest = sc.next();
	  
	    	int unnestLen = unNest.length();
	    	String temp = unNest + "0"; 
	    	
	    	String nested = unNest; // with the paran
	    	
	    	int[] indexList = new int[unnestLen + 1]; // the indexes of each num in Nested
	    	for (int x = 0; x < unnestLen + 1; x++)
	    	{
	    		indexList[x] = x;
	    		
	    	}
	    	
	    	while(Long.parseLong(temp) != 0)
	    	{
	    		// look for the longest non-zero chain, then nest that
	    		// find start 
	    		// find end
	    		// nest
	    		// adjust indexList
	    		int startInd = 0; // str starts at ind (of temp) including index startInd
	    		int endInd = unnestLen - 1; // ends at up to but not including?
	    		
	    		boolean isFirstNonZ = true;
	    		for (int r = 0; r < unnestLen +1; r++)
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
	    		
	    		String nestTemp = "";
	    		
    		    nested = nested.substring(0, 0) + "(" +  nested.substring(0, 1) + ")" + nested.substring(1);
//    		    nested = nested.substring(0, indexList[startInd]) + "(" +  nested.substring(indexList[startInd], indexList[endInd]) + ")" + nested.substring(indexList[endInd]);
    		/*
    		    if (!(indexList[startInd] == 0))
    		    {
    		    	nestTemp += nested.substring(0, indexList[startInd]);
    		    }
		    	nestTemp += "(" +  nested.substring(indexList[startInd], indexList[endInd]) + ")";
		    	
		    	if (!(indexList[startInd] == nested.length() - 1))
		    	{
		    		nestTemp += nested.substring(indexList[endInd]);
		    	}
    		    nested = nestTemp;
    		    */
    		   // System.out.print("\n\n" + nested + "\n\n");

	    		// update indexes
	    		for (int r = startInd; r < unnestLen + 1; r++) 
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

	    		    temp = temp.substring(0, r) + "" + (Character.getNumericValue(temp.charAt(r)) - 1) + temp.substring(r + 1);
	    		}
	    		
	    			
	    	}
	    	
	    	out += "Case #" + (c + 1) + ": " + nested + "\n";

	    }
	    	
	    //System.out.print(Integer.parseInt("3"));
	    System.out.print(out);

	}

}
