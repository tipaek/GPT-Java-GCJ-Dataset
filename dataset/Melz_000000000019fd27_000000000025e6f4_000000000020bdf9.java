import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
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
		
		for(int i = 0; i< t; i++)
		{	
			int n = scanner.nextInt();
			List<Integer> activityList = new ArrayList<>();
			List<Integer> sortedActivityList = new ArrayList<>();
			Map<Integer,Integer> activityTimeMap = new HashMap<>();
			
			for(int j = 0; j<n;j++)
			{
				int startTime = scanner.nextInt();
				int endTime = scanner.nextInt();
				activityList.add(startTime);
				sortedActivityList.add(startTime);
				activityTimeMap.put(startTime,(endTime-startTime));
			}
			
			Collections.sort(sortedActivityList);
			
			int index = 0;
			Set<Integer> CSet = new HashSet<>();
			Set<Integer> JSet = new HashSet<>();
			boolean possible = true;
			for(int startTime : sortedActivityList)
			{
				for(int nextStartTime : sortedActivityList.subList(index+1, sortedActivityList.size()))
				{
					if((nextStartTime - startTime) < activityTimeMap.get(startTime))
					{
						if(CSet.contains(startTime))
						{
							if(!CSet.contains(nextStartTime))
								JSet.add(nextStartTime);
							else
							{
								possible = false;
								break;
							}
						}
						
						else if(JSet.contains(startTime))
						{
							if(!JSet.contains(nextStartTime))
								CSet.add(nextStartTime);
							else
							{
								possible = false;
								break;
							}
						}
						else
						{
							if(CSet.contains(nextStartTime))
								JSet.add(startTime);
							else if(JSet.contains(nextStartTime))
								CSet.add(startTime);
							else
							{
								CSet.add(startTime);
								JSet.add(nextStartTime);
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
				for(int activity : activityList)
				{
					if(JSet.contains(activity))
					{
						activityString = activityString+"J";
						JSet.remove(activity);
					}
					else
					{
						activityString = activityString+"C";
						CSet.remove(activity);
					}
				}
			}
			
			System.out.println("Case #"+(i+1)+": "+activityString);
		}
		scanner.close();
	}

}
