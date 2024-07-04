import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {
	private static final String Impossible = "IMPOSSIBLE";
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int testNumber = in.nextInt();
		List<ParentingParentingTest> tests = new ArrayList<>(testNumber);

		for (int i = 1; i <= testNumber; i++) {
			final int activityNumber = in.nextInt();
			ParentingParentingTest cur = new ParentingParentingTest(activityNumber);
			for(int j = 0; j< activityNumber; j++){
				int start = in.nextInt(), end = in.nextInt();
				cur.addActivity(j, start, end);
			}
			tests.add(cur);
		}

		for (int i = 0; i < tests.size(); i++) {
			ParentingParentingTest test = tests.get(i);
			outputTestResult(i+1, test.activities);
		}
	}

	private static void outputTestResult(int i, List<Activity> activities){
		printAnswer(i, getSchedule(activities));
	}


	private static void printAnswer(int i, String output) {
		System.out.println("Case #" + i + ": " + output);
	}

	private static String getSchedule(List<Activity> activities) {
		Collections.sort(activities);
		char[] result = new char[activities.size()];
		int cameron = -1, jamie = -1;

		for (Activity a : activities) {
			int start = a.start, end = a.end;
			if (start < cameron && start < jamie) return Impossible;
			else if (start >= cameron) {
				cameron = end;
				result[a.originalIdx] = 'C';
			} else {
				jamie = end;
				result[a.originalIdx] = 'J';
			}
		}
		return new String(result);
	}

	static class Activity implements Comparable<Activity> {
		int originalIdx, start, end;

		Activity(int org, int start, int end) {
			this.originalIdx = org;
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Activity o) {
			if (this.end == o.end) return Integer.compare(this.start, o.start);
			return Integer.compare(this.end, o.end);
		}
	}

	static class ParentingParentingTest {
		int n;
		List<Activity> activities;

		ParentingParentingTest(int n){
			this.n = n;
			activities = new ArrayList<>(n);
		}

		void addActivity(int idx, int start, int end){
			this.activities.add(new Activity(idx, start, end));
		}
	}
}