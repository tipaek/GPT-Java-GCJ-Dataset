// Arup Guha
// 4/10/2020

import java.util.*;

public class Solution {
	
	public static int[] DX = {-1,0,0,1};
	public static int[] DY = {0,-1,1,0};
	
	public static int nR;
	public static int nC;
	public static int[][] grid;

	public static void main(String[] args) {
	
		Scanner stdin = new Scanner(System.in);
		int numCases = stdin.nextInt();
		
		// Process cases.
		for (int loop=1; loop<=numCases; loop++) {
		
			nR = stdin.nextInt();
			nC = stdin.nextInt();
			grid = new int[nR][nC];
			
			
			long curSum = 0;
			for (int i=0; i<nR; i++) {
				for (int j=0; j<nC; j++) {
					grid[i][j] = stdin.nextInt();
					curSum += grid[i][j];
				}
			}
			
			long res = curSum;
			
			while (true) {
				
				// STores answer back into grid, returns sum of removed vals.
				long remove = next();
				
				if (remove == 0) break;
				
				curSum -= remove;
				res = res + curSum;
				
			}

			// Ta da!
			System.out.println("Case #"+loop+": "+res);
		}
	}
	
	public static long next() {
		
		int[][] tmp = new int[nR][nC];
		long cost = 0;
		for (int i=0; i<nR; i++) {
			for (int j=0; j<nC; j++) {
			
				if (grid[i][j] == 0) continue;
				
				int nSum = 0, cnt = 0;
				for (int k=0; k<4; k++) {
					int next = get(i,j,k);
					if (next != -1) {
						cnt++;
						nSum += next;
					}
				}
				
				if (cnt*grid[i][j] < nSum) 
					cost += grid[i][j];
				else
					tmp[i][j] = grid[i][j];
				
			}
		}
		grid = tmp;
		return cost;
	}
	
	public static int get(int x, int y, int dir) {
		
		int nX = x + DX[dir];
		int nY = y + DY[dir];
		if (!inbounds(nX,nY)) return -1;
		
		while (true) {
			if (grid[nX][nY] != 0) return grid[nX][nY];
			nX += DX[dir];
			nY += DY[dir];
			if (!inbounds(nX,nY)) return -1;
		}
	}
	
	public static boolean inbounds(int x, int y) {
		return x >= 0 && x < nR && y >= 0 && y <nC;
	}
}