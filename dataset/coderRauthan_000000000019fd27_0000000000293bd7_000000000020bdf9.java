import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
			List<String> Ctasks = new ArrayList<>();
			List<String> JTasks = new ArrayList<>();
			
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
				
				
				if(check(startingTime,endingTime,Ctasks))
				{
					ans += "C";
				}
				else if(check(startingTime,endingTime,JTasks))
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
	
	public static boolean check(int startingTime,int endTime,List<String> checkingTask)
	{
		for(int i=0; i< checkingTask.size(); i++)
		{
			String[] s = checkingTask.get(i).split("-");
			int personStartTime = Integer.parseInt(s[0]);
			int personEndTime   = Integer.parseInt(s[1]);
			
			if(startingTime > personStartTime && startingTime < personEndTime)
			{
				return false;
			}
			else if(endTime > personStartTime && endTime < personEndTime )
			{
				return false;
			}
		}
		
		String taskTime = startingTime+"-"+endTime;
		checkingTask.add(taskTime);
		return true;
	}

}
