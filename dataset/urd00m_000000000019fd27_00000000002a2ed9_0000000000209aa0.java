//package QualificationRound2020;

/*
ID: urd00m
LANG: JAVA
TASK: indicium
 */
import java.io.*;
import java.util.*;

public class Solution {
	static int t;
	static int n, k;
	static boolean[][] row, column; 
	static boolean found; 
	static int[][] matrix; 
	static int[] start; 
	public static void main(String args[]) throws IOException {
		// input
		BufferedReader f = new BufferedReader(new java.io.InputStreamReader(System.in));
		StringTokenizer input;
		t = Integer.parseInt(f.readLine());
		for (int cn = 1; cn < t + 1; cn++) {
			input = new StringTokenizer(f.readLine());
			n = Integer.parseInt(input.nextToken());
			k = Integer.parseInt(input.nextToken());

			//generate trace first 
			//is there a latin square associated with this trace 
			//must combine multiple smart backtracks to fill it out and fill out the numbers in the trace first 
			int[] trace = new int[n];
			int left = k; 
			row = new boolean[n+1][n]; 
			column = new boolean[n+1][n]; 
			for(int i = 0; i < n; i++) {
				//n-i-1
				trace[i] = Math.min(n, left-(n-i-1)); 
				left -= Math.min(n, left-(n-i-1)); 
				row[trace[i]][i] = true; 
				column[trace[i]][i] = true; 
			}
			
			//begin backtracking 
			matrix = new int[n][n]; 
			Queue<Integer> next = new LinkedList<Integer>(); 
			for(int i = 0; i < n; i++) for(int j = 0; j < n; j++) matrix[i][j] = -1; //not yet marked
			for(int i = 0; i < n; i++) {
				matrix[i][i] = trace[i]; 
				//duplicates will be sorted out 
				next.add(trace[i]); 
			}
			boolean[] done = new boolean[n+1]; 
			for(int i = 1; i <= n; i++) next.add(i); 
			boolean impossible = false; 
			
			while(next.isEmpty() == false) {
				int cur = next.remove(); 
				if(done[cur] == true) continue;
				else {
					done[cur] = true; 
					found = false; 
					fill(0, cur); 
					if(found == false) {
						impossible = true; 
						break; //impossible
					}
				}
			}
			if(impossible == true) System.out.println("Case #" + cn + ": IMPOSSIBLE");
			else {
				System.out.println("Case #" + cn + ": POSSIBLE");
				for(int i = 0; i < n; i++) {
					for(int j = 0; j < n; j++) {
						System.out.print(matrix[i][j]);
						if(j != n-1) System.out.print(" ");
					}
					System.out.println();
				}
			}
			
		}
	}
	
	public static void fill(int c, int num) {
		if(c == n) {
			found = true; 
		}
		else if(column[num][c] == true) fill(c+1, num); 
		else {
			for(int i = 0; i < n; i++) { 
				if(found == false && matrix[i][c] == -1 && row[num][i] == false) {
					matrix[i][c] = num; 
					row[num][i] = true; 
					fill(c+1, num); 
					if(found == false) {
						matrix[i][c] = -1;
						row[num][i] = false; 
					}
				}
				if(found == true) break; 
			}
		}
	}
}
