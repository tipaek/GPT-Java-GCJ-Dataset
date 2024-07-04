import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
public class Solution {
	public static void main(String args[]) {

		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int i = 1; i <= t; ++i) {
			int n = in.nextInt();
			int sum = 0;
			int grid[][] = new int[n][n];
			
			int r = 0;
			for (int j = 1; j <= n; ++j) {
				Set<Integer> rowSet = new HashSet<Integer>();
				for (int k = 1; k <= n; ++k) {
					int v = in.nextInt();
					grid[j - 1][k - 1] = v;
					if (j == k) {
						sum = sum + v;
					}

					//col[k] = col[k] + v;

					rowSet.add(v);
				}
				if(rowSet.size()<n) {
					r+=1;
				}

			}

			int c = 0;
			for (int j = 1; j <= n; ++j) {
				Set<Integer> colSet = new HashSet<Integer>();
				for (int k = 1; k <= n; ++k) {
					if (!colSet.add(grid[k-1][j-1])) {
						c += 1;
						break;
					}
				}
			}

			System.out.println("Case #" + i + ": " + sum + " " + r +" "+c);
		}

		in.close();
	}



}
