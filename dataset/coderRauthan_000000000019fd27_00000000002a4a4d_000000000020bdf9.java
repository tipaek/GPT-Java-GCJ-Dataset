import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution 
{
	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		
		int testCases = scanner.nextInt();
		
		n:for(int i=0; i< testCases; i++)
		{
			int tasks = scanner.nextInt();
			String ans = "";
			
			String[] tasksList = new String[tasks];
			
			Set<Integer> cMinutes = new HashSet<>();
			Set<Integer> jMinutes = new HashSet<>();
			
			Set<Integer> startingAndEndingC = new HashSet<>();
			Set<Integer> startingAndEndingJ = new HashSet<>();
			
			
			for(int j=0; j< tasks; j++)
			{
				int startingTime = scanner.nextInt();
				int endingTime   = scanner.nextInt();
				
				String s = startingTime+"-"+endingTime;
				tasksList[j] = s;
			}
			
			for(int j=0; j<tasksList.length; j++)
			{
				String[] task = tasksList[j].split("-");
				int startingTime	=	Integer.parseInt(task[0]);
				int endingTime      =   Integer.parseInt(task[1]);
				
				
				if(check(startingTime,endingTime,cMinutes,startingAndEndingC))
				{
					ans += "C";
				}
				else if(check(startingTime,endingTime,jMinutes,startingAndEndingJ))
				{
					ans += "J";
				}
				else
				{
					int test = i+1;
					System.out.println("Case #"+test+": IMPOSSIBLE");
					continue n;
				}
			}
			
			int test = i+1;
			System.out.println("Case #"+test+": "+ans);
		}
	}
	
	public static boolean check(int startingTime,int endTime,Set<Integer> hashSet,Set<Integer> startingAndEnding)
	{
		for(int i=startingTime; i<= endTime; i++)
		{
			if(hashSet.contains(i))
			{
				return false;
			}
		}
		
		if(startingAndEnding.contains(startingTime) && startingAndEnding.contains(endTime))
		{
			return false;
		}
		
		startingAndEnding.add(startingTime);
		startingAndEnding.add(endTime);
		
		for(int i=startingTime+1; i<endTime; i++)
		{
			hashSet.add(i);
		}
		return true;
		
		//String taskTime = startingTime+"-"+endTime;
		//checkingTask.add(taskTime);
		//return true;
	}

}
