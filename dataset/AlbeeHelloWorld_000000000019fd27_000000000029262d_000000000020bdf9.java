import java.io.*;
import java.util.*;

public class Solution {
	static class Activity implements Comparable<Activity>
	{
             int start;
             int end;
             String assignTo;

             Activity(int start, int end)
             {
                this.start = start;
                this.end = end;
                assignTo = "";
             }

             public boolean equals(Object other) 
             {
                  if (!(other instanceof Activity)) 
                    return false;
                  Activity p = (Activity) other;
                  if (this.start == p.start && this.end == p.end) return true;
                  return false;
             }           

             public int compareTo(Activity a)
             {
               if (this.start < a.start) return -1;
               if (this.start > a.start) return 1;
               if (this.end < a.end) return -1;
               if (this.end > a.end) return 1;
               return 0;
             }

	}
	public static void main(String[] args) throws Exception
	{
		
        	Scanner scan = getScanner();
        	String line = scan.nextLine();
        	int T = Integer.parseInt(line);
		    for (int i = 0; i < T; i++)
		    {
			    line = scan.nextLine();
        		int N = Integer.parseInt(line);
        		Activity[] activities = new Activity[N];
        		Activity[] output = new Activity[N];
			    for (int j = 0; j < N; j++)
			    {
				    output[j] = activities[j] = new Activity(scan.nextInt(), scan.nextInt());
				    line = scan.nextLine();
        		}
        		Arrays.sort (activities);
        		Activity C = null;
        		Activity J = null;
        		boolean possible = true;
        		for (int j = 0; j < N; j++)
        		{
        			if (!overlap(C, activities[j]))
        			{
        				activities[j].assignTo="C";
        				C = activities[j];
        			}else if (!overlap(J, activities[j]))
        			{
        				activities[j].assignTo="J";
        				J = activities[j];
        			}else
        			{
        				possible = false;
        				break;
        			}
        			
        		}
        		if (!possible) System.out.println("Case #" + (i+1) + ": IMPOSSIBLE");
        		else
        		{
        			System.out.print("Case #" + (i+1) + ": ");
        			for (int j = 0; j < N; j++)
        				System.out.print(output[j].assignTo);
        			System.out.println();
        		}
        	}
	}
	
	static boolean overlap(Activity a, Activity b)
	{
		if (a == null || b == null) return false;
		
		if (a.start > b.start)
		{
			Activity t = a;
			a = b;
			b = t;
		}
		
		if (a.end <= b.start) return false;
		return true;
	}
	
	static Scanner getScanner() throws Exception
	{
		return new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		//return new Scanner(new File("input.txt"));
	}
        
}

  