import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			StringBuilder sb = new StringBuilder();
			int n = Integer.parseInt(br.readLine());
			Map<Integer, Integer> jMap = new HashMap<>();
			Map<Integer, Integer> cMap = new HashMap<>();
			// List<JobTask> jTasks = new ArrayList<>();
			// List<JobTask> cTasks = new ArrayList<>();
			boolean assign = true;
			for (int j = 0; j < n; j++) {
				String[] input = br.readLine().trim().split(" ");
				int start = Integer.parseInt(input[0]);
				int end = Integer.parseInt(input[1]);
				for (Entry<Integer, Integer> task : jMap.entrySet()) {
					if (task.getKey() == start || (start > task.getKey() && start < task.getValue())
							|| (end > task.getKey() && end < task.getValue())) {
						assign = false;
						break;
					}
				}
				if (assign) {
					jMap.put(start, end);
					sb.append("J");
					continue;
				}
				assign = true;
				for (Entry<Integer, Integer> task : cMap.entrySet()) {
					if (task.getKey() == start || (start > task.getKey() && start < task.getValue())
							|| (end > task.getKey() && end < task.getValue())) {
						assign = false;
						break;
					}
				}
				if (assign) {
					cMap.put(start, end);
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