import java.util.*;
import java.io.*;

class Task {
	int start;
	int end;
	
	public Task(int s, int e) {
		this.start = s;
		this.end = e;
	}
	
	boolean overlap(Task t2) {
		boolean isOverlapping = false;
	
		if(this.end > t2.start)
			isOverlapping = true;
		
		return isOverlapping;
	}
	
	int getStart() {
		return this.start;
	}
}

public class Solution {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		int x = 1;
		while(t-- != 0)
		{
			int n = sc.nextInt();
			List<Task> activities = new ArrayList<>(n);
			for(int i=0;i<n;i++)
			{
				int s = sc.nextInt();
				int e = sc.nextInt();
				activities.add(new Task(s, e));
			}
			char parent = 'C';
			StringBuilder result = new StringBuilder();
			
			boolean possible = true;
			
			/*
			 * for(int i=0;i<n-1;i++){ Task currentTask = activities.get(i); Task nextTask =
			 * activities.get(i+1); if(!currentTask.overlap(nextTask)) { allOverlap = false;
			 * } }
			 * 
			 * if(allOverlap) { System.out.println("IMPOSSIBLE"); continue; }
			 */
			
			int cEnd = 0;
			int jEnd = 0;
			activities.sort(Comparator.comparing(Task::getStart));
			for(int i=0;i<n;i++)
			{
				Task currentTask = activities.get(i);
				if(currentTask.start >= cEnd)
				{
					result.append('C');
					cEnd = currentTask.end;
				}
				else if(currentTask.start >= jEnd)
				{
					result.append('J');
					jEnd = currentTask.end;
				}
				else
				{
					possible = false;
					break;
				}
			}
			//result.append(parent);
			if(possible)
				System.out.println("Case #"+x+": "+result);
			else
				System.out.println("Case #"+x+": "+"IMPOSSIBLE");
			x++;
		}
	}

}
