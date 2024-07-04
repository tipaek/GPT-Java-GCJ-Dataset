import java.util.Arrays;
import java.util.Comparator;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
	private static Scanner scanner;
	private static final char J = 'J';
	private static final char C = 'C';
	private static final String IMPOS = "IMPOSSIBLE";

	public static void main(String[] args) throws Exception {
//		scanner = new Scanner(new FileInputStream(new File(Solution.class.getResource("input.txt").toURI())));
		scanner = new Scanner(System.in);
		run(scanner);
	}

	private static void run(Scanner scanner) {
		int t = scanner.nextInt();
		long time = System.currentTimeMillis();
		for (int i = 0; i < t; i++) {
			solveCaseF2(i);
		}
		System.out.println(System.currentTimeMillis() - time);
	}

	private static void solveCaseF(int i) {
		int n = scanner.nextInt();
		int[][] events = new int[n][2];
		Map<int[], Integer> eventIndexMap = new IdentityHashMap<>();
		for (int j = 0; j < events.length; j++) {
			events[j][0] = scanner.nextInt();
			events[j][1] = scanner.nextInt();
			eventIndexMap.put(events[j], j);
		}

		// sort by start time
		Comparator<int[]> comp = Comparator.<int[]>comparingInt(e -> e[0]);
		Arrays.sort(events, comp);

//		System.out.println(Arrays.deepToString(events));
		StringBuilder assignments = solveRecursiveF(events, new StringBuilder(String.valueOf(C)));
		String result = IMPOS;
		if (assignments != null) {
			char[] tmp = new char[n];
			for (int j = 0; j < n; j++) {
				char c = assignments.charAt(j);
				int[] e = events[j];
				tmp[eventIndexMap.get(e)] = c;
			}
			result = new String(tmp);
		}
		printCase(i, result);
	}

	private static StringBuilder solveRecursiveF(final int[][] events, final StringBuilder assignments) {
		if (assignments.length() == events.length) {
			return assignments;
		}
		int lastAssignmentIndex = assignments.length() - 1;
		while (assignments.length() < events.length) {
			final int cFinish = getFinishTime(events, assignments, C);
			final int nextAssignmentStart = events[lastAssignmentIndex + 1][0];
			if (cFinish <= nextAssignmentStart) {
				StringBuilder tmp = new StringBuilder(assignments);
				tmp.append(C);
				StringBuilder result = solveRecursiveF(events, tmp);
				if (result != null) {
					return result;
				}
			}
			final int jFinish = getFinishTime(events, assignments, J);
			if (jFinish <= nextAssignmentStart) {
				StringBuilder tmp = new StringBuilder(assignments);
				tmp.append(J);
				StringBuilder result = solveRecursiveF(events, tmp);
				if (result != null) {
					return result;
				}
			}
			return null;
		}
		return null;
	}

	private static void solveCaseF2(int i) {
		int n = scanner.nextInt();
		int[][] events = new int[n][2];
		Map<int[], Integer> eventIndexMap = new IdentityHashMap<>();
		for (int j = 0; j < events.length; j++) {
			events[j][0] = scanner.nextInt();
			events[j][1] = scanner.nextInt();
			eventIndexMap.put(events[j], j);
		}

		// sort by start time
		Comparator<int[]> comp = Comparator.<int[]>comparingInt(e -> e[0]);
		Arrays.sort(events, comp);

//		System.out.println(Arrays.deepToString(events));
		char[] assignments = solveRecursiveF2(events);
		String result = IMPOS;
		if (assignments != null) {
			char[] tmp = new char[n];
			for (int j = 0; j < n; j++) {
				char c = assignments[j];
				int[] e = events[j];
				tmp[eventIndexMap.get(e)] = c;
			}
			result = new String(tmp);
		}
		printCase(i, result);
	}

	private static char[] solveRecursiveF2(final int[][] events) {
		final char[] result = new char[events.length];
		result[0] = C;
		int[] busy = new int[] { events[0][1], -1 };
		for (int i = 1; i < events.length; i++) {
			int start = events[i][0];
			int end = events[i][1];
			if (busy[0] <= start) {
				result[i] = C;
				busy[0] = end;
			} else if (busy[1] <= start) {
				result[i] = J;
				busy[1] = end;
			} else {
				return null;
			}
		}
		return result;
	}

	private static int getFinishTime(final int[][] events, final StringBuilder assignments, final char c) {
		final int lastAssignmentIndex = assignments.length() - 1;
		for (int i = lastAssignmentIndex; i >= 0; i--) {
			if (assignments.charAt(i) == c) {
				return events[i][1];
			}
		}
		return 0;
	}

	private static void printCase(int i, String str) {
		System.out.println("Case #" + (i + 1) + ": " + str);
	}
}
