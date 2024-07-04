import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {

	private static final String IMPOSSIBLE = "IMPOSSIBLE";

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i = 1; i <= t; i++) {
			int n = sc.nextInt();
			PriorityQueue<int[]> ranges = new PriorityQueue<>(Comparator.comparingInt(r -> r[0]));
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
}
