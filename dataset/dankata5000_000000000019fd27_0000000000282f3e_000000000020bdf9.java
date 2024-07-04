import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

public class Solution {

	public static void main(String[] args) {
		Solution solution = new Solution();
		String result = solution.run(System.in);
		System.out.print(result);
	}

	String run(InputStream is) {
		StringBuilder out = new StringBuilder();
		try (Scanner scanner = new Scanner(is)) {
			final int T = scanner.nextInt();
			scanner.nextLine();

			for (int t = 1; t <= T; t++) {
				int N = scanner.nextInt();
				int[] S = new int[N];
				int[] E = new int[N];

				for (int i = 0; i < N; i++) {
					S[i] = scanner.nextInt();
					E[i] = scanner.nextInt();
				}

				String result = doIt(S, E);
				out.append("Case #" + t + ": " + result + System.lineSeparator());
			}
		}
		return out.toString();
	}

	String doIt(int[] S, int[] E) {
		int N = E.length;
		Activity[] activities = new Activity[N];
		SortedMap<Integer, Moment> moments = new TreeMap<>();

		for (int i = 0; i < N; i++) {
			int start = S[i];
			int end = E[i];

			Activity activity = new Activity(start, end);
			activities[i] = activity;

			Moment moment;

			if (moments.containsKey(start)) {
				moment = moments.get(start);
			} else {
				moment = new Moment();
				moments.put(start, moment);
			}
			moment.starts.add(activity);

			if (moments.containsKey(end)) {
				moment = moments.get(end);
			} else {
				moment = new Moment();
				moments.put(end, moment);
			}
			moment.ends.add(activity);
		}

		boolean cAvailable = true;
		boolean jAvailable = true;


		for (Integer time : moments.keySet()) {
			Moment moment = moments.get(time);

			for (Activity activity : moment.ends) {
				if (activity.parent == Parent.C) {
					cAvailable = true;
				} else if (activity.parent == Parent.J) {
					jAvailable = true;
				}
			}

			for (Activity activity : moment.starts) {
				if (cAvailable) {
					activity.parent = Parent.C;
					cAvailable = false;
				} else if (jAvailable) {
					activity.parent = Parent.J;
					jAvailable = false;
				} else {
					return "IMPOSSIBLE";
				}
			}
		}

		StringBuilder result = new StringBuilder();

		for (Activity activity : activities) {
			result.append(activity.parent);
		}

		return result.toString();
	}

	enum Parent {
		C, J;
	}

	class Activity {
		private int start;
		private int end;
		Parent parent;

		Activity(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}

	class Moment {
		List<Activity> starts = new ArrayList<>();
		List<Activity> ends = new ArrayList<>();
	}
}
