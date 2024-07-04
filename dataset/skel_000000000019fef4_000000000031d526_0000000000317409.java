import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution{
	static class Point {
		int x;
		int y;
		int cnt;

		public Point(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}

	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int T = Integer.parseInt(br.readLine());
			int c = 0;
			int[][] mv = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
			while (T-- > 0) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int X = Integer.parseInt(st.nextToken());
				int Y = Integer.parseInt(st.nextToken());
				String move = st.nextToken();
				int l = move.length();
				int[][] map = new int[2001][2001];
				for (int i = 0; i < 2001; i++) {
					for (int j = 0; j < 2001; j++) {
						map[i][j] = -1;
					}
				}
				X += 1000;
				Y += 1000;
				map[Y][X] = 0;
				for (int i = 0; i < l; i++) {
					char now = move.charAt(i);
					switch (now) {
						case 'S':
							Y--;
							break;
						case 'N':
							Y++;
							break;
						case 'W':
							X--;
							break;
						case 'E':
							X++;
							break;
					}
					map[Y][X] = i + 1;
				}
				Queue<Point> q = new LinkedList<>();
				boolean isFound = false;
				int result = 987654321;
				boolean[][] check = new boolean[2001][2001];
				q.offer(new Point(1000, 1000, 0));
				while (!q.isEmpty()) {
					Point now = q.poll();
					if (map[now.x][now.y] != -1 && map[now.x][now.y] >= now.cnt) {
						result = Math.min(Math.max(map[now.x][now.y], now.cnt), result);
						isFound = true;
					}
					if (now.cnt == l + 1) break;
					for (int i = 0; i < 4; i++) {
						int rx = now.x + mv[i][0];
						int ry = now.y + mv[i][1];
						if (check[rx][ry]) continue;
						check[rx][ry] = true;
						q.offer(new Point(rx, ry, now.cnt + 1));
					}
				}
				if (isFound) {
					System.out.printf("Case #%d: %s\n", ++c, result);
					continue;
				}
				System.out.printf("Case #%d: %s\n", ++c, "IMPOSSIBLE");
			}
		} catch (IOException e) {

		}
	}
}
