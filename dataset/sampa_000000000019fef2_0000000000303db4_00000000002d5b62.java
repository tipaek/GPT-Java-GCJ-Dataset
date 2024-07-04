import java.util.*;

public class Solution {

	private static class Node {
		int x;
		int y;
		int cv;
		char c;
		Node prev;

		public Node(int px, int py, int pcv, char pc, Node pprev) {
			x = px; y = py; cv = pcv;
			c = pc;
			prev = pprev;
		}
	}

	private static int max = 1 << 30;
	private static String solve(int X, int Y) {
		if (Math.abs(X) == Math.abs(Y)) {
			return "IMPOSSIBLE";
		}

		LinkedList<Node> Q = new LinkedList();
		Q.add(new Node(0, 0, 1, '\0', null));

		while (!Q.isEmpty()) {
			Node n = Q.removeFirst();
			//System.err.println(n.x + ", " + n.y + "; " + n.cv + " <= " + max);

			if (n.x == X && n.y == Y) {
				StringBuffer sb = new StringBuffer();
				while (n.prev != null) {
					sb.insert(0, n.c);
					n = n.prev;
				}

				return sb.toString();
			}

			if (n.cv <= max) {
				Q.add(new Node(n.x+n.cv, n.y, n.cv<<1, 'E', n));
				Q.add(new Node(n.x-n.cv, n.y, n.cv<<1, 'W', n));

				Q.add(new Node(n.x, n.y+n.cv, n.cv<<1, 'N', n));
				Q.add(new Node(n.x, n.y-n.cv, n.cv<<1, 'S', n));
			}
		}

		return "IMPOSSIBLE";
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		int T = s.nextInt();
		for(int i = 1; i <= T; i++) {
			int X = s.nextInt();
			int Y = s.nextInt();

			System.out.println("Case #" + i + ": " + solve(X, Y));
		}

		s.close();
	}
}