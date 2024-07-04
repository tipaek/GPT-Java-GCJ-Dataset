import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solution {
	private static final String IMPOSSIBLE = "IMPOSSIBLE";
	private static final char JAMIE = 'J';
	private static final char CAMERON = 'C';
	public static final String CASE = "Case #";

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		try {
			int testCaseNumber = in.nextInt();
			int numAct = 0;
			ArrayList<Activity> act = new ArrayList<>();
			for (int currentTestCase = 1; currentTestCase <= testCaseNumber; ++currentTestCase) {
				numAct = in.nextInt();
				act.clear();
				for (int i = 0; i < numAct; i++) {
					act.add(new Solution.Activity(in.nextInt(), in.nextInt(), i));
				}
				Collections.sort(act);
				System.out.println(calculate(currentTestCase, act));
			}
		} finally {
			in.close();
		}
	}

	static class Activity implements Comparable<Activity> {
		public int start;
		public int end;
		public int index;

		public Activity(int start, int end, int index) {
			this.start = start;
			this.end = end;
			this.index = index;
		}

		@Override
		public int compareTo(Activity that) {
			return Integer.valueOf(start).compareTo(Integer.valueOf(that.start));
		}
	}

	public static String calculate(int testCaseNum, ArrayList<Activity> act) {
		String output = CASE + testCaseNum + ": ";
		char[] res = new char[act.size()];
		int cEnd = 0, jEnd = 0;

		for (Activity a : act) {
			if (a.start >= cEnd) {
				res[a.index] = CAMERON;
				cEnd = a.end;
			} else if (a.start >= jEnd) {
				res[a.index] = JAMIE;
				jEnd = a.end;
			} else {
				return output + IMPOSSIBLE;
			}
		}
		return output + new String(res);
	}
}
