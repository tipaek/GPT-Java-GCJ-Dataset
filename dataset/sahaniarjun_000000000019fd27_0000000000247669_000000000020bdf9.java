import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			StringBuilder sb = new StringBuilder();
			int n = Integer.parseInt(br.readLine());
			List<Task> jTasks = new ArrayList<>();
			List<Task> cTasks = new ArrayList<>();
			boolean assign = true;
			for (int j = 0; j < n; j++) {
				String[] input = br.readLine().trim().split(" ");
				int start = Integer.parseInt(input[0]);
				int end = Integer.parseInt(input[1]);
				for (Task task : jTasks) {
					if (task.start == start || (start > task.start && start < task.end)
							|| (end > task.start && end < task.end)) {
						assign = false;
						break;
					}
				}
				if (assign) {
					jTasks.add(new Task(start, end));
					sb.append("J");
					continue;
				}
				assign = true;
				for (Task task : cTasks) {
					if (task.start == start || (start > task.start && start < task.end)
							|| (end > task.start && end < task.end)) {
						assign = false;
						break;
					}
				}
				if (assign) {
					cTasks.add(new Task(start, end));
					sb.append("C");
					continue;
				} else {
					break;
				}

			}

			System.out.println("Case #" + (i + 1) + ": " + (assign ? sb.toString() : "IMPOSSIBLE"));

		}
	}

}

class Task {
	int start;
	int end;

	Task(int start, int end) {
		this.start = start;
		this.end = end;
	}
}
