import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class Solution {

	Map<String, int[][]> dir = new HashMap<>();

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = Integer.parseInt(in.nextLine());

		for (int i = 1; i <= t; ++i) {
			int x = in.nextInt();
			int y = in.nextInt();

			String m = in.next();
			Map<String, List<Integer>> moves = new HashMap<>();

			//System.out.println(m);
			int n = 1;
			for (char c : m.toCharArray()) {
				if (c == 'N') {
					y = y + 1;
				} else if (c == 'S') {
					y = y - 1;
				} else if (c == 'E') {
					x = x + 1;
				} else if (c == 'W') {
					x = x - 1;
				}
				List<Integer> def = moves.getOrDefault(x + "!" + y, new ArrayList<Integer>());
				def.add(n);
				moves.put(x + "!" + y, def);
				n++;
			}
			//System.out.println(moves);

			Queue<Node> q = new LinkedList<>();
			q.add(new Node(0, 0));
			Integer result = null;
			Set<Node> visited = new HashSet<>();
			visited.add(new Node(0, 0));

			int level = 0;
			while (level <= m.length()) {

				int size = q.size();
				//System.out.println("Queue size : " + q);
				//System.out.println("Level : " + level);
				while (size > 0) {
					Node next = q.poll();
					if (moves.containsKey(next.x + "!" + next.y)) {
						final int temp = level;
						Optional<Integer> res = moves.get(next.x + "!" + next.y).stream().filter(p -> p >= temp)
								.findFirst();
						//System.out.println("Res : " + res + " " + level);
						if (res.isPresent() && (result == null || result > res.get())) {
							result = res.get();
						}
					}
					Node tp = new Node(next.x + 1, next.y);
					if (!visited.contains(tp)) {
						q.add(tp);
						visited.add(tp);
					}
					tp = new Node(next.x - 1, next.y);
					if (!visited.contains(tp)) {
						q.add(tp);
						visited.add(tp);
					}
					tp = new Node(next.x, next.y + 1);
					if (!visited.contains(tp)) {
						q.add(tp);
						visited.add(tp);
					}
					tp = new Node(next.x, next.y - 1);
					if (!visited.contains(tp)) {
						q.add(tp);
						visited.add(tp);
					}
					size--;
				}
				level++;
			}

			System.out.println("Case #" + i + ": " + ((result == null) ? "IMPOSSIBLE" : result));

		}
	}

	public static class Node {
		int x;
		int y;

		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public boolean equals(Object t) {
			Node t1 = (Node) t;
			return (t1.x == x && t1.y == y);
		}

		public String toString() {
			return "[" + x + "," + y + "]";
		}
	}
}
