import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int testCount = scanner.nextInt();

		for (int i = 0; i < testCount; i++) {
			int activityCount = scanner.nextInt();
			Map<int[], Integer> map = new HashMap<>();
			for (int j = 0; j < activityCount; j++) {
				int[] activity = new int[2];
				activity[0] = scanner.nextInt();
				activity[1] = scanner.nextInt();
				map.put(activity, j);
			}
			String result = solve(map);
			System.out.println("Case #" + (i + 1) + ": " + result);
		}

	}

	private static String solve(Map<int[], Integer> values) {
		List<int[]> activities = new ArrayList<>(values.keySet());
		Collections.sort(activities, new Comparator<int[]>() {
			@Override public int compare(int[] activity1, int[] activity2) {
				return Integer.compare(activity1[0], activity2[0]);
			}
		});

		int c = 0;
		int j = 0;
		char[] result = new char[values.size()];
		for (int i = 0; i < activities.size(); i++) {
			int[] activity = activities.get(i);
			if (c <= activity[0]) {
				int index = values.get(activity);
				result[index] = 'C';
				c = activity[1];
			} else if (j <= activity[0]) {
				int index = values.get(activity);
				result[index] = 'J';
				j = activity[1];
			} else {
				return "IMPOSSIBLE";
			}
		}
		return new String(result);
	}

}
