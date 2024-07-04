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

			int[] dx = {0,0,1,-1,0};
			int[] dy = {1,-1,0,0,0};

			int[][] points = new int[M.length() + 1][2];
			points[0][0] = 1000 + X;
			points[0][1] = 1000 + Y;
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
			}

			Queue<int[]> queue = new LinkedList<>();
			int[] start = new int[]{1000,1000,0};
			boolean[][] visit = new boolean[2001][2001];
			visit[1000][1000] = true;
			// x y time
			queue.add(start);
			int ans = Integer.MAX_VALUE;
			while(!queue.isEmpty()) {
				int[] cur = queue.poll();

				if (cur[0] == points[cur[2]][0] && cur[1] == points[cur[2]][1]) {
					ans = Math.min(ans, cur[2]);
					break;
				}

				for (int d = 0; d < 5; d++) {
					int tx = cur[0] + dx[d];
					int ty = cur[1] + dy[d];

					if (d == 4) {
						for (int i = cur[2]; i <= M.length(); i++) {
							if (cur[0] == points[i][0] && cur[1] == points[i][1]) {
								ans = Math.min(ans, i);
								queue.poll();
								break;
							}
						}
					}
					else if (tx >= 0 && ty >= 0 && cur[2] + 1 <= M.length() && !visit[tx][ty]) {
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