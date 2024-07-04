import java.util.*;
import java.io.*;
public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int i = 1; i <= t; ++i) {
			int n = in.nextInt();
			int trace = 0;
			int cell[][] = new int [n][n];
			int r = 0;
			int c = 0;
			int[] IsOccupied = new int[n];
			
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					cell[j][k] = in.nextInt();
				}
			}
			
			for(int j = 0; j < n; j++) {
				trace += cell[j][j];
			}
			
			for(int j = 0; j < n; j++) {
				IsOccupied = new int[n];
				for(int k = 0; k < n; k++) {
					IsOccupied[cell[j][k]-1] += 1;
					if(IsOccupied[cell[j][k]-1] > 1) {
						r += 1;
						break;
					}
				}
			}
			
			for(int j = 0; j < n; j++) {
				IsOccupied = new int[n];
				for(int k = 0; k < n; k++) {
					IsOccupied[cell[k][j]-1] += 1;
					if(IsOccupied[cell[k][j]-1] > 1) {
						c += 1;
						break;
					}
				}
			}
			
			System.out.println("Case #" + i + ": " + trace + " " + r + " " + c);
		}
	}
}