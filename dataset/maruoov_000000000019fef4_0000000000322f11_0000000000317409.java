import java.util.*;

class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		int cn = 1;
		while(T > 0) {
			T--;
			int X = sc.nextInt();
			int Y = sc.nextInt();
			String M = sc.next();

			int[] dx = {0,1, 0,-1};
			int[] dy = {1,0,-1, 0};

			int[][] points = new int[M.length() + 1][2];
			points[0][0] = X;
			points[0][1] = Y;
			for (int i = 1; i <= M.length(); i++) {
				if (M.charAt(i - 1) == 'N') {
					points[i][0] = points[i - 1][0];
					points[i][1] = points[i - 1][1] + 1;
				} else if (M.charAt(i - 1) == 'S') {
					points[i][0] = points[i - 1][0];
					points[i][1] = points[i - 1][1] - 1;
				} else if (M.charAt(i - 1) == 'E') {
					points[i][0] = points[i - 1][0] + 1;
					points[i][1] = points[i - 1][1];
				} else if (M.charAt(i - 1) == 'W') {
					points[i][0] = points[i - 1][0] - 1;
					points[i][1] = points[i - 1][1];
				}

				if (points[i][0] < 0) points[i][0] = 1001;
				if (points[i][1] < 0) points[i][1] = 1001;
			}

			Queue<int[]> queue = new LinkedList<>();
			int[] start = new int[]{0,0,0};
			boolean[][] visit = new boolean[1001][1001];
			visit[0][0] = true;
			// x y time
			queue.add(start);
			int ans = Integer.MAX_VALUE;
			while(!queue.isEmpty()) {
				int[] cur = queue.poll();

				for (int i = cur[2]; i <= M.length(); i++) {
					if (ans < i) {
						break;
					}

					if (cur[0] == points[i][0] && cur[1] == points[i][1]) {
						ans = Math.min(ans, i);
						break;
					}
				}

				for (int d = 0; d < 4; d++) {
					int tx = cur[0] + dx[d];
					int ty = cur[1] + dy[d];

					if (tx < 0) tx = 1000 + tx;
					if (ty < 0) ty = 1000 + ty;

					if (tx >= 1001) tx = 1;
					if (ty >= 1001) ty = 1;

					if (cur[2] + 1 <= M.length() && !visit[tx][ty]) {
						queue.add(new int[]{tx, ty, cur[2] + 1});
						visit[tx][ty] = true;
					}
				}
			}

			if (ans == Integer.MAX_VALUE) {
				System.out.printf("Case #%d: IMPOSSIBLE%n", cn);
			} else {
				System.out.printf("Case #%d: %d%n", cn, ans);
			}
			cn++;
		}
	}
}