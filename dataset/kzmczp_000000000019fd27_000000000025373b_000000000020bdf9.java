import java.io.*;
import java.util.*;

public class Solution {

	private static final String IMPOSSIBLE = "IMPOSSIBLE";

	public static void main(String[] args) {
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = sc.nextInt();
		for (int i = 1; i <= t; i++) {
			int n = sc.nextInt();
			PriorityQueue<int[]> ranges = new PriorityQueue<>(n, new RangeComparator());
			for (int j = 0; j < n; j++) {
				int s = sc.nextInt();
				int e = sc.nextInt();
				ranges.add(new int[] { s, e });
			}
			char[] result = new char[n];
			int k = 0;
			while (!ranges.isEmpty()) {
				int[] c = ranges.poll();
				result[k++] = 'C';
				List<int[]> jam = new ArrayList<>();
				while (!ranges.isEmpty() && ranges.peek()[0] < c[1]) {
					jam.add(ranges.poll());
					result[k++] = 'J';
				}
				boolean overlapping = false;
				for (int j = 0; j < jam.size() - 1; j++) {
					if (jam.get(j)[1] > jam.get(j + 1)[0]) {
						overlapping = true;
						break;
					}
				}
				if (overlapping) {
					result = IMPOSSIBLE.toCharArray();
					break;
				}
			}
			System.out.println(String.format("Case #%d: %s", i, String.valueOf(result)));
		}
	}

	private static class RangeComparator implements Comparator<int[]> {

		@Override
		public int compare(int[] o1, int[] o2) {
			if (o1[0] == o2[0]) {
				return Integer.compare(o1[1], o2[1]);
			}
			return Integer.compare(o1[0], o2[0]);
		}
	}
}