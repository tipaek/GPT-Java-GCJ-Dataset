import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		Map<TreeMap<Integer, Integer>, int[]> data = new HashMap<>();
		for (int i = 0; i < T; i++) {
			int N = sc.nextInt();
			TreeMap<Integer, Integer> starting = new TreeMap<>();

			int[] ending = new int[N];
			for (int j = 0; j < N; j++) {
				int a[] = new int[2];
				a[0] = sc.nextInt();
				ending[j] = sc.nextInt();
				starting.put(a[0], j);
			}
			data.put(starting, ending);

		}
		int index = 1;
		for (Map.Entry<TreeMap<Integer, Integer>, int[]> entry : data.entrySet()) {
			String output = getScheduledActivities(entry.getKey(), entry.getValue());
			System.out.println("Case #" + index + ": " + output);
			index++;
		}
	}

	public static String getScheduledActivities(TreeMap<Integer, Integer> starting, int[] ending) {
		char[] ansArray = new char[ending.length];
		int previousCompletionC = -1;
		int previousCompletionJ = -1;
		for (Map.Entry<Integer, Integer> entry : starting.entrySet()) {
			if (previousCompletionC <= entry.getKey()) {
				ansArray[entry.getValue()] = 'C';
				previousCompletionC = ending[entry.getValue()];
			} else if (previousCompletionJ <= entry.getKey()) {
				ansArray[entry.getValue()] = 'J';
				previousCompletionJ = ending[entry.getValue()];
			} else {
				return "IMPOSSIBLE";
			}
		}
		return String.valueOf(ansArray);
	}
}
