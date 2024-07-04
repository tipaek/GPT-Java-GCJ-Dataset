import java.io.*;
import java.util.*;

public class Solution {

	private static final String IMPOSSIBLE = "IMPOSSIBLE";

	public static void main(String[] args) {
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = sc.nextInt();
		for (int i = 1; i <= t; i++) {
			int n = sc.nextInt();
			List<int[]> ranges = new ArrayList<>(n);
			for (int j = 0; j < n; j++) {
				ranges.add(new int[] { sc.nextInt(), sc.nextInt() });
			}
			ranges.sort(new RangeComparator());
			char[] result = new char[n];
			int[] c = ranges.get(0);
			result[0] = 'C';
			for (int j = 1; j < n; j++) {
				int[] r = ranges.get(j);
				if (c[1] <= r[0]) {
					result[j] = 'C';
					c = r;
				}
			}
			for (int j = 0; j < n; j++) {
				if (result[j] != 'C') {
					result[j] = 'J';
				}
			}
			for (int j = 0; j < n - 1; j++) {
				if ((result[j] == result[j + 1]) && (ranges.get(j)[1] > ranges.get(j + 1)[0])) {
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
