
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	
	private static void test() throws IOException {
		String s;
		BufferedReader read = new BufferedReader(new FileReader("data/testIn"));
		String total = "";
		while((s = read.readLine())!= null) total += s + "\n";
		InputStream testInput = new ByteArrayInputStream( total.getBytes("UTF-8") );
		System.setIn(testInput);
		read.close();
	}

	public static void main(String[] args) throws IOException {
		//test();
		final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		final int t = Integer.parseInt(in.nextLine());
		for (int x = 1; x <= t; ++x) {
			System.out.println("Case #" + x + ": " + getResult(in.nextLine()));
		}
		in.close();
	}
		
	// If both numbers are uneven it's impossible. Let's also cap it at 30 jumps which should be waaaay more than we need.
	// Though 4^30 probably takes too long... How many cores you got?! ;)
	// If it fails, I'll have to determine a better "Impossible" detection.
	private static String getResult(String targetString) {
		String[] t = targetString.split(" ");
		long targetX = Long.parseLong(t[0]);
		long targetY = Long.parseLong(t[1]);
		//System.out.println(Math.abs(targetX % 2));
		//System.out.println(Math.abs(targetY % 2));
		if (Math.abs(targetX % 2) == Math.abs(targetY %2)) return "IMPOSSIBLE";
		Queue<Point> q = new ArrayDeque<>();
		final int maxDepth = 15;
		q.add(new Point(0,0,0, 1));
		while(!q.isEmpty()) {
			Point p = q.poll();
			if(p.depth == maxDepth) return "IMPOSSIBLE";
			long thisHop = p.nextHop;
			long nextHop = p.nextHop * 2;
			int nextDepth = p.depth+1;
			long x = p.x;
			long y = p.y;
			Point n = new Point(x - thisHop, y, nextDepth, nextHop, p.directionHistory.toString()+"W");
			if(n.x == targetX && n.y == targetY) return n.directionHistory.toString();
			q.add(n);
			n = new Point(x + thisHop, y, nextDepth, nextHop, p.directionHistory.toString()+"E");
			if(n.x == targetX && n.y == targetY) return n.directionHistory.toString();
			q.add(n);
			n = new Point(x, y - thisHop, nextDepth, nextHop, p.directionHistory.toString()+"S");
			if(n.x == targetX && n.y == targetY) return n.directionHistory.toString();
			q.add(n);
			n = new Point(x, y + thisHop, nextDepth, nextHop, p.directionHistory.toString()+"N");
			if(n.x == targetX && n.y == targetY) return n.directionHistory.toString();
			q.add(n);
		}

		return "IMPOSSIBLE";
	}
	
	private static class Point {
		private long x, y;
		int depth;
		long nextHop;
		private StringBuilder directionHistory = new StringBuilder();
		private Point(long x, long y, int depth, long nextHop) {
			this.x = x;
			this.y = y;
			this.depth = depth;
			this.nextHop = nextHop;
		}
		private Point(long x, long y, int depth, long nextHop, String directionHistory) {
			this.x = x;
			this.y = y;
			this.depth = depth;
			this.nextHop = nextHop;
			this.directionHistory.append(directionHistory);
		}
	}
}
