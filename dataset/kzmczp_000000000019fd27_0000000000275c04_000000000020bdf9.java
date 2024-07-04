import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i = 1; i <= t; i++) {
			int n = sc.nextInt();
			PriorityQueue<int[]> ranges = new PriorityQueue<>(Comparator.comparingInt(r -> r[0]));
			for (int j = 0; j < n; j++) {
				int s = sc.nextInt();
				int e = sc.nextInt();
				ranges.add(new int[] { s, e, j });
			}
			char[] result = new char[n];
			int[] order = new int[n];
			int k = 0;
			boolean overlapping = false;
			while (!ranges.isEmpty()) {
				overlapping = false;
				int[] c = ranges.poll();
				result[k] = 'C';
				order[k++] = c[2];
				List<int[]> jam = new ArrayList<>();
				while (!ranges.isEmpty() && ranges.peek()[0] < c[1]) {
					int[] poll = ranges.poll();
					jam.add(poll);
					result[k] = 'J';
					order[k++] = poll[2];
				}
				for (int j = 0; j < jam.size() - 1; j++) {
					if (jam.get(j)[1] > jam.get(j + 1)[0]) {
						overlapping = true;
						break;
					}
				}
			}
			if (overlapping) {
				System.out.println(String.format("Case #%d: IMPOSSIBLE", i));
				continue;
			}
			Answer[] ans = new Answer[n];
			for (int j = 0; j < n; j++) {
				ans[j] = new Answer(order[j], result[j]);
			}
			Arrays.sort(ans, Comparator.comparingInt(a -> a.id));
			StringBuilder builder = new StringBuilder();
			for (int j = 0; j < n; j++) {
				builder.append(ans[j].assignee);
			}
			System.out.println(String.format("Case #%d: %s", i, builder.toString()));
		}
	}

	private static class Answer {

		private final int id;
		private final char assignee;

		private Answer(int id, char assignee) {
			this.id = id;
			this.assignee = assignee;
		}
	}
}
