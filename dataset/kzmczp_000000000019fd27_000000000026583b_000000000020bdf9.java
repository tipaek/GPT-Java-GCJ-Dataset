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
			tasks.sort(Comparator.comparingInt(task -> task[0]));
			char[] result = new char[n];
			int[] camLastTask = tasks.get(0);
			result[0] = 'C';
			for (int j = 1; j < n; j++) {
				int[] task = tasks.get(j);
				if (camLastTask[1] <= task[0]) {
					result[j] = 'C';
					camLastTask = task;
				} else {
					if (tasks.get(j - 1)[1] > task[0] && result[j - 1] == 'J') {
						result = IMPOSSIBLE.toCharArray();
						break;
					}
					result[j] = 'J';
				}
			}
			System.out.println(String.format("Case #%d: %s", i, String.valueOf(result)));
		}
	}
}
