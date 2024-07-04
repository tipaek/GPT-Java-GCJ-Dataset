
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

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
		List<Integer> cHours = new LinkedList<>();
		List<Integer> jHours = new LinkedList<>();
		boolean skip = false;
		for (int i = 0; i < n; i++) {
			int start = in.nextInt();
			int end = in.nextInt();
			if (skip) {
				continue;
			}
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
				skip = true;
			}
		}
		return result.toString();
	}

	private static boolean canDoWork(int start, int end, List<Integer> works) {
		boolean result = true;
		for (int i = 0; i < works.size(); i += 2) {
			int wStart = works.get(i);
			int wEnd = works.get(i + 1);
			if ((start > wStart && start < wEnd) || (end > wStart && end < wEnd)) {
				result = false;
				break;
			}
		}
		return result;
	}

	private static void writeSolutionLine(long index, String output) {
		System.out.println("Case #" + index + ": " + output);
	}
}
