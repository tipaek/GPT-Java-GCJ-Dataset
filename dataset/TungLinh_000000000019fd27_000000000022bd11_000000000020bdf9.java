
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {

	private static final int MAX_TIME = 24 * 60;

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		for (int i = 1; i <= t; ++i) {
			int n = in.nextInt();
			solve(i, n, in);
		}
		in.close();
		return;
	}

	private static void solve(int testCase, int n, Scanner in) {

		int[] Cameron = new int[MAX_TIME];
		int[] Jamie = new int[MAX_TIME];
		char[] schedule = new char[n];

		Arrays.fill(Cameron, 0);
		Arrays.fill(Jamie, 0);

		List<Task> tasks = new ArrayList<Task>();
		for (int i = 0; i < n; i++) {
			int start = in.nextInt();
			int end = in.nextInt();

			Task task = new Task(start, end, i);
			tasks.add(task);
		}

		tasks.sort((t1, t2) -> Integer.compare(t1.start, t2.start));
		for (Task task : tasks) {
			int start = task.start;
			int end = task.end;
			int index = task.index;

			if (Cameron[start] == 0) {
				Arrays.fill(Cameron, start, end, 1);
				schedule[index] = 'C';
			} else if (Jamie[start] == 0) {
				Arrays.fill(Jamie, start, end, 1);
				schedule[index] = 'J';
			} else {
				System.out.println("Case #" + testCase + ": IMPOSSIBLE");
				return;
			}
		}

		System.out.println("Case #" + testCase + ": " + new String(schedule));
	}

	private static class Task {
		int start, end;
		int index;

		public Task(int _start, int _end, int _index) {
			this.start = _start;
			this.end = _end;
			this.index = _index;
		}
	}
}