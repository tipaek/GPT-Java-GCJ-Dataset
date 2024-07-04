import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {
	Scanner input;
	PrintStream output;

	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		PrintStream output = System.out;
		int numCases = input.nextInt();

		for (int t = 0; t < numCases; t++) {
			output.printf("Case #%d: ", t + 1);
			output.println(new Solution(input, output).solve());
		}

		input.close();
		output.close();

		System.exit(0);
	}

	public Solution(Scanner input, PrintStream output) {
		this.input = input;
		this.output = output;
	}
	
	public String solve() {
		int n = input.nextInt();
		StringBuilder sb = new StringBuilder();
		List<Activity> activities = new ArrayList<>();
		List<Activity> sortedActivities = new ArrayList<>();
		Activity lastCameronActivity = null;
		Activity lastJamieActivity = null;
		
		for (int i = 0; i < n; i++) {
			Activity activity = new Activity(input.nextInt(), input.nextInt()); 
			activities.add(activity);
		}
		
		sortedActivities.addAll(activities);
		Collections.sort(sortedActivities);
		
		for (Activity activity : sortedActivities) {
			if (lastCameronActivity == null || !activity.overlap(lastCameronActivity)) {
				sb.append("C");
				lastCameronActivity = activity;
			} else if (lastJamieActivity == null || !activity.overlap(lastJamieActivity)) {
				sb.append("J");
				lastJamieActivity = activity;
			} else {
				return "IMPOSSIBLE";
			}
		}
		
		return sb.toString();
	}

	class Activity implements Comparable<Activity> {
		int start;
		int end;

		public Activity(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Activity period2) {
			if (this.start == period2.start) {
				return this.end - period2.end;
			} else {
				return this.start - period2.start;
			}
		}
		
		public boolean overlap(Activity period2) {
			return (this.start < period2.end && this.end > period2.start);
		}
	}
}