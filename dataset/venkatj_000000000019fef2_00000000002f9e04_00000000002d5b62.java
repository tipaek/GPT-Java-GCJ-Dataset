import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class Solution {

	static int[] xd = { 0, -1, 1, 0 };
	static int[] yd = { 1, 0, 0, -1 };
	static String[] dir = { "N", "W", "E", "S" };

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = Integer.parseInt(in.nextLine());
		// System.out.println("Test cases : " + t);

		for (int i = 1; i <= t; ++i) {
			int x = in.nextInt();
			int y = in.nextInt();

			Set<String> visited = new HashSet<>();
			String result = process(x, y, visited);

			System.out.println("Case #" + i + ": " + result);
		}
	}

	private static String process(int x, int y, Set<String> visited) {

		Queue<Node> queue = new LinkedList<>();

		queue.add(new Node(new int[] { 0, 0 }, ""));
		visited.add("0!0");
		int level = 1;
		while (!queue.isEmpty()) {
			if(level > 128) return "IMPOSSIBLE";

			int size = queue.size();
			while (size > 0) {
				//System.out.println(queue);
				Node node = queue.poll();
				if (node.c[0] == x && node.c[1] == y)
					return node.result;

				for (int i = 0; i < 4; i++) {
					int nx = node.c[0] + xd[i] * level;
					int ny = node.c[1] + yd[i] * level;
					if (nx < 100 && ny < 100 & !visited.contains(nx + "!" + ny)) {
						visited.add(nx + "!" + ny);
						queue.add(new Node(new int[] { nx, ny }, node.result + dir[i]));
					}
				}
				size--;
			}
			level *= 2;
		}
		return "IMPOSSIBLE";
	}

	static class Node {
		int[] c;
		String result;

		Node(int[] c, String result) {
			this.c = c;
			this.result = result;
		}

		public String toString() {
			return "[" + c[0] + "," + c[1] + "] " + result;
		}
	}
}
