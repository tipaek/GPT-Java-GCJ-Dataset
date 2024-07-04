import java.io.*;
import java.util.*;
public class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(in.readLine());
		
		
		for (int k = 0; k < t; k++) {
			int n = Integer.parseInt(in.readLine());
			int[][] grid = new int[n][n];
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine());
				for (int j = 0; j < n; j++)
					grid[i][j] = Integer.parseInt(st.nextToken());
			}
			
			int diagSum = 0;
			for (int i = 0; i < n; i++) diagSum += grid[i][i];
			
			int rC = 0;
			for (int r = 0; r < n; r++) {
				boolean[] cases = new boolean[n];
				boolean good = true;
				for (int c = 0; c < n; c++) {
					if (cases[grid[r][c]-1]) {
						good = false;
						break;
					}
					cases[grid[r][c]-1] = true;
				}
				if (!good) rC++;
			}
			
			int cC = 0;
			for (int c = 0; c < n; c++) {
				boolean[] cases = new boolean[n];
				boolean good = true;
				for (int r = 0; r < n; r++) {
					if (cases[grid[r][c]-1]) {
						good = false;
						break;
					}
					cases[grid[r][c]-1] = true;
				}
				if (!good)  cC++;
			}
			
			System.out.println("Case #" + (k+1) + ":" + " " + diagSum + " " + rC + " " + cC);
		}
	}
}
