import java.util.*;
import java.io.*;

public class Solution 
{
	
	public static String findSolution(TreeMap<Integer, Integer> activities)
	{
		StringBuilder solution = new StringBuilder();
		
		boolean isJamieAvailable = true;
		boolean isCamAvailable = true;
		
		int jamieEndTime = -10;
		int camEndTime = -10;
		
		for (Map.Entry<Integer, Integer> activity : activities.entrySet()) {
		    int startTime = activity.getKey();
		    int endTime = activity.getValue();
		    
		    if (startTime >= jamieEndTime)
		    {
		    	jamieEndTime = -10;
		    	isJamieAvailable = true;
		    }
		    
		    if (startTime >= camEndTime)
		    {
		    	camEndTime = -10;
		    	isCamAvailable = true;
		    }
		    
		    if (isJamieAvailable) {
		    	jamieEndTime = endTime;
		    	isJamieAvailable = false;
		    	solution.append("J");
		    }
		    else if (isCamAvailable) {
		    	camEndTime = endTime;
		    	isCamAvailable = false;
		    	solution.append("C");
		    }
		    else
		    	return "IMPOSSIBLE";
		    
		}
		
		return solution.toString();
	}
	
	public static void main(String[] args) 
	{
	    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	    int numTestCase = in.nextInt(); 
	
	    for (int i = 1; i <= numTestCase; ++i) 
	    {
	    	int numActivities = in.nextInt();
	    	
	    	TreeMap<Integer, Integer> activities = new TreeMap<>();
	    	
	    	for (int k=0; k<numActivities; k++)
	    	{
	    		activities.put(in.nextInt(), in.nextInt());
	    	}
	    	
	    	
	    	String solution = Solution.findSolution(activities);
	    	System.out.println("Case #" + i + ": " + solution);
	    }
	}
}