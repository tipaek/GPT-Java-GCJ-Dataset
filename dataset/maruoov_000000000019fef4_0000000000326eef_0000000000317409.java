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

			int[][] points = new int[1001][1001];
			points[X][Y] = 0;
			int cnt = 1;
			for (int i = 1; i <= M.length(); i++) {
				if (M.charAt(i - 1) == 'N') {
					Y++;
				} else if (M.charAt(i - 1) == 'S') {
					Y--;
				} else if (M.charAt(i - 1) == 'E') {
					X++;
				} else if (M.charAt(i - 1) == 'W') {
					X--;
				}

				if (X < 0) X = 1000;
				if (X > 1000) X = 0;
				if (Y < 0) Y = 1000;
				if (Y > 1000) Y = 0;
				points[X][Y] = cnt++;
			}

			Queue<int[]> queue = new LinkedList<>();
			int[] start = new int[]{0,0,0};
			boolean[][] visit = new boolean[1001][12001];
			visit[0][0] = true;
			// x y time
			queue.add(start);
			int ans = Integer.MAX_VALUE;
			while(!queue.isEmpty()) {
				int[] cur = queue.poll();

				if (points[cur[0]][cur[1]] > 0 && cur[2] <= points[cur[0]][cur[1]]) {
					ans = Math.min(ans, points[cur[0]][cur[1]]);
					continue;
				}

				for (int d = 0; d < 4; d++) {
					int tx = cur[0] + dx[d];
					int ty = cur[1] + dy[d];

					if (tx < 0) tx = 1000;
					if (tx > 1000) tx = 0;
					if (ty < 0) ty = 1000;
					if (ty > 1000) ty = 0;

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