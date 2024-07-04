import java.io.*;
import java.util.*;

public class Solution {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
	
		for (int i = 1; i <= t; ++i) {
			int nrows = in.nextInt();
			int nr = 0;
			int nc = 0;
			int tr = 0;
			boolean[][] seen = new boolean[nrows][nrows];
			int[][] vals = new int[nrows][nrows];
			for (int r = 0; r < nrows; r++) {
				boolean rowFound = false;
				for (int c = 0; c < nrows; c++) {
					int v = in.nextInt();
					vals[r][c] = v;
					if (seen[r][v-1] && !rowFound) {
						rowFound = true;
						nr++;
					}
					seen[r][v-1] = true;
					if (r == c) {
						tr += v;
					}
				}
			}
			seen = new boolean[nrows][nrows];
			for (int c = 0; c < nrows; c++) {
				boolean colFound = false;
				for (int r = 0; r < nrows; r++) {
					if (seen[vals[r][c]-1][c] && !colFound) {
						colFound = true;
						nc++;
					}
					seen[vals[r][c]-1][c] = true;
				}
			}
				
			System.out.println("Case #" + i + ": " + tr + " " + nr + " " + nc);
		}
	}
}