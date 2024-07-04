import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution 
{
	public static void main(String[] args) 
	{
		Scanner keyboard = new Scanner(System.in);
		int tCount = keyboard.nextInt();
		for(int t = 0; t < tCount; t++)
		{
			String taskAssignment = "";
			
			List<Task> tasks = new ArrayList<Task>();
			int taskCount = keyboard.nextInt();
			for(int i = 0; i < taskCount; i++)
			{
				int startTime = keyboard.nextInt();
				int endTime = keyboard.nextInt();
				tasks.add(new Task(startTime, endTime, i));
				taskAssignment+="X";
			}
			
			//Sort all of the tasks by their start time.
			Collections.sort(tasks);
			
			//Start assigning tasks.
			Task cTask = null;
			Task jTask = null;
			for(int i = 0; i < tasks.size(); i++)
			{
				Task curTask = tasks.get(i);
				if(cTask == null || cTask.endTime <= curTask.startTime)
				{
					cTask = curTask;
					taskAssignment = replaceAtIndex(taskAssignment, curTask.taskId, "C");
				}
				else if(jTask == null || jTask.endTime <= curTask.startTime)
				{
					jTask = curTask;
					taskAssignment = replaceAtIndex(taskAssignment, curTask.taskId, "J");
				}
				else
				{
					taskAssignment = "IMPOSSIBLE";
					break;
				}
			}
			
			//Print result of test case.
			System.out.println("Case #" + (t+1) + ": " + taskAssignment);
		}
	}
	
	private static String replaceAtIndex(String str, int index, String value)
	{
		return str.substring(0, index) + value + str.substring(index+1);
	}
}

class Task implements Comparable<Task>
{
	public int startTime;
	public int endTime;
	public int taskId;
	public Task(int startTime, int endTime, int taskId)
	{
		this.startTime = startTime;
		this.endTime = endTime;
		this.taskId = taskId;
	}
	public int compareTo(Task o) 
	{
		return startTime - o.startTime;
	}
}
