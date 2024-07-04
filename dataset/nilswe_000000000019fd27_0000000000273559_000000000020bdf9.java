
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

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

	public static void main(String[] args)  {
		final Scanner in = getScanner("res/q3.txt");
		final int nTestCases = in.nextInt();
		testCases:
		for (int t = 1; t <= nTestCases; t++) {
			// input
			final int n = in.nextInt();
			final int[][] activitiesO = new int[n][2];
			for (final int[] activity : activitiesO) {
				activity[0] = in.nextInt();
				activity[1] = in.nextInt();
			}
			// magic
			final int[][] activities = activitiesO.clone();
			Arrays.sort(activities, Comparator.comparingInt(activity -> activity[0]));
			final Map<int[], String> assignments = new HashMap<>();
			int cNextEnd = 0, jNextEnd = 0;
			for (final int[] activity : activities) {
				final int start = activity[0];
				final int end = activity[1];
				// assign any free parent
				if (cNextEnd <= start) {
					cNextEnd = end;
					assignments.put(activity, "C");
				} else if (jNextEnd <= start) {
					jNextEnd = end;
					assignments.put(activity, "J");
				} else {
					System.out.println(String.format("Case #%d: %s", t, "IMPOSSIBLE"));
					continue testCases;
				}
			}
			final String y = Arrays.stream(activitiesO).map(assignments::get).collect(Collectors.joining());
			// print
			System.out.println(String.format("Case #%d: %s", t, y));
		}
	}

}
