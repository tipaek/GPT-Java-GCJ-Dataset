import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.stream.Collectors;

public abstract class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt(); 
		for (int i = 1; i <= t; ++i) {
			String solution = "";
			int n = in.nextInt();
			Integer[] overlaps = new Integer[1440];
			Arrays.fill(overlaps, 0);
			Map<Integer, Integer> beginTimes = new HashMap<Integer, Integer>();
			Map<Integer, Integer> endTimes = new HashMap<Integer, Integer>();
			for (int j = 0; j < n; j++) {
				int beginTime = in.nextInt();
				int endTime = in.nextInt();
				beginTimes.put(j, beginTime);
				endTimes.put(j, endTime);
				for (int k = beginTime; k < endTime; k++) {
					overlaps[k] = overlaps[k] + 1;
				}
			}
			List<Integer> overlapList = Arrays.asList(overlaps);
			for (int j = 3; j <= n; j++) {
				if (overlapList.contains(j)) {
					solution = "IMPOSSIBLE";
					break;
				}
			}
			if (!solution.equals("IMPOSSIBLE") && !overlapList.contains(2)) {
				solution = "J";
				for (int k = 1; k < n; k++) {
					solution = solution + "J";
				}
			} else if (!solution.equals("IMPOSSIBLE")) {
				Map<Integer, String> assignments = new HashMap<Integer, String>();
				int endTime = - 1;
				String lastAssignment = "J";
				Map<Integer, Integer> sortedMap = 
					     beginTimes.entrySet().stream()
					    .sorted(Entry.comparingByValue())
					    .collect(Collectors.toMap(Entry::getKey, Entry::getValue,
					                              (e1, e2) -> e1, LinkedHashMap::new));
				for (int choreNumber: sortedMap.keySet()) {
					int beginTime = beginTimes.get(choreNumber);
					if (assignments.isEmpty()) {
						assignments.put(choreNumber, "J");
						endTime = endTimes.get(choreNumber);
					} else {
						if (beginTime >= endTime) {
							assignments.put(choreNumber, lastAssignment);
						} else if (lastAssignment.equals("J")) {
							assignments.put(choreNumber, "C");
							lastAssignment = "C";
						} else {
							assignments.put(choreNumber, "J");
							lastAssignment = "J";
						}
						endTime = endTimes.get(choreNumber);
					}
				}
				for (int j = 0; j < n; j++) {
					solution = solution + assignments.get(j);
				}
			}
			System.out.println("Case #" + i + ": " + solution);
		}
		in.close();
	}
}