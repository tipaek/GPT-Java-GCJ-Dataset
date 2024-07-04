import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.TreeMap;

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
			TreeMap<Integer, Activity> map = new TreeMap<>();
			for (int currentTestCase = 1; currentTestCase <= testCaseNumber; ++currentTestCase) {
				numAct = in.nextInt();
				for (int i = 0; i < numAct; i++) {
					map.put(in.nextInt(), new Solution.Activity(in.nextInt(), i));
				}
				System.out.println(calculate(currentTestCase, map));
			}
		} finally {
			in.close();
		}
	}

	static class Activity {
		public int end;
		public int index;

		public Activity(int end, int index) {
			this.end = end;
			this.index = index;
		}
	}

	public static String calculate(int testCaseNum, TreeMap<Integer, Activity> map) {
		String output = CASE + testCaseNum + ": ";
		StringBuilder sb = new StringBuilder();
		char[] res = new char[map.size()];
		int cEnd = 0, jEnd = 0;

		for (Integer start : map.keySet()) {
			Activity a = map.get(start);

			if (start >= cEnd) {
				res[a.index] = CAMERON;
				cEnd = a.end;
			} else if (start >= jEnd) {
				res[a.index] = JAMIE;
				jEnd = a.end;
			} else {
				return output + IMPOSSIBLE + "\n";
			}
		}
		return output + new String(res);
	}
}
