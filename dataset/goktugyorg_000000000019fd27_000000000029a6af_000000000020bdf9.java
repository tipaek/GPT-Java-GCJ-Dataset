import java.util.*;
import java.io.*;

public class Solution {
	
	static class Activity
	{
		int start;
		int end;
		int id;
		String who;
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
        		a.id = j;
        		activityList.add(a);
        		a = new Activity();
        	}
    		
        	Comparator<Activity> comparingSolutionFitness = (s1,s2) -> s1.start == s2.start ? (s1.end == s2.end ? 0 : s1.end > s2.end ? 1 :-1) : s1.start > s2.start ? 1 :-1; // artan
    		Collections.sort(activityList, comparingSolutionFitness);
        	
    		for(Activity ac : activityList)
    		{	
    			boolean doesJOverlap = doesOverlap(ac, J);
    			boolean doesCOverlap = doesOverlap(ac, C);
    			
    			if(!doesJOverlap)
    			{	
    				ac.who = "J";
    				J.add(ac);
    			}
    			else if(!doesCOverlap)
    			{	
    				ac.who = "C";
    				C.add(ac);
    			}
    			else
    			{
    				str = new StringBuilder("IMPOSSIBLE");
    				ac.who = "IMP";
    				break;
    			}
    		}
    		
    		Comparator<Activity> comparingId = (s1,s2) -> s1.id == s2.id ? 0 : s1.id > s2.id ? -1 :1; // artan
    		Collections.sort(activityList, comparingId);
    		
    		for(Activity act : activityList)
    		{
    			if(act.who == "IMP")
    			{
    				str = new StringBuilder("IMPOSSIBLE");
    				break;
    			}
    			str.append(act.who);
    		}
    			
    		
        	System.out.println("Case #" + i + ": " + str);
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
			if(newAc.end >= ac.end && newAc.start <= ac.start)
				return true;
		}
		return false;
	}

}