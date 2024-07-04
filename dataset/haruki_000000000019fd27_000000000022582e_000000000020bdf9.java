import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] arg) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		for (int tt = 1; tt <= t; tt++) {
			int n = sc.nextInt();
			List<int[]> activities = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				activities.add(new int[] { sc.nextInt(), sc.nextInt() });
			}
			Collections.sort(activities, (a, b) -> a[0] - b[0]);

			StringBuilder sb = new StringBuilder();
			int prev1 = 0, prev2 = 0;
			for (int[] act : activities) {
				if (act[0] < prev1 && act[0] < prev2) {
					sb.setLength(0);
					sb.append("IMPOSSIBLE");
					break;
				}
				if (act[0] >= prev1) {
					sb.append("C");
					prev1 = act[1];
					continue;
				}
				if (act[0] >= prev2) {
					sb.append("J");
					prev2 = act[1];
					continue;
				}
			}

			System.out.println("Case #" + tt + ": " + sb.toString());
		}
	}
}