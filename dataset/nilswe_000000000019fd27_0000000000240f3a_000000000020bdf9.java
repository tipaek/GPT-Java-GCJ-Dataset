
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) throws FileNotFoundException {
		final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		// new Scanner(new BufferedReader(new FileReader("res/q3.txt")));
		final int nTestCases = in.nextInt();
		testcase:
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
			Arrays.sort(activities, Comparator.comparingDouble(a -> a[0]));
			int cNextEnd=0, jNextEnd=0;
			for (int j = 0; j < n; j++) {
				final int[] activity = activities[j];
				if (cNextEnd<=activity[0]) {
					cNextEnd=activity[1];
					sb.append('C');
				} else if (jNextEnd<=activity[0]) {
					jNextEnd=activity[1];
					sb.append('J');
				} else {
					System.out.println(String.format("Case #%d: %s", i, "IMPOSSIBLE"));
					continue testcase;
				}
			}
			// print
			System.out.println(String.format("Case #%d: %s", i, sb.toString()));
		}
	}

}
