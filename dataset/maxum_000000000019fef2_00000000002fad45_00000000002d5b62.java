import java.util.*;
import java.io.*;


public class Solution {

	public static final int[] posX = new int[] {0, 0, -1, 1};
	public static final int[] posY = new int[] {1, -1, 0, 0};
	public static final char[] dir = new char[] {'N', 'S', 'W', 'E'};

	class Tup {
		int[] coor;
		String x;

		public Tup(int[] coor, String x) {
			this.x = new String(x);
			this.coor = coor;
		}
	}


	public static String computeRes(int x, int y) {

		Deque<Tup> queue = new ArrayDeque<>();
		queue.offer(new Solution().new Tup(new int[] {0,0}, ""));

		int max_depth = 8;
		int depth = 0;

		while (!queue.isEmpty() && depth < max_depth) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				Tup curr = queue.poll();
				int cx = curr.coor[0];
				int cy = curr.coor[1];
				int step = 1 << depth;

				if (cx == x && cy == y) {
					return curr.x;
				}


				for (int z = 0; z < 4; z++) {
					int[] new_coor = new int[] {cx + posX[z]*step, cy + posY[z]*step};
					queue.offer(new Solution().new Tup(new_coor, curr.x + Character.toString(dir[z])));
				}
			}

			depth++;
		}





		return "IMPOSSIBLE";
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(
				new InputStreamReader(System.in)));

		int T = in.nextInt();
		for (int i = 1; i <= T; i++) {
			int x = in.nextInt();
			int y = in.nextInt();
			System.out.println("Case #" + i + ": " + computeRes(x, y));
		}


	}


}
