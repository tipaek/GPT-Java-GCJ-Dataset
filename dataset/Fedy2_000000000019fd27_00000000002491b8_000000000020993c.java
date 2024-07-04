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
			int n = in.nextInt();
			int[][] m = new int[n][n];
			for (int r = 0; r < n; r++) {
				for (int c = 0; c < n; c++) {
					m[r][c] = in.nextInt();
				}
			}

			solve(tc, n, m);
			
			
		}
		in.close();
	}
	
	private static void solve(int tc, int n, int[][] m) {
		/*System.out.println("tc: " + tc);
		System.out.println("n: " + n);
		for (int r = 0; r < n; r++) {
			System.out.println(Arrays.toString(m[r]));
		}*/
		
		int k = 0;
		for (int i = 0; i < n; i++) {
			k += m[i][i];
		}
		
		int dr = 0;
		for (int r = 0; r < n; r++) {
			boolean[] saw = new boolean[n + 1];
			for (int c = 0; c < n; c++) {
				int val = m[r][c];
				if (saw[val]) {
					dr++;
					break;
				}
				saw[val] = true;
			}
		}
		
		
		int dc = 0;
		for (int c = 0; c < n; c++) {
			boolean[] saw = new boolean[n + 1];
			for (int r = 0; r < n; r++) {
				int val = m[r][c];
				if (saw[val]) {
					dc++;
					break;
				}
				saw[val] = true;
			}
		}
		
		
		System.out.println("Case #" + tc + ": " + k + " " + dr + " " + dc);
	}

}
