import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	static class Activity {
		int start;
		int end;
		char assignedTo;
		Activity(int start, int end) {
			this.start = start;
			this.end = end;
		}
		@Override
		public String toString() {
			return "(" + start + ", " + end + ")";
		}
	}
	
	private static String process(Scanner in) {
		int N = in.nextInt();
		Activity[] activities = new Activity[N];
		Activity[] sortedActivities = new Activity[N];
		for(int i = 0; i < N; i++) { 
			activities[i] = new Activity(in.nextInt(), in.nextInt());
			sortedActivities[i] = activities[i]; 
		}
		Arrays.sort(sortedActivities, (a, b) -> a.start - b.start);
		Activity C = null;
		Activity J = null;
		for(Activity act : sortedActivities) {
			if (C == null || C.end <= act.start) {
				C = act;
				act.assignedTo = 'C';
			}
			else if (J == null || J.end <= act.start) {
				J = act;
				act.assignedTo = 'J';
			}
			else
				return "IMPOSSIBLE";
		}
		StringBuilder result = new StringBuilder();
		for(Activity act : activities) 
			result.append(act.assignedTo);
		return result.toString();
	}

	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in.available() > 0 ? System.in : 
			new FileInputStream(Thread.currentThread().getStackTrace()[1].getClassName() + ".practice.in"));
		int T = in.nextInt();
		for(int i = 1; i <= T; i++) 
			System.out.format("Case #%d: %s\n", i, process(in));
	}
}
