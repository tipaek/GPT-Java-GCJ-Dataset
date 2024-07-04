
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Solution {

	public static void main(String[] args) {
		solve(Solution::solveParentingPartnering);
		System.exit(0);
	}

	private static void solve(Function<Scanner, String> solveLine) {
		Scanner in = new Scanner(System.in);
		long testCases = in.nextLong();

		for (int i = 0; i < testCases; i++) {
			writeSolutionLine(i + 1, solveLine.apply(in));
		}
	}

	private static String solveParentingPartnering(Scanner in) {
		StringBuilder result = new StringBuilder();
		int n = in.nextInt();
		List<Map.Entry<Integer, Integer>> cHours = new LinkedList<>();
		List<Map.Entry<Integer, Integer>> jHours = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			int start = in.nextInt();
			int end = in.nextInt();
			if (canDoWork(start, end, cHours)) {
				cHours.add(new AbstractMap.SimpleEntry(start, end));
				result.append("C");
			} else if (canDoWork(start, end, jHours)) {
				jHours.add(new AbstractMap.SimpleEntry(start, end));
				result.append("J");
			} else {
				result = new StringBuilder("IMPOSSIBLE");
				break;
			}
		}
		return result.toString();
	}

	private static boolean canDoWork(int start, int end, List<Map.Entry<Integer, Integer>> works) {
		for (Map.Entry<Integer, Integer> hour : works) {
			int wStart = hour.getKey();
			int wEnd = hour.getValue();
			if ((start > wStart && start < wEnd) || (end > wStart && end < wEnd)) {
				return false;
			}
		}
		return true;
	}

	private static void writeSolutionLine(long index, String output) {
		System.out.println("Case #" + index + ": " + output);
	}
}
