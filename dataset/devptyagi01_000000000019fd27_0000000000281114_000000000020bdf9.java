import java.util.*;

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
			char parent = 'J';
			StringBuilder result = new StringBuilder();
			boolean allOverlap = true;
			for(int i=0;i<n-1;i++){
			    Task currentTask = activities.get(i);
				Task nextTask = activities.get(i+1);
				if(!currentTask.overlap(nextTask)) {
				    allOverlap = false;
				}
			}
			if(allOverlap)
			{
			    System.out.println("Case #"+x+": "+"IMPOSSIBLE");
			    x++;
			    continue;
			}
			for(int i=0;i<n-1;i++)
			{
				result.append(parent);
				Task currentTask = activities.get(i);
				Task nextTask = activities.get(i+1);
				if(currentTask.overlap(nextTask)) {
					if(parent == 'C') parent = 'J';
					else if(parent == 'J') parent = 'C';
				}
			}
			result.append(parent);
			System.out.println("Case #"+x+": "+result);
			x++;
		}
	}

}
