// Arup Guha
// 4/10/2020

import java.util.*;

public class Solution {
	
	public static int[] DX = {-1,0,0,1};
	public static int[] DY = {0,-1,1,0};
	
	public static int nR;
	public static int nC;
	public static int[][] grid;
	public static TreeSet[] rows;
	public static TreeSet[] cols;

	public static void main(String[] args) {
	
		Scanner stdin = new Scanner(System.in);
		int numCases = stdin.nextInt();
		
		// Process cases.
		for (int loop=1; loop<=numCases; loop++) {
		
			nR = stdin.nextInt();
			nC = stdin.nextInt();
			grid = new int[nR][nC];
			rows = new TreeSet[nR];
			cols = new TreeSet[nC];
			for (int i=0; i<nR; i++) {
				rows[i] = new TreeSet<Integer>();
				for (int j=0; j<nC; j++) rows[i].add(j);
			}
			for (int i=0; i<nC; i++) {
				cols[i] = new TreeSet<Integer>();
				for (int j=0; j<nR; j++) cols[i].add(j);
			}
			
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
		
		ArrayList<Long> remList = new ArrayList<Long>();
		
		long cost = 0;
		for (int i=0; i<nR; i++) {
			
			
			Iterator<Integer> iterator = rows[i].iterator();
			while (iterator.hasNext()) {
				
				int colVal = iterator.next();
				// row i, col colVal
				
				int nSum = 0, cnt = 0;
				
				// go left
				Integer left = (Integer)rows[i].lower(colVal);
				if (left != null) {
					cnt++;
					nSum += grid[i][left];
				}
				Integer right = (Integer)rows[i].higher(colVal);
				if (right != null) {
					cnt++;
					nSum += grid[i][right];
				}
				Integer up = (Integer)cols[colVal].lower(i);
				if (up != null) {
					cnt++;
					nSum += grid[up][colVal];
				}
				Integer down = (Integer)cols[colVal].higher(i);
				if (down != null) {
					cnt++;
					nSum += grid[down][colVal];
				}
					
				if (cnt*grid[i][colVal] < nSum) { 
					cost += grid[i][colVal];
					//rows[i].remove(colVal);
					//cols[colVal].remove(i);
					remList.add(100000L*i+colVal);
				}
					
				
			}
		}
		
		for (Long x: remList) {
			int r = (int)(x/100000);
			int c = (int)(x%100000);
			rows[r].remove(c);
			cols[c].remove(r);
		}
		
		return cost;
	}
	
}