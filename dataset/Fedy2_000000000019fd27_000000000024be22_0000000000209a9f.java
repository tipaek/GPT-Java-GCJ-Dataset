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
			String s = in.next();

			solve(tc, s);
			
			
		}
		in.close();
	}
	
	private static void solve(int tc, String s) {
		/*System.out.println("tc: " + tc);
		System.out.println("s: " + s);*/
		
		StringBuilder r = new StringBuilder();
		
		int depth = 0;
		for (char c : s.toCharArray()) {
			int digit = c - '0';
			int delta = depth - digit;
			char p = delta > 0 ? ')' : '(';
			for (int i = 0; i < Math.abs(delta); i++) {
				r.append(p);
			}
			r.append(c);
			depth =  digit;
		}
		
		for (int i = 0; i < depth; i++) {
			r.append(')');
		}
		
		
		System.out.println("Case #" + tc + ": " + r.toString());
	}

}
