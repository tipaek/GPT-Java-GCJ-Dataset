import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {
	private static Scanner scanner;

	static final Character J = 'J';
	static final Character C = 'C';

	public static void main(String[] args) throws Exception {
//		scanner = new Scanner(new FileInputStream(new File(Solution.class.getResource("input.txt").toURI())));
		scanner = new Scanner(System.in);
		run(scanner);
	}

	private static void run(Scanner scanner) {
		int t = scanner.nextInt();
		long time = System.currentTimeMillis();
		for (int i = 0; i < t; i++) {
			solveCase(i, scanner);
		}
//		System.out.println(System.currentTimeMillis() - time);
	}

	private static void solveCase(int i, Scanner scanner) {
		int n = scanner.nextInt();
		int[][] events = new int[n][2];
		Map<int[], Integer> eventIndexMap = new IdentityHashMap<>();
		for (int j = 0; j < events.length; j++) {
			events[j][0] = scanner.nextInt();
			events[j][1] = scanner.nextInt();
			eventIndexMap.put(events[j], j);
		}

		// sort by start time
		Comparator<int[]> comp = Comparator.<int[]>comparingInt(e -> e[0])
				.thenComparing(Comparator.<int[]>comparingInt(e -> e[1]));
		Arrays.sort(events, comp);

//		System.out.println(Arrays.deepToString(events));
		String result = solveRecursive(events, Arrays.asList(C));
		if (result != IMPOS) {
			char[] tmp = new char[n];
			for (int j = 0; j < n; j++) {
				char c = result.charAt(j);
				int[] e = events[j];
				tmp[eventIndexMap.get(e)] = c;
			}
			result = new String(tmp);
//			result.chars().mapToObj(i -> (char) i).sorted()
//			result = Arrays.stream(events)//
//					.map(e -> String.valueOf(tmpRes.charAt(eventIndexMap.get(e))))//
//					.collect(Collectors.joining());
		}
		printCase(i, result);
	}

	private static final String IMPOS = "IMPOSSIBLE";

	private static String solveRecursive(int[][] events, List<Character> assignments) {
		if (assignments.size() == events.length) {
			return assignments.stream().map(String::valueOf).collect(Collectors.joining());
		}
		int lastAssignmentIndex = assignments.size() - 1;
		while (assignments.size() < events.length) {
			int cFinish = getFinishTime(events, assignments, C);
			int jFinish = getFinishTime(events, assignments, J);
//			System.out.println("C " + cFinish + " J " + jFinish);
			int nextAssignmentStart = events[lastAssignmentIndex + 1][0];
			if (cFinish <= nextAssignmentStart) {
				List<Character> tmp = new ArrayList<>(assignments);
				tmp.add(C);
				String result = solveRecursive(events, tmp);
				if (result != IMPOS) {
					return result;
				}
			}
			if (jFinish <= nextAssignmentStart) {
				List<Character> tmp = new ArrayList<>(assignments);
				tmp.add(J);
				String result = solveRecursive(events, tmp);
				if (result != IMPOS) {
					return result;
				}
			}
			return IMPOS;
		}
		return null;
	}

	private static int getFinishTime(int[][] events, List<Character> assignments, Character c) {
		int lastAssignmentIndex = assignments.size() - 1;
		for (int i = lastAssignmentIndex; i >= 0; i--) {
			if (assignments.get(i) == c) {
				return events[i][1];
			}
		}
		return 0;
	}

	private static void printCase(int i, String str) {
		System.out.println("Case #" + (i + 1) + ": " + str);
	}
}
