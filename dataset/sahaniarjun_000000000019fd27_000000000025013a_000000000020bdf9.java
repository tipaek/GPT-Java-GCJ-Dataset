import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			try {
				StringBuilder sb = new StringBuilder();
				int n = Integer.parseInt(br.readLine());

				List<JobTask> jTasks = new ArrayList<>();
				List<JobTask> cTasks = new ArrayList<>();
				boolean assign = true;
				for (int j = 0; j < n; j++) {
					String[] input = br.readLine().trim().split(" ");
					int start = Integer.parseInt(input[0]);
					int end = Integer.parseInt(input[1]);
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
			} catch (NoSuchElementException e) {
				System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
			}
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
