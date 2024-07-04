import java.io.*;
import java.util.*;

public class Solution {

    private static final String IMPOSSIBLE = "IMPOSSIBLE";

	public static void main(String[] args) {
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = sc.nextInt();
		for (int i = 1; i <= t; i++) {
			int n = sc.nextInt();
			List<Task> tasks = new ArrayList<>(n);
			for (int j = 0; j < n; j++) {
				tasks.add(new Task(j, new int[] { sc.nextInt(), sc.nextInt() }));
			}
			tasks.sort(Comparator.comparingInt(task -> task.time[0]));
			Task camLastTask = tasks.get(0);
			camLastTask.assignee = 'C';
			int camLastTaskEndTime = camLastTask.time[1];
			boolean impossible = false;
			for (int j = 1; j < n; j++) {
				Task task = tasks.get(j);
				if (camLastTaskEndTime <= task.time[0]) {
					task.assignee = 'C';
					camLastTaskEndTime = task.time[1];
				} else {
					Task prev = tasks.get(j - 1);
					if (prev.assignee == 'J' && prev.time[1] > task.time[0]) {
						impossible = true;
						break;
					}
					task.assignee = 'J';
				}
			}
			if (impossible) {
				System.out.println(String.format("Case #%d: %s", i, IMPOSSIBLE));
				continue;
			}
			tasks.sort(Comparator.comparingInt(tsk -> tsk.id));
			StringBuilder builder = new StringBuilder();
			for (Task tsk : tasks) {
				builder.append(tsk.assignee);
			}
			System.out.println(String.format("Case #%d: %s", i, builder.toString()));
		}
	}

	private static class Task {

		private final int id;
		private final int[] time;
		private char assignee;

		private Task(int id, int[] time) {
			this.id = id;
			this.time = time;
		}
	}
}
