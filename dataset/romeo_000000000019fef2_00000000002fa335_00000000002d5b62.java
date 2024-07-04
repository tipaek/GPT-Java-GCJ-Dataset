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
	static int power(int a, int b) {
		int ret = 1;
		while(b > 0)
		{
			if((b & 1) == 1) ret *= a;
			b >>= 1;
			a *= a;
		}
		return ret;
	}
	
	static boolean isSafe(int sx, int sy, int ex, int ey) {
		return Math.abs(sx) <= Math.abs(ex) && Math.abs(sy) <= Math.abs(ey);
	}
	
	static String bfs(int sx, int sy, int ex, int ey) {
		Queue<Node> qu = new LinkedList<>();
		qu.add(new Node(sx, sy, 1, ""));
		while(!qu.isEmpty())
		{
			Node node = qu.poll();
//			System.out.println(node.x + " " + node.y + " " + node.ret);
			if(node.x == ex && node.y == ey) return node.ret;
			int jump = power(2, node.it - 1);
			if(isSafe(node.x + jump, node.y, ex, ey))
				qu.add(new Node(node.x + jump, node.y, node.it + 1, new String(node.ret + "E")));
			if(isSafe(node.x - jump, node.y, ex, ey))
				qu.add(new Node(node.x - jump, node.y, node.it + 1, new String(node.ret + "W")));
			if(isSafe(node.x, node.y + jump, ex, ey))
				qu.add(new Node(node.x, node.y + jump, node.it + 1, new String(node.ret + "N")));
			if(isSafe(node.x, node.y - jump, ex, ey))
				qu.add(new Node(node.x, node.y - jump, node.it + 1, new String(node.ret + "S")));
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
