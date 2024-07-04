
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt(), testCase = 1;
		while(testCase <= t) {
			int x = s.nextInt(), y = s.nextInt();
			Queue<Node> queue = new LinkedList<Node>();
			int count = 0;
			queue.add(new Node(0, 0, "", 0));
			String ans = "IMPOSSIBLE";
			while(queue.size() > 0 && ((x % 2 == 0) || (y % 2 == 0))) {
				Node curr = queue.remove();
				if(curr.x == x && curr.y == y) {
					ans = curr.str;
					break;
				}
				long n = (long)Math.pow(2, curr.no);
				if(n > 2 * Math.max(Math.abs(x), Math.abs(y))) {
					continue;
				}
				queue.add(new Node(curr.x + n, curr.y, curr.str + "E", curr.no + 1));
				queue.add(new Node(curr.x - n, curr.y, curr.str + "W", curr.no + 1));
				queue.add(new Node(curr.x, curr.y + n, curr.str + "N", curr.no + 1));
				queue.add(new Node(curr.x, curr.y - n, curr.str + "S", curr.no + 1));
			}
			System.out.println("Case #" + testCase++ + ": " + ans);
		}
	}

}

class Node {
	long x, y, dir, no;
	String str;
	 Node(long x, long y, String str, long n) {
		 this.x = x;
		 this.y = y;
		 this.str = str;
		 this.no = n;
	 }
}
