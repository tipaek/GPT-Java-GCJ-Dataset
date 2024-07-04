import java.util.HashSet;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for (int t=1;t<=T;t++) {
			int n = in.nextInt();
			int[][] grid = new int[n][n];
			for (int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					grid[i][j] = in.nextInt();
				}
			}
			
			int trace = 0;
			for(int i=0;i<n;i++)
				trace += grid[i][i];
			
			int badRows = 0;
			for(int i=0;i<n;i++) {
				HashSet<Integer> set = new HashSet<>();
				for (int j=0;j<n;j++) {
					set.add(grid[i][j]);
				}
				if (set.size() != n)
					badRows++;
			}
			
			int badCols = 0;
			for(int i=0;i<n;i++) {
				HashSet<Integer> set = new HashSet<>();
				for (int j=0;j<n;j++) {
					set.add(grid[j][i]);
				}
				if (set.size() != n)
					badCols++;
			}
			
			System.out.printf("Case #%d: %d %d %d\n", t, trace, badRows, badCols);
		}
	}
}
