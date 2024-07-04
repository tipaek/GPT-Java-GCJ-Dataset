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
			int k = in.nextInt();

			solve(tc, n, k);
			
			
		}
		in.close();
	}
	
	private static void solve(int tc, int n, int k) {
		/*System.out.println("tc: " + tc);
		System.out.println("n: " + n);
		System.out.println("k: " + k);*/
		
		int[][] m = new int[n][n];
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < n; c++) {
				m[r][(c + r)%n] = c + 1;
			}
		}
		
		/*for (int r = 0; r < n; r++) {
			System.out.println(Arrays.toString(m[r]));
		}*/
		
		boolean found = swapRows(m, n, k, 0, n);
		//System.out.println("found: " + found);
		
		if (!found) {
			m = new int[n][n];
			for (int r = 0; r < n; r++) {
				for (int c = 0; c < n; c++) {
					m[(c + r)%n][r] = c + 1;
				}
			}
			
			/*for (int r = 0; r < n; r++) {
				System.out.println(Arrays.toString(m[r]));
			}*/
			found = swapRows(m, n, k, 0, n);
		}
		
		if (found) {
			System.out.println("Case #" + tc + ": POSSIBLE");
			for (int r = 0; r < n; r++) {
				for (int c = 0; c < n; c++) {
					System.out.print(m[r][c]);
					if (c < n - 1) System.out.print(" ");
				}
				System.out.println();
			}
		} else {
			System.out.println("Case #" + tc + ": IMPOSSIBLE");
		}
		
	}
	
	private static boolean swapRows(int[][] m, int n, int k, int rowIndex, int d) {
		
		/*System.out.println("rowIndex: " + rowIndex + " d: " + d + " k: " + k);
		for (int r = 0; r < n; r++) {
			System.out.println(Arrays.toString(m[r]));
		}*/
		
		if (d == k) return true;
		
		for (int i = rowIndex + 1; i < n; i++) {
			int delta1 = m[i][rowIndex] - m[rowIndex][rowIndex];
			int delta2 = m[rowIndex][i] - m[i][i];
			int newD = d + delta1 + delta2;
			if (newD > k) continue;
			
			int[] tmp = m[i];
			m[i] = m[rowIndex];
			m[rowIndex] = tmp;
			boolean found = swapRows(m, n, k, rowIndex + 1, newD);
			if (found) return true;
			m[rowIndex] = m[i];
			m[i] = tmp;
		}
		return false;
	}

}
