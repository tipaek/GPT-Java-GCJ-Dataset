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
			String[] inputs = new String[n];
			for (int j = 0; j < n; j++) {
				inputs[j] = br.readLine().trim();
			}
			List<JobTask> jTasks = new ArrayList<>();
			List<JobTask> cTasks = new ArrayList<>();
			boolean assign = true;
			for (int j = 0; j < n; j++) {
				String[] input = inputs[i].split(" ");
				int start;
				int end;
				if (input.length != 1) {
					start = Integer.parseInt(input[0]);
					end = Integer.parseInt(input[1]);
				} else {
					assign = false;
					break;
				}
				for (JobTask task : jTasks) {
					if (task.start == start || (start > task.start && start < task.end)
							|| (end > task.start && end < task.end)) {
						assign = false;
						break;
					}
				}
				if (assign) {
					jTasks.add(new JobTask(start, end));
					sb.append("J");
					continue;
				}
				assign = true;
				for (JobTask task : cTasks) {
					if (task.start == start || (start > task.start && start < task.end)
							|| (end > task.start && end < task.end)) {
						assign = false;
						break;
					}
				}
				if (assign) {
					cTasks.add(new JobTask(start, end));
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

class JobTask {
	int start;
	int end;

	JobTask(int start, int end) {
		this.start = start;
		this.end = end;
	}
}
