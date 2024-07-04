import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	private static final class Task implements Comparable<Task> {
		int idx;
		int startTime;
		int endTime;

		public Task(int idx, int startTime, int endTime) {
			this.idx = idx;
			this.startTime = startTime;
			this.endTime = endTime;
		}

		@Override
		public int compareTo(Task o) {
			int res = startTime - o.startTime;
			if (res == 0) {
				res = endTime - o.endTime;
			}
			return res;
		}
	}

	public static void main(String[] args) {
		try (Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
			int numOfTestCases = scan.nextInt();
			for (int i = 1; i <= numOfTestCases; ++i) {
				int numOfTasks = scan.nextInt();
				System.out.println("Case #" + i + ": " + solve(scan, numOfTasks));
			}
		}
	}

	private static String solve(Scanner scan, int numOfTasks) {
		Task[] tasks = new Task[numOfTasks];
		for (int i = 0; i < numOfTasks; ++i) {
			tasks[i] = new Task(i, scan.nextInt(), scan.nextInt());
		}
		Arrays.parallelSort(tasks);
		char[] schedule = new char[numOfTasks];
		int jamieIsFreeAt = 0;
		int cameronIsFreeAt = 0;
		for (Task task : tasks) {
			if (task.startTime >= jamieIsFreeAt) {
				schedule[task.idx] = 'J';
				jamieIsFreeAt = task.endTime;
			} else if (task.startTime >= cameronIsFreeAt) {
				schedule[task.idx] = 'C';
				cameronIsFreeAt = task.endTime;
			} else {
				return "IMPOSSIBLE";
			}
		}
		return new String(schedule);
	}
}
