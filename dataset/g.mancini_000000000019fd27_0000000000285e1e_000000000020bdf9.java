
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Solution {

	public static void main(String[] args) {
		// solve(Solution::solveNestingDepthLine);
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
		List<Integer> cHours = new LinkedList<>();
		List<Integer> jHours = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			int start = in.nextInt();
			int end = in.nextInt();
			if (canDoWork(start, end, cHours)) {
				cHours.add(start);
				cHours.add(end);
				result.append("C");
			} else if (canDoWork(start, end, jHours)) {
				jHours.add(start);
				jHours.add(end);
				result.append("J");
			} else {
				result = new StringBuilder("IMPOSSIBLE");
				break;
			}
		}
		return result.toString();
	}

	private static boolean canDoWork(int start, int end, List<Integer> works) {
		for(int i = 0; i < works.size(); i+=2) {
			int wStart = works.get(i);
			int wEnd = works.get(i + 1);
			if ((start > wStart && start < wEnd) || (end > wStart && end < wEnd)) {
				return false;
			}
		}
		return true;
	}

	private static String solveNestingDepthLine(Scanner in) {
		String input = in.next();
		List<String> result = new ArrayList<>();
		int parenthesis = 0;

		for (char charN : input.toCharArray()) {
			int n = Integer.parseInt(String.valueOf(charN));
			int needed = n - parenthesis;
			int index = n;
			List<String> current = new ArrayList<>();
			if (needed > 0) {
				for (int i = 0; i < needed; i++) {
					current.add("(");
				}
				current.add(String.valueOf(n));
				for (int i = 0; i < needed; i++) {
					current.add(")");
				}
				index = parenthesis;
				parenthesis = n;
			} else {
				current.add(String.valueOf(n));
				parenthesis = n;
			}
			result.addAll(result.size() - index, current);
		}
		return result.stream().map(String::valueOf).collect(Collectors.joining());
	}

	private static void writeSolutionLine(long index, String output) {
		System.out.println("Case #" + index + ": " + output);
	}
}
