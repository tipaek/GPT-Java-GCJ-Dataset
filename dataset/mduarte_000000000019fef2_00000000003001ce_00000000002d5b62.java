import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Solution s = new Solution();
		s.solution();
	}
	
	public void solution() {
	    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
	    for (int i = 1; i <= t; ++i) {
	      int x = in.nextInt();
	      int y = in.nextInt();
	      String ans = walk(x , y);
	      System.out.println("Case #" + i + ": " + ans);
	    }
	    in.close();

	}
	// E S W N
	public enum Dir {
		EAST(1, 0, "E"),
		SOUTH(0,-1, "S"),
		WEST(-1,0, "W"),
		NORTH(0,1, "N");
		
		
		int x;
		int y;
		String direction;
		
		Dir(int x, int y, String d) {
			this.x = x;
			this.y = y;
			this.direction = d;
		}
	}
	int maxX = 1000000000;
	int maxY = 1000000000;
	
	private String walk(int x, int y) {
		if (x % 2 != 0 && y % 2 != 0) return "IMPOSSIBLE";
		if (x % 2 == 0 && y % 2 == 0) return "IMPOSSIBLE";

		Queue<Node> queue = new LinkedList<Node>();
		Node newNode = new Node(0, 0, "");
		queue.add(newNode);
		
		int jump = 1;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				Node node = queue.poll();
				Node test = walk(x, y, node, jump, queue);
				if (test != null) return test.path;
			}
			jump = jump * 2;
			
			
		}
		return "IMPOSSIBLE";
	}


	private Node walk(int targetX, int targetY, Node pos, int jump, Queue<Node> queue) {

		
		for (Dir dir : Dir.values()) {
			int sumX = pos.x + (dir.x * jump);
			int sumY = pos.y + (dir.y * jump);
			Node node = new Node(sumX, sumY, pos.path + dir.direction);

			if (targetX == node.x && targetY == node.y) {
				return node;
			}
			if (Math.abs(pos.x) <= maxX && Math.abs(pos.y) <= maxY) {
				queue.add(node);
			}
		}
		return null;
	}
	
	public class Node {
		String path;
		int x;
		int y;
		Node(int x, int y, String path) {
			this.x = x;
			this.y = y;
			this.path = path;
		}
		
		
	}

}
