
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Task implements Comparable<Task> {
	public Task(int id, int start, int end) {
		super();
		this.id = id;
		this.start = start;
		this.end = end;
	}

	int id;
	int start = 0;
	int end = 0;
	String who = "";

	@Override
	public int compareTo(Task t) {
		return this.start - t.start;
	}
}

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int i = 1; i <= t; ++i) {
			String result = "";
			int noOfIntervals = in.nextInt();
			List<Task> orgTasks = new ArrayList<Task>();
			List<Task> tasks = new ArrayList<Task>();

			for (int k = 0; k < noOfIntervals; k++) {
				int start = in.nextInt();
				int end = in.nextInt();
				Task task = new Task(i, start, end);
				orgTasks.add(task);
				tasks.add(task);
			}

			Collections.sort(tasks);

			int C_end = 0;
			int J_end = 0;

			for (int indx = 0; indx < tasks.size(); indx++) {
				Task task = tasks.get(indx);
				if (task.start >= C_end) {
					C_end = task.end;
					task.who = "C";
				} else if (task.start >= J_end) {
					J_end = task.end;
					task.who = "J";
				} else {
					result = "IMPOSSIBLE";
					break;
				}
			}

			if (!result.equals("IMPOSSIBLE")) {
				for (Task t1 : orgTasks) {
					result += t1.who;
				}
			}
			System.out.println("Case #" + i + ": " + result);
		}
	}

}
