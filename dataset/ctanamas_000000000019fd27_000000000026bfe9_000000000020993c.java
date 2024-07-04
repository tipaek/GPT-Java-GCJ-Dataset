import java.util.Scanner;

public class Solution {

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
	    
	    int numCases = sc.nextInt();
	   
	    String out = "";
	   
	 
	    

	    for (int c = 0; c < numCases; c++)
	    { 
	    	
	    	 int size = sc.nextInt();
	 	    
	 	    int[][] cases = new int[size][size];
	 	    
	 	   
	 	    	 for (int d = 0; d < size; d++)
	 	 	    {
	 	    		 for (int e = 0; e < size; e++)
	 	 	 	    {
	 	 	 	    
	 	 	    
	 	    			 	cases[d][e] = sc.nextInt();
	 	 	 	    }
	 	 	    }
	 	    
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
		    				 trace += cases[d][e];
		    			 }
		    			 
		    			 colExist[e][cases[d][e] - 1] = true;
		    			 
		    			 if (rowsExist[cases[d][e] - 1] == true)
		    			 {
		    				 rowGood = false;
		    			 }
		    			 else
		    			 {
		    				 rowsExist[cases[d][e] - 1] = true;
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
	    	 
	    	 	 out += "Case #" + (c + 1) + ": " + trace + " " + rowsRep + " " + colRep + "\n";

	    }
	    	
	    System.out.print(out);
	}
}
