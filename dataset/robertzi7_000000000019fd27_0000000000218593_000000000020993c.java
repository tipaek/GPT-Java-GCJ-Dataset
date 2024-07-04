import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc
		for (int cases = 1; cases <= t; ++cases) {
			int n = in.nextInt();
			int[][] grid = new int[n][n];
			
			int k = 0;
			int r = 0;
			int c = 0;
			
			
			for(int i = 0; i < n; i++) {
			    HashSet<Integer> rSet = new HashSet<>();
			    boolean badr = false;
				for(int j = 0; j < n; j++) {
					grid[i][j] = in.nextInt();
					if(i == j) k += grid[i][i];
					if(!badr) {
						if(rSet.contains(grid[i][j])) {
							r++;
							badr = true;
						}
						rSet.add(grid[i][j]);
					}
				}
			}

			for(int i = 0; i < n; i++) {
				HashSet<Integer> cSet = new HashSet<>();
				boolean badc = false;
				for(int j = 0; j < n; j++) {
					if(!badc) {
						if(cSet.contains(grid[j][i])) {
							c++;
							badc = true;
						}
						cSet.add(grid[j][i]);
					}
				}
			}
			System.out.println("Case #" + cases + ": " + k + " " + r + " " + c);
		}
	}
}