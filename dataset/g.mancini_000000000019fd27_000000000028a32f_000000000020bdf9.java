
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
		List<Work> solutions = new LinkedList<>();
		solutions.add(new Work());
		int n = in.nextInt();
		for (int i = 0; i < n; i++) {
			int start = in.nextInt();
			int end = in.nextInt();
			List<Work> newSolutions = new LinkedList<>();
			for (Work solution : solutions) {
				if (solution.failed) {
					continue;
				}
				if (canDoWork(start, end, solution.cHours)) {
					if (canDoWork(start, end, solution.jHours)) {
						Work newWork = duplicateWork(solution);
						newSolutions.add(newWork);
						newWork.schedule.append("J");
						newWork.jHours.add(start);
						newWork.jHours.add(end);
					}
					solution.cHours.add(start);
					solution.cHours.add(end);
					solution.schedule.append("C");
				} else if (canDoWork(start, end, solution.jHours)) {
					if (canDoWork(start, end, solution.cHours)) {
						Work newWork = duplicateWork(solution);
						newSolutions.add(newWork);
						newWork.schedule.append("C");
						newWork.cHours.add(start);
						newWork.cHours.add(end);
					}
					solution.schedule.append("J");
					solution.jHours.add(start);
					solution.jHours.add(end);
				} else {
					solution.failed = true;
				}
			}
			solutions.addAll(newSolutions);
		}
		return solutions.stream().filter(s -> !s.failed).map(w -> w.schedule.toString()).findAny().orElse("IMPOSSIBLE");
	}

	private static Work duplicateWork(Work solution) {
		Work newWork = new Work();
		newWork.cHours.addAll(solution.cHours);
		newWork.jHours.addAll(solution.jHours);
		newWork.schedule = new StringBuilder(solution.schedule);
		return newWork;
	}

	private static boolean canDoWork(int start, int end, List<Integer> works) {
		boolean result = true;
		for (int i = 0; i < works.size(); i += 2) {
			int wStart = works.get(i);
			int wEnd = works.get(i + 1);
			if ((start > wStart && start < wEnd) || (end > wStart && end < wEnd) || (start <= wStart && end >= wEnd)) {
				result = false;
				break;
			}
		}
		return result;
	}

	private static class Work {
		StringBuilder schedule = new StringBuilder();
		List<Integer> cHours = new LinkedList<>();
		List<Integer> jHours = new LinkedList<>();
		boolean failed;
	}

	private static void writeSolutionLine(long index, String output) {
		System.out.println("Case #" + index + ": " + output);
	}
}
