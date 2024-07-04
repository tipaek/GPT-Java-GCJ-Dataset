import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		List<TreeMap<int[], Integer>> list = new LinkedList<>();
		for (int i = 0; i < T; i++) {
			int N = sc.nextInt();
			TreeMap<int[], Integer> data = new TreeMap<>((o1, o2) -> {
				if (o1[0] >= o2[0]) {
					return 1;
				} else if (o1[0] < o2[0]) {
					return -1;
				}
				return 0;
			});
			for (int j = 0; j < N; j++) {
				int a[] = new int[2];
				a[0] = sc.nextInt();
				a[1] = sc.nextInt();
				data.put(a, j);
			}
			list.add(data);
		}
		int index;
		for (int i = 0; i < list.size(); i++) {
			String output = getScheduledActivities(list.get(i));
			index = i + 1;
			System.out.println("Case #" + index + ": " + output);
		}
	}

	public static String getScheduledActivities(TreeMap<int[], Integer> starting) {
		char[] ansArray = new char[starting.size()];
		int previousCompletionC = -1;
		int previousCompletionJ = -1;
		for (Map.Entry<int[], Integer> entry : starting.entrySet()) {
			if (previousCompletionC <= entry.getKey()[0]) {
				ansArray[entry.getValue()] = 'C';
				previousCompletionC = entry.getKey()[1];
			} else if (previousCompletionJ <= entry.getKey()[0]) {
				ansArray[entry.getValue()] = 'J';
				previousCompletionJ = entry.getKey()[1];
			} else {
				return "IMPOSSIBLE";
			}
		}
		return String.valueOf(ansArray);
	}
}
