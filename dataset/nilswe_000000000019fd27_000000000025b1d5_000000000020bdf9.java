
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Submit without package declaration!
 */
public class Solution {

	private static Scanner getScanner(final String fileName) {
		try {
			return new Scanner(new BufferedReader(new FileReader(fileName)));
		} catch (FileNotFoundException e) {
			return new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		}
	}

	public static void main(String[] args) {
		final Scanner in = getScanner("res/q3.txt");
		final int nTestCases = in.nextInt();
		testCases:
		for (int i = 1; i <= nTestCases; i++) {
			// input
			final int n = in.nextInt();
			final int[][] activities = new int[n][2];
			for (final int[] activity : activities) {
				activity[0] = in.nextInt();
				activity[1] = in.nextInt();
			}
			// magic
			final StringBuilder sb = new StringBuilder();
			Arrays.sort(activities,
					Comparator.comparingInt((int[] o) -> o[0])
							.thenComparingInt(o -> o[1]));
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
