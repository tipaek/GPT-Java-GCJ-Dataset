/**
 * 
 */

import java.util.*;
import java.io.*;

/**
 * @author fedy2
 *
 */
public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		//System.out.println("t: " + t);

		for (int tc = 1; tc <= t; tc++) {
			int x = in.nextInt();
			int y = in.nextInt();
			String m = in.next();
			solve(tc, x, y, m);
		}
		in.close();
	}
	
	private static void solve(int tc, int x, int y, String m) {
		/*System.out.println("tc: " + tc);
		System.out.println("x: " + x);
		System.out.println("y: " + y);
		System.out.println("m: " + m);*/
		
		int minutes = 0;
		int min = -1;
		
		for (char c:m.toCharArray()) {
			switch (c) {
				case 'N': y++; break;
				case 'S': y--; break;
				case 'E': x++; break;
				case 'W': x--; break;
			}
			minutes++;
			
			int distance = Math.abs(x) + Math.abs(y);
			if (distance > minutes) continue;
			
			//System.out.println("They should meet in "+x + " " + y + " at minute " + minutes);
			
			min = minutes;
			break;
		}
		
		System.out.println("Case #" + tc + ": " + (min > 0 ? min : "IMPOSSIBLE"));
	}

}
