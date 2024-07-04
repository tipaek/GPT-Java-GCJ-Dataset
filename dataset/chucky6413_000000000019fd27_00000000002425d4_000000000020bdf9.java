import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {
	private static final Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	private static final PrintWriter w = new PrintWriter(System.out);
	private static final StringBuilder rs = new StringBuilder();
	private static final String NEW_LINE = "\n";

	public static void main(String[] args) throws FileNotFoundException {
//		final Scanner sc = new Scanner(
//			new BufferedReader(new FileReader(new File(".").getAbsolutePath() + "/src/codejam/input.txt")));

		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int[][] times = new int[N][2];
			for (int i = 0; i < N; i++) {
				times[i][0] = sc.nextInt();
				times[i][1] = sc.nextInt();
			}

			rs.append(String.format("Case #%d: ", t))
				.append(solve(times))
				.append(NEW_LINE);
		}
		w.print(rs.toString());
		w.close();
	}

	private static String solve(int[][] times) {
		List<Task> tasks = new ArrayList<>();
		for (int[] time : times) {
			tasks.add(new Task(time[0], time[1]));
		}
		Collections.sort(tasks);

		StringBuilder sb = new StringBuilder();
		sb.append("CJ");
		Task cameron = tasks.get(0);
		Task jamie = tasks.get(1);
		for (int i = 2; i < tasks.size(); i++) {
			Task t = tasks.get(i);

			if (cameron.end <= t.start) {
				sb.append("C");
			} else if (jamie.end <= t.start) {
				sb.append("J");
			} else {
				return "IMPOSSIBLE";
			}
		}

		return sb.toString();
	}

	private static class Task implements Comparable<Task> {
		int start;
		int end;

		public Task(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Task other) {
			if (this.start == other.start) {
				return this.end - other.end;
			}
			return this.start - other.start;
		}
	}
}