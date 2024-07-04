import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int x = 1; x <= t; ++x) {
			int n = in.nextInt();
			int [][] a = new int[n][n];
			int k = 0, r = 0, c = 0;
			Set<Integer> []rows = new HashSet[n];
			Set<Integer> []cols = new HashSet[n];
			for (int i = 0; i < n; i++) {
				rows[i] = new HashSet<Integer>();
				cols[i] = new HashSet<Integer>();
			}
			
			for (int i = 0; i < n; i++)
				for (int j = 0; j < n; j++) {
					a[i][j] = in.nextInt();
					if(i == j) k += a[i][j];
					rows[i].add(a[i][j]);
					cols[j].add(a[i][j]);
				}
			
			for (int i = 0; i < n; i++) {
				r += (rows[i].size() == n) ? 0 : 1;
				c += (cols[i].size() == n) ? 0 : 1;
			}
			
			System.out.printf("Case #%d: %d %d %d\n",x,k,r,c);
		}
	}
}