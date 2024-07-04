import java.util.*;
import java.io.*;
/*
 * you know where the thing is going to be at what min
 */
public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int i = 1; i <= t; ++i) {
			int x = in.nextInt();
			int y = in.nextInt();
			String dir=in.next ();
			int verdict=traverse (x, y, dir);
			if (verdict==-1)
				System.out.println("Case #" + i + ": IMPOSSIBLE");
			else
				System.out.println("Case #" + i + ": " + verdict);
		}
	}
	public static int traverse (int x, int y, String dir) {
		if (x==0&&y==0) return 0;
		for (int i=0; i<dir.length(); i++) {
			String d=Character.toString(dir.charAt(i));
			int time=i+1;
			if (d.equals("N")) {
				y++;
				int ttl=Math.abs(x)+Math.abs(y);
				if (ttl<=time) return time;
			}
			else if (d.equals("S")) {
				y--;
				int ttl=Math.abs(x)+Math.abs(y);
				if (ttl<=time) return time;
			}
			else if (d.equals("E")) {
				x++;				
				int ttl=Math.abs(x)+Math.abs(y);
				if (ttl<=time) return time;
			}
			else {
				x--;
				int ttl=Math.abs(x)+Math.abs(y);
				if (ttl<=time) return time;
			}
		}
		return -1;
	}
}
