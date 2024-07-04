import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Node {
	int x;
	int y;
	int it;
	String ret;

	Node(int x, int y, int it, String ret) {
		this.x = x;
		this.y = y;
		this.it = it;
		this.ret = ret;
	}
}

public class Solution {
	static boolean isSafe(int sx, int sy, int ex, int ey) {
		int max = 2 * (Math.max(Math.abs(ex), Math.abs(ey)));
		return Math.abs(sx) > max || Math.abs(sy) > max;
	}

	static String bfs(int sx, int sy, int ex, int ey) {
		int[] x = { 1, -1, 0, 0 };
		int[] y = { 0, 0, 1, -1 };
		String[] dir = { "E", "W", "N", "S" };

		Queue<Node> qu = new LinkedList<>();
		qu.add(new Node(sx, sy, 1, ""));
		while (!qu.isEmpty()) {
			Node node = qu.poll();
			if (node.x == ex && node.y == ey)
				return node.ret;
			int jump = node.it;
			for (int i = 0; i < x.length; i++) {
				int rx = node.x + x[i] * jump;
				int ry = node.y + y[i] * jump;
				if (!isSafe(rx, ry, ex, ey))
					qu.add(new Node(rx, ry, node.it * 2, new String(node.ret + dir[i])));
			}
		}
		return "IMPOSSIBLE";
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		for (int t = 1; t <= test; t++) {
			String[] str = br.readLine().split(" ");
			int x = Integer.parseInt(str[0]);
			int y = Integer.parseInt(str[1]);
			String answer = bfs(0, 0, x, y);
			System.out.println("Case #" + t + ": " + answer);
		}
	}

}