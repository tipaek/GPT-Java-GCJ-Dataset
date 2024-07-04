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

		for (int i = 0; i < n; i++) {
			Activity activity = new Activity(input.nextInt(), input.nextInt());
			activities.add(activity);
		}

		sortedActivities.addAll(activities);
		Collections.sort(sortedActivities);

		for (int i = 0; i < Math.pow(2, n); i++) {
			String distribution = String.format("%" + n + "s", Integer.toBinaryString(i)).replace(' ', '0');

			if (check(activities, distribution)) {
				for (int d = 0; d < distribution.length(); d++) {
					if (distribution.substring(d, d + 1).equals("0")) {
						sb.append("C");
					} else {
						sb.append("J");
					}
				}

				return sb.toString();
			}
		}

		return "IMPOSSIBLE";
	}

	private boolean check(List<Activity> activities, String distribution) {
		List<Activity> cameronActivities = new ArrayList<>();
		List<Activity> jamieActivities = new ArrayList<>();

		for (int d = 0; d < distribution.length(); d++) {
			if (distribution.substring(d, d + 1).equals("0")) {
				cameronActivities.add(activities.get(d));
			} else {
				jamieActivities.add(activities.get(d));
			}
		}
		
		Collections.sort(cameronActivities);
		Collections.sort(jamieActivities);

		if (check(cameronActivities) && check(jamieActivities)) {
			return true;
		}

		return false;
	}

	private boolean check(List<Activity> activities) {
		for (int i = 1; i < activities.size(); i++) {
			if (activities.get(i).overlap(activities.get(i - 1))) {
				return false;
			}
		}
		
		return true;
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