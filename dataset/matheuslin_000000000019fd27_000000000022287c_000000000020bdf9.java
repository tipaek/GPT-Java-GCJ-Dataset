import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		in.nextLine();
		for (int i = 1; i <= t; ++i) {

			// read input
			int n = in.nextInt();
			in.nextLine();
			
			List<Activity> activities = new LinkedList<>();
			for(int j = 0; j < n; j++) {
				int start = in.nextInt();
				int end = in.nextInt();
				in.nextLine();
				
				activities.add(new Activity(start, end));
			}
			
			String answer = schedule(activities);
			

			System.out.println("Case #" + i + ": " + answer);
		}
	}
	
	public static String schedule(List<Activity> activities) {
		int n = activities.size();
		int limit = n * n;
		int run = 0;
		
		while(run < limit && Activity.anyCollide(activities)) {
			boolean keepSwapping = true;
			for(int i = 0; i < n && keepSwapping; i++) {
				keepSwapping = activities.get(i).swap() == 'C';
			}
			run++;
		}
		
		if(Activity.anyCollide(activities)) {
			return "IMPOSSIBLE";
		}
		
		StringBuilder answer = new StringBuilder();
		for(Activity a : activities) {
			answer.append(a.assigned);
		}
		return answer.toString();
	}
	
	static class Activity{
		int start;
		int end;
		
		char assigned;
		
		public Activity(int start, int end) {
			this.start = start;
			this.end = end;
			this.assigned = 'C';
		}
		
		public boolean collides(Activity other) {
			return 
					(this.assigned == other.assigned) // assigned to same person
					&& // overlaps in time
					(
						(
							this.start >= other.start && this.start < other.end
						) 
						||
						(
							this.end > other.start && this.end < other.end
						)
					);
		}
		
		public char swap() {
			this.assigned = this.assigned == 'C' ? 'J' : 'C';
			return this.assigned;
		}
		
		public static boolean anyCollide(List<Activity> activities) {
			for(Activity a : activities) {
				for(Activity b : activities) {
					if( (a != b) && a.collides(b) ) {
						return true;
					}
				}
			}
			
			return false;
		}
	}

}