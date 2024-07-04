import java.util.*;
import java.io.*;

public class Solution
{	
	public static void main(String[] args)
	{
		Scanner infile = new Scanner(System.in);
		int numTestCases = infile.nextInt();
		for(int c = 1; c <= numTestCases; c++)
		{
			int numActivities = infile.nextInt();
			Event[] events = new Event[numActivities];
			for(int i = 0; i < numActivities; i++)
				events[i] = new Event(infile.nextInt(), infile.nextInt(), i);
			Arrays.sort(events);
			
			boolean[] jamie = new boolean[1441];
			boolean[] cameron = new boolean[1441];
			boolean possible = true;
			char[] answer = new char[numActivities];
			label:for(int i = 0; i < events.length; i++)
			{
				if(jamie[events[i].getStart() + 1] && cameron[events[i].getStart() + 1])
				{
					possible = false;
					break label;
				}
				else if(!jamie[events[i].getStart() + 1])
				{
					for(int j = events[i].getStart() + 1; j <= events[i].getEnd(); j++)
						jamie[j] = true;
					answer[events[i].getNumber()] = 'J';
				}
				else
				{
					for(int j = events[i].getStart() + 1; j <= events[i].getEnd(); j++)
						cameron[j] = true;
					answer[events[i].getNumber()] = 'C';
				}
			}
			
			if(!possible)
				System.out.println("Case #" + c + ": IMPOSSIBLE");
			else
			{
				System.out.print("Case #" + c + ": ");
				for(int i = 0; i < numActivities; i++)
					System.out.print(answer[i]);
				System.out.println();
			}
		}
	}
}

class Event implements Comparable<Event>
{
	private int startTime, endTime, number;
	
	public Event(int s, int e, int n)
	{
		startTime = s;
		endTime = e;
		number = n;
	}
	
	public int getStart()
	{
		return startTime;
	}
	
	public int getEnd()
	{
		return endTime;
	}
	
	public int getNumber()
	{
		return number;
	}
	
	public int compareTo(Event other)
	{
		if(this.startTime - other.startTime == 0)
			return this.endTime - other.endTime;
		return this.startTime - other.startTime;
	}
}