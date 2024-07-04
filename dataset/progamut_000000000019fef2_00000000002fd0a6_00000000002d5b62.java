import java.util.*;
import java.io.*;

public class Solution {
	static class node {
		int x;
		int y;
		String path;
		int depth;
		public node(int x, int y, String path, int depth) {
			this.x = x;
			this.y = y;
			this.path = path;
			this.depth = depth;
		}
	};
	
	private static String solution(int x, int y) {
		Queue<node> q = new LinkedList<>();
		int depth = Math.max(((int)(Math.log10(Math.abs(x))/Math.log10(2))), ((int)(Math.log10(Math.abs(y))/Math.log10(2)))) + 1;
		
		node startPos = new node(0,0,"",0);
		while (startPos != null) {
			//System.out.println(startPos.x + " " + startPos.y + startPos.path);

			if (startPos.x == x && startPos.y == y) {
				return startPos.path;
			}
			if (startPos.depth > depth) {
				startPos = q.poll();
				continue;
			}
			int jump = (1 << startPos.depth);
			q.add(new node(startPos.x, startPos.y+jump, startPos.path + "N", startPos.depth+1));
			q.add(new node(startPos.x, startPos.y-jump, startPos.path + "S", startPos.depth+1));
			q.add(new node(startPos.x+jump, startPos.y, startPos.path + "E", startPos.depth+1));
			q.add(new node(startPos.x-jump, startPos.y, startPos.path + "W", startPos.depth+1));
			startPos = q.poll();
		}
		return "IMPOSSIBLE";
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int i = 0; i < t; i++) {
			int x = in.nextInt();
			int y = in.nextInt();
			System.out.println("Case #" + (i+1) + ": " + solution(x,y));
		}
	}
}
