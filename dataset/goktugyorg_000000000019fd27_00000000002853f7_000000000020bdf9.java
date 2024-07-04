import java.util.*;
import java.io.*;

public class Solution {
	
	static class Activity
	{
		int start;
		int end;
	}
	
	public static void main(String[] args) 
	{
		
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); 
        
        for (int i = 1; i <= t; ++i) 
        {	
        	List<Activity> activityList = new ArrayList<Activity>();
        	List<Activity> J = new ArrayList<Activity>();
        	List<Activity> C = new ArrayList<Activity>();
        	StringBuilder str = new StringBuilder("");

        	Activity a = new Activity();

        	int n = in.nextInt();

        	for (int j = 0; j < n; j++) 
        	{	
        		a.start = in.nextInt();
        		a.end = in.nextInt();
        		activityList.add(a);
        		a = new Activity();
        	}
    		
    		for(Activity ac : activityList)
    		{
    			if(!doesOverlap(ac, J))
    			{
    				J.add(ac);
    				str.append("J");
    			}
    			else if(!doesOverlap(ac, C))
    			{
    				C.add(ac);
    				str.append("C");
    			}
    			else
    			{
    				str = new StringBuilder("IMPOSSIBLE");
    				break;
    			}
    		}
    		
        	System.out.println("Case #" + i + ": " + str.toString());
        }
        in.close();
	}
	
	public static boolean doesOverlap(Activity newAc, List<Activity> list) 
	{	
		for(Activity ac : list)
		{
			if(newAc.start < ac.end && newAc.start > ac.start)
				return true;
			if(newAc.end < ac.end && newAc.end > ac.start)
				return true;
			if(newAc.end == ac.end && newAc.start == ac.start)
				return true;	
		}
		return false;
	}

}