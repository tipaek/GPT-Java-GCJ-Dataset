import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		List<TreeMap<int[], Integer>> dataList = new LinkedList<>();
		int i = 0;
		while (i < T) {
			i++;
			TreeMap<int[], Integer> testCaseData = new TreeMap<>((object1, object2) -> {
				if (object1[0] >= object2[0]) {
					return 1;
				} else if (object1[0] < object2[0]) {
					return -1;
				}
				return 0;
			});
			int N = sc.nextInt();
			for (int activityIndex = 0; activityIndex < N; activityIndex++) {
				int activityTiming[] = new int[2];
				activityTiming[0] = sc.nextInt(); // start time
				activityTiming[1] = sc.nextInt(); // end time
				testCaseData.put(activityTiming, activityIndex);
			}
			dataList.add(testCaseData);
		}
		int index;
		for (int j = 0; j < dataList.size(); j++) {
			index = j + 1;
			String output = getScheduledTasksIfPossible(dataList.get(j));
			System.out.println("Case #" + index + ": " + output);
		}
	}

	public static String getScheduledTasksIfPossible(TreeMap<int[], Integer> testCaseData) {
		int lastActivityTimeCompletionC = -1;
		int lastActivityTimeCompletionJ = -1;
char[] ansArray = new char[testCaseData.size()];

		for (Map.Entry<int[], Integer> activityTimeEntry : testCaseData.entrySet()) {
			int startTime = activityTimeEntry.getKey()[0];
			int endTime = activityTimeEntry.getKey()[1];
			int activityIndex = activityTimeEntry.getValue();
			if (lastActivityTimeCompletionJ <= startTime) {
				ansArray[activityIndex] = 'J';
				lastActivityTimeCompletionJ = endTime;
			} else if (lastActivityTimeCompletionC <= startTime) {
				ansArray[activityIndex] = 'C';
				lastActivityTimeCompletionC = endTime;
			} else {
				return "IMPOSSIBLE";
			}
		}
		return String.valueOf(ansArray);
	}
}
