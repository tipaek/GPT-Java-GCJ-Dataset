import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		List<TreeMap<Integer, Integer>> start = new LinkedList<>();
		List<int[]> end = new LinkedList<>();
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
			start.add(starting);
			end.add(ending);
		}
		int index;
		for (int i = 0; i < start.size(); i++) {
			String output = getScheduledActivities(start.get(i), end.get(i));
			index = i + 1;
			System.out.println("Case #" + index + ": " + output);
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
