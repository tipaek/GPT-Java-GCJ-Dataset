import java.io.*;
import java.util.*;

public class Solution {

    private static final String IMPOSSIBLE = "IMPOSSIBLE";

	public static void main(String[] args) {
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = sc.nextInt();
		for (int i = 1; i <= t; i++) {
			int n = sc.nextInt();
			List<int[]> tasks = new ArrayList<>(n);
			for (int j = 0; j < n; j++) {
				tasks.add(new int[] { sc.nextInt(), sc.nextInt() });
			}
			Comparator<int[]> comparator = Comparator.comparingInt(task -> task[0]);
			comparator = comparator.thenComparingInt(task -> task[1]);
			tasks.sort(comparator);
			char[] result = new char[n];
			int[] camLastTask = tasks.get(0);
			result[0] = 'C';
			for (int j = 1; j < n; j++) {
				int[] task = tasks.get(j);
				if (camLastTask[1] <= task[0]) {
					result[j] = 'C';
					camLastTask = task;
				} else {
					result[j] = 'J';
				}
			}
			for (int j = 0; j < n - 1; j++) {
				if ((result[j] == result[j + 1]) && (tasks.get(j)[1] > tasks.get(j + 1)[0])) {
					result = IMPOSSIBLE.toCharArray();
					break;
				}
			}
			System.out.println(String.format("Case #%d: %s", i, String.valueOf(result)));
		}
	}
}
