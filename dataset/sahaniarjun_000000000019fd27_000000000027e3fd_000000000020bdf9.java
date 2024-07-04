import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		boolean nonFirst = false;
		boolean current = false;
		for (int i = 0; i < t; i++) {
			StringBuilder sb = new StringBuilder();
			int n = Integer.parseInt(br.readLine());
			JobTask[] inputs = new JobTask[n];
			for (int j = 0; j < n; j++) {
				String[] input = br.readLine().split(" ");
				inputs[j] = new JobTask(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
			}
			// Arrays.sort(inputs);
			List<JobTask> jTasks = new ArrayList<>();
			List<JobTask> cTasks = new ArrayList<>();
			boolean nConflict = true;
			for (int j = 0; j < n; j++) {
				int start = inputs[j].start;
				int end = inputs[j].end;

				if (start < 0 || start > 1440 || end < start || end < 0 || end > 1440) {
					nConflict = false;
					break;
				}

				for (int k = 0; k < 2; k++) {
					nConflict = noConflict(start, end, current ? jTasks : cTasks);
					if (nConflict) {
						(current ? jTasks : cTasks).add(new JobTask(start, end));
						sb.append(current ? "J" : "C");
						break;
					}
					current = !current;
				}
				if (!nConflict)
					break;

			}
			if (nonFirst)
				System.out.println();
			else
				nonFirst = true;

			System.out.print("Case #" + (i + 1) + ": " + (nConflict ? sb.toString() : "IMPOSSIBLE"));

		}
	}

	private static boolean noConflict(int start, int end, List<JobTask> Tasks) {
		for (JobTask task : Tasks) {
			if (task.start == start || (start > task.start && start < task.end)
					|| (end >= task.start && end < task.end)) {
				return false;
			}
		}
		return true;
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
