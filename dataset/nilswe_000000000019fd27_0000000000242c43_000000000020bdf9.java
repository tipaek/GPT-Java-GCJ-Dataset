
import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws FileNotFoundException {
		final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		// new Scanner(new BufferedReader(new FileReader("res/q3.txt")));
		final int nTestCases = in.nextInt();
		testCases:
		for (int i = 1; i <= nTestCases; i++) {
			// input
			final int n = in.nextInt();
			final int[][] activities = new int[n][2];
			for (int j = 0; j < n; j++) {
				activities[j][0] = in.nextInt();
				activities[j][1] = in.nextInt();
			}
			// magic
			final StringBuilder sb = new StringBuilder();
			Arrays.sort(activities, Comparator.comparingDouble(activity -> activity[0]));
			int cNextEnd = 0, jNextEnd = 0;
			for (final int[] activity : activities) {
				final int start = activity[0];
				final int end = activity[1];
				// assign any free parent
				if (cNextEnd <= start) {
					cNextEnd = end;
					sb.append('C');
				} else if (jNextEnd <= start) {
					jNextEnd = end;
					sb.append('J');
				} else {
					System.out.println(String.format("Case #%d: %s", i, "IMPOSSIBLE"));
					continue testCases;
				}
			}
			// print
			System.out.println(String.format("Case #%d: %s", i, sb.toString()));
		}
	}

}
