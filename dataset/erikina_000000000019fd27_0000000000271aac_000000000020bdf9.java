import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

class Parent {
	public int start;
	public int stop;

	public Parent(int start, int stop) {
		this.start = start;
		this.stop = stop;
	}
}

class Activity {
	public int start;
	public int stop;
	public String assegnee;
	public int order;

	public Activity(int start, int stop, int order) {
		this.start = start;
		this.stop = stop;
		this.order = order;
	}
}

class Sortbyroll implements Comparator<Activity> {
	// Used for sorting in ascending order of
	// roll number
	@Override
	public int compare(Activity activity1, Activity activity2) {
		if (activity1.start < activity2.start)
			return -1;
		if (activity1.start > activity2.start)
			return 1;

		return 0;
	}
}

class Sortbycases implements Comparator<Activity> {
	// Used for sorting in ascending order of
	// roll number
	@Override
	public int compare(Activity activity1, Activity activity2) {
		if (activity1.order < activity2.order)
			return -1;
		if (activity1.order > activity2.order)
			return 1;

		return 0;
	}
}

public class Solution {

	public static void main(String[] args) {
		new Solution();
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int cases = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int i = 1; i <= cases; ++i) {
			int activities = in.nextInt();
			ArrayList<Activity> plan = new ArrayList<Activity>();
			for (int j = 0; j < activities; j++) {
				int durationA = in.nextInt();
				int durationB = in.nextInt();

				Activity activity = new Activity(durationA, durationB, j);

				plan.add(activity);

			}

			plan.sort(new Sortbyroll());

			Parent c = new Parent(0, 0);
			Parent j = new Parent(0, 0);

			int k = 0;
			for (k = 0; k < plan.size(); k++) {
				if (plan.get(k).start >= c.stop) {
					plan.get(k).assegnee = "C";
					c.start = plan.get(k).start;
					c.stop = plan.get(k).stop;

				} else if (plan.get(k).start >= j.stop) {
					plan.get(k).assegnee = "J";
					j.start = plan.get(k).start;
					j.stop = plan.get(k).stop;
				} else {
					break;
				}
			}

			if (k != plan.size()) {
				System.out.println("Case #" + i + ": IMPOSSIBLE");

			} else {
				plan.sort(new Sortbycases());
				String result = "";
				for (Activity p : plan) {
					result = result.concat(p.assegnee);
				}
				System.out.println("Case #" + i + ": " + result);
			}

		}

	}
}
