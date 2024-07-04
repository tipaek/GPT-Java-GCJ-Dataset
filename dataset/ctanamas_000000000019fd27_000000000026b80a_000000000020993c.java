import java.util.Scanner;

public class Solution {

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
	    
	    int numCases = sc.nextInt();
	    int size = sc.nextInt();
	    
	    int[][][] cases = new int[numCases][size][size];
	    
	    for (int c = 0; c < numCases; c++)
	    {
	    	 for (int d = 0; d < size; d++)
	 	    {
	    		 for (int e = 0; e < size; e++)
	 	 	    {
	 	 	    
	 	    
	    			 	cases[c][d][e] = sc.nextInt();
	 	 	    }
	 	    }
	    }
	   
	 
	    

	    for (int c = 0; c < numCases; c++)
	    { 
	    int trace = 0;
	    int rowsRep =0;
	    int colRep = 0;
	    boolean[] colGood = new boolean[size];
		 boolean[][] colExist = new boolean[size][size];


	    	 for (int d = 0; d < size; d++)
		 	    {
	    		 boolean[] rowsExist = new boolean[size];

	    		 boolean rowGood = true;
	    		 
		    		for (int e = 0; e < size; e++)
		 	 	    {
		    			 if (d == e)
		    			 {
		    				 trace += cases[c][d][e];
		    			 }
		    			 
		    			 colExist[e][cases[c][d][e] - 1] = true;
		    			 
		    			 if (rowsExist[cases[c][d][e] - 1] == true)
		    			 {
		    				 rowGood = false;
		    			 }
		    			 else
		    			 {
		    				 rowsExist[cases[c][d][e] - 1] = true;
		    			 }
		    			 
		 	 	    }
		    		 
		    		 if(!rowGood)
			    		{
			    			rowsRep++;
			    		}
		   
		    		 
		 	    }
	 		 for(int i = 0; i < size; i++)
    		 {
    			 colGood[i] = true;
    			for(int j = 0; j < size; j++)
    			{
    				if (colExist[i][j] == false)
    				{
    					colGood[i] = false;
    				}
    			}
    			
    			if(colGood[i] == false)
    			{
    				colRep++;
    			}
    		 }
	    	 
	    	 	 System.out.print("Case #" + (c + 1) + ": " + trace + " " + rowsRep + " " + colRep + "\n");

	    }
	    	
	}
}
