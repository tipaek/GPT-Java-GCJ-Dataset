import java.io.*;
import java.util.*;

class Solution {

	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int testCases = Integer.parseInt(br.readLine());

			for (int t = 0; t < testCases; t++) {
				int n = Integer.parseInt(br.readLine());
				int[][] intervals = new int[n][2];
				int[][] originalIntervals = new int[n][2];

				for (int i = 0; i < n; i++) {
					String[] parts = br.readLine().split(" ");
					intervals[i][0] = Integer.parseInt(parts[0]);
					intervals[i][1] = Integer.parseInt(parts[1]);
					originalIntervals[i][0] = intervals[i][0];
					originalIntervals[i][1] = intervals[i][1];
				}

				Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));

				Map<Integer, String> schedule = new HashMap<>();
				StringBuilder result = new StringBuilder();
				int cEnd = 0;
				int jEnd = 0;
				boolean possible = true;

				for (int i = 0; i < n; i++) {
					if (intervals[i][0] >= cEnd) {
						schedule.put(i, "C");
						cEnd = intervals[i][1];
					} else if (intervals[i][0] >= jEnd) {
						schedule.put(i, "J");
						jEnd = intervals[i][1];
					} else {
						possible = false;
						break;
					}
				}

				if (!possible) {
					System.out.println("Case #" + (t + 1) + ": IMPOSSIBLE");
				} else {
					for (int i = 0; i < n; i++) {
						int start = originalIntervals[i][0];
						int end = originalIntervals[i][1];
						for (int j = 0; j < n; j++) {
							if (start == intervals[j][0] && end == intervals[j][1]) {
								result.append(schedule.get(j));
								break;
							}
						}
					}
					System.out.println("Case #" + (t + 1) + ": " + result.toString());
				}
			}
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}
}