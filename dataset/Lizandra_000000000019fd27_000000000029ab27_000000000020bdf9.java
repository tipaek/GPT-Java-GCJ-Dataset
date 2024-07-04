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
			TreeMap<Integer, Integer> map = new TreeMap<>();
			for (int currentTestCase = 1; currentTestCase <= testCaseNumber; ++currentTestCase) {
				numAct = in.nextInt();
				for (int i = 1; i <= numAct; i++) {
					map.put(in.nextInt(), in.nextInt());
				}
				System.out.println(calculate(currentTestCase, map));
			}
		} finally {
			in.close();
		}
	}

	public static String calculate(int testCaseNum, TreeMap<Integer, Integer> map) {
		String output = CASE + testCaseNum + ": ";
		StringBuilder sb = new StringBuilder();
		int cEnd = 0, jEnd = 0;

		for (Integer start : map.keySet()) {
			Integer end = map.get(start);

			if (start >= cEnd) {
				sb.append(CAMERON);
				cEnd = end;
			} else if (start >= jEnd) {
				sb.append(JAMIE);
				jEnd = end;
			} else {
				return output + IMPOSSIBLE + "\n";
			}
		}
		return output + sb.toString();
	}
}
