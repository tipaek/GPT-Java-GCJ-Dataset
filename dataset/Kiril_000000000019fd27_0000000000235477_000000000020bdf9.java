import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		for (int i = 1; i <= t; i++) {
			System.out.println("Case #" + i + ": " + solution(s));
		}
	}

	private static String solution(Scanner s) {
		int n = s.nextInt();
		PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> {
			int c = Integer.compare(a[0], b[0]);
			if (c == 0) {
				c = Integer.compare(a[1], b[1]);
			}
			return c;
		});

		for (int i = 0; i < n; i++) {
			int[] event = new int[] { s.nextInt(), s.nextInt(), i };
			queue.add(event);
		}

		char[] person = new char[n];
		int[] cameron = null;
		int[] jamie = null;
		while (!queue.isEmpty()) {
			int[] event = queue.poll();
			if (isNotOverlap(cameron, event)) {
				person[event[2]] = 'C';
				cameron = event;
			} else if (isNotOverlap(jamie, event)) {
				person[event[2]] = 'J';
				jamie = event;
			} else {
				return "IMPOSSIBLE";
			}
		}

		return String.valueOf(person);
	}

	private static boolean isNotOverlap(int[] current, int[] event) {
		if (current == null) {
			return true;
		}
		int left = Math.max(current[0], event[0]);
		int right = Math.min(current[1], event[1]);
		return left >= right;
	}

}
