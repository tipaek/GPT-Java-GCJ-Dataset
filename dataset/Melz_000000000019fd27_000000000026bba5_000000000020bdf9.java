import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		
		int t = scanner.nextInt();
		Solution solObj = new Solution();
		for(int i = 0; i< t; i++)
		{	
			int n = scanner.nextInt();
			List<Activity> activityList = new ArrayList<>();
			List<Activity> sortedActivityList = new ArrayList<>();
			Map<Activity,Integer> activityTimeMap = new HashMap<>();
			
			for(int j = 0; j<n;j++)
			{
				Activity activity = solObj.new Activity();
				activity.startTime = scanner.nextInt();
				activity.endTime = scanner.nextInt();
				activityList.add(activity);
				sortedActivityList.add(activity);
				activityTimeMap.put(activity,(activity.endTime-activity.startTime));
			}
			
			Collections.sort(sortedActivityList,solObj.new ActivityComparator());
			
			int index = 0;
			Set<Activity> CSet = new HashSet<>();
			Set<Activity> JSet = new HashSet<>();
			boolean possible = true;
			for(Activity activity : sortedActivityList)
			{
				for(Activity nextActivity : sortedActivityList.subList(index+1, sortedActivityList.size()))
				{
					if((nextActivity.startTime - activity.startTime) < activityTimeMap.get(activity))
					{
						if(CSet.contains(activity))
						{
							if(!CSet.contains(nextActivity))
								JSet.add(nextActivity);
							else 
							{
								possible = false;
								break;
							}
						}
						
						else if(JSet.contains(activity))
						{
							if(!JSet.contains(nextActivity))
								CSet.add(nextActivity);
							else
							{
								possible = false;
								break;
							}
						}
						else
						{
							if(CSet.contains(nextActivity))
								JSet.add(activity);
							else if(JSet.contains(nextActivity))
								CSet.add(activity);
							else
							{
								CSet.add(activity);
								JSet.add(nextActivity);
							}	
						}
					}
				}
				
				if(possible == false)
					break;
				index++;
			}
			
			String activityString="";
			if(possible == false)
				activityString = "IMPOSSIBLE";
			else
			{
				for(Activity activity : activityList)
				{
					if(JSet.contains(activity))
					{
						activityString = activityString+"J";
						
					}
					else
					{
						activityString = activityString+"C";
						
					}
				}
			}
			
			System.out.println("Case #"+(i+1)+": "+activityString);
		}
		scanner.close();
	}
	
	class Activity{
		
		int startTime;
		int endTime;
		
	}
	
	class ActivityComparator implements Comparator<Activity> {
	    @Override
	    public int compare(Activity o1, Activity o2) {
	       if(o1.startTime < o2.startTime)
	    	   return -1;
	       else 
	    	   return 1;
	    }
	}

}