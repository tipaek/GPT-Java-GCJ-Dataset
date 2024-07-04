import java.util.*;
import java.io.*;
public class Solution {

	public static void main(String[] args)
	{
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	    
	    int numCases = sc.nextInt();
	    
	   // int[] cases = new int[numCases];
		   
	    String out = "";
	    

	    for (int c = 0; c < numCases; c++)
	    { 
	    	String assignments = "";
	    	int activities = sc.nextInt();
	    	
	    	int[][] times = new int[activities][2];
	    	
	    	for (int i = 0; i < activities; i++)
	    	{
	    		for (int j = 0; j < 2; j++)
	    		{
	    			times[i][j] = sc.nextInt();
	    		}
	    	}
	    	
	    	boolean[] cam = new boolean[activities];
	    	
	    	boolean[] jam = new boolean[activities];
	    	for (int x = 0; x < activities; x++)
	    	{
		    	if (available(cam, times, x, activities))
		    	{
		    	//	System.out.println("Cam");
		    		cam[x] = true;
		    		assignments += "C";
		    	}
		    	else if (available(jam, times, x, activities))
		    	{
		    	//	System.out.println("Jam");

		    		jam[x] = true;
		    		assignments += "J";
		    	}
		    	else
		    	{
		    	//	System.out.println("uh oh one");

		    		assignments = "IMPOSSIBLE";
		    		break;
		    	}
		    	// if c can do it asign to her
		    	// other wise if j can do it assign to him
		    	// otherwise break and say impossible
	    	}
	    	
	    	System.out.println("Case #" + (c + 1) + ": " + assignments);
          //  out += "Case #" + (c + 1) + ": " + assignments;
	    //	if (c != numCases - 1)
	    //	{
	    //		out += "\n";
	    //	}	    
	        
	    }
	    
	    
	}  
	
	public static boolean available(boolean[] assigned, int[][] times, int indexToAssign, int numAct)
	{
		for(int i = 0; i < numAct; i++)
		{
			if (assigned[i] == true)
			{
				// start overlaps
				if(times[indexToAssign][0] < times[i][1] && times[indexToAssign][1] > times[i][1] ) // the the to assign starts before the assigned ends. and end after the other ends  equal is ok
				{
		    	//	System.out.println("it starts (during other ) before the other ends: " + i);

					return false;
				}
				// end overlaps
				if (times[indexToAssign][1] > times[i][0] && times[indexToAssign][0] < times[i][0])// or if it ends after the other starts, equal is ok
				{
		    		//System.out.println("it ends (during other ) after the other starts: " + i);

					return false;
				}
				// whole thing overlaps (deal with equal to) 
				if (times[indexToAssign][0] >= times[i][0] && times[indexToAssign][1] <= times[i][1])
				{
					return false;

				}
			}
		}
		
		return true;
	}
	

}