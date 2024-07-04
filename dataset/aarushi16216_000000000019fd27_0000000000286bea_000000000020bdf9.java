import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

class Task implements Comparable<Task>
{
	int startTime = 0;
	int endTime = 0;
	int index = 0;
	
	public Task(int startTime, int endTime, int index)
	{
		this.startTime = startTime;
		this.endTime = endTime;
		this.index = index;
	}

	@Override
	public int compareTo(Task nextTask) {
		// TODO Auto-generated method stub
		return this.startTime - nextTask.startTime;
	}
}

public class Solution
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for(int k = 1; k<=t; k++)
        {
            int numTasks = sc.nextInt();
            Task tasks[] = new Task[numTasks];
            
            for(int i=0; i<numTasks; i++)
            {
            	int start = sc.nextInt();
            	int end = sc.nextInt();
            	Task newTask = new Task(start,end,i);
            	tasks[i] = newTask;
            }
            
            Arrays.sort(tasks);
            
            int freeC = -1;
            int freeJ = -1;
            
            String str = "";
            int impossible = 0;
            
            for(int i=0; i<numTasks; i++)
            {            	
            	if(tasks[i].startTime >= freeC)
            	{
            		str += "C";
            		freeC = tasks[i].endTime;
            	}
            	else if(tasks[i].startTime >= freeJ)
            	{
            		str += "J";
            		freeJ = tasks[i].endTime;
            	}
            	else
            	{
            		impossible = 1;
            	}
            }
                       
            if(impossible == 1)
            	System.out.println("IMPOSSIBLE");
            else
            {
            	char strFinal[] = new char[numTasks];
                for(int i=0 ; i<numTasks; i++)
                {
                	int index = tasks[i].index;
                	strFinal[index] = str.charAt(i);
                }
                
                String temp = "";
                for(int i=0 ;i<numTasks; i++)
                {
                	temp += strFinal[i];
                }
                System.out.println("Case #"+ k +": "+temp);  
            }            	          
        }
    }
}