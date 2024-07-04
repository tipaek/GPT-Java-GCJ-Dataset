import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int tc = scan.nextInt();
		for (int test_case = 1; test_case <= tc; test_case++) {

			int x = scan.nextInt();
			int y = scan.nextInt();

			Queue<Direction> q = new LinkedList<Direction>();
			q.add(new Direction(0, 0, ""));
			Direction result = null;
			int move = 1;
			int diff = 0;
			int mcount = 1;

			while (!q.isEmpty()) {
				int size = q.size();
				for (int i = 0; i < size; i++) {
					Direction cur = q.poll();

					if (cur.x == x && cur.y == y) {
						result = cur;
						q.clear();
						break;
					}

					if (Math.abs(cur.x - x) > diff) {
						q.add(new Direction(cur.x + move, cur.y, cur.result + 'E'));
						q.add(new Direction(cur.x - move, cur.y, cur.result + 'W'));
					}

					if (Math.abs(cur.y - y) > diff) {
						q.add(new Direction(cur.x, cur.y + move, cur.result + 'N'));
						q.add(new Direction(cur.x, cur.y - move, cur.result + 'S'));
					}
				}
				diff = move;
				move *= 2;

				if (mcount < 28) {
					mcount++;
				} else {
					q.clear();
				}
			}

			if (result == null) {
				System.out.println("Case #" + test_case + ": IMPOSSIBLE");
			} else {
				System.out.println("Case #" + test_case + ": " + result.result);
			}

		}
	}

	public static class Direction {
		int x, y;
		String result;

		public Direction(int x, int y, String result) {
			this.x = x;
			this.y = y;
			this.result = result;
		}
	}
}
