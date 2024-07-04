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
	
	private static List<Integer[]> solution(int x, int y) {
		int total = x*y;
		int a = x;
		List<Integer[]> l = new ArrayList<>();
		while (a > 1) {
			int b = a;
			while (b < total) {
				Integer[] t = new Integer[2];
				t[0] = b;
				t[1] = y < a ? y: a-1;
				l.add(t);
				b *= 2;
			}
			a -= 1;
			total = a*y;
		}
		return l;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int i = 0; i < t; i++) {
			int x = in.nextInt();
			int y = in.nextInt();
			List<Integer[]> sol = solution(x,y);
			System.out.println("Case #" + (i+1) + ": " + sol.size());
			for (Integer[] p: sol) {
				System.out.println(p[0] + " " + p[1]);
			}
		}
	}
}
