import java.util.*;
import java.io.*;
import static java.lang.System.out;

/**
 * sqm -> square matrix
 * 
 * trace = sum of values on main diagonal
 * 
 * N values are integers 1 <= n <= N
 * 
 * answer: k (trace), # of rows, # of columns
 * 
 */ 
public class Solution {

	private static Scanner sc;
	
	private static int[][] matrix = new int[100][100];
	private static boolean[][] rowContains = new boolean[100][101];
	private static boolean[][] columnContains = new boolean[100][101];
	private static boolean[] rowFlag = new boolean[100];
	private static boolean[] columnFlag = new boolean[100];
	
	public static void main(String[] args) throws Exception {
		
		sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int t = 1; t <= T; ++t) {
			solve(t);			
		}
		
		sc.close();
	}
	
	private static void solve(int t) {
		
		Arrays.fill(rowFlag, false);
		Arrays.fill(columnFlag, false);
		for (int i = 0; i < 100; i++) {
			Arrays.fill(rowContains[i], false);
			Arrays.fill(columnContains[i], false);			
		}
		
		int N = sc.nextInt();
		
		int equalRows = 0;
		int equalColumns = 0;
		int trace = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				matrix[i][j] = sc.nextInt();
				
				// trace
				if (i == j) trace += matrix[i][j];
				
				// check row only once
				if (!rowFlag[i] && rowContains[i][matrix[i][j]]) {
					rowFlag[i] = true;
					++equalRows;
				}
				rowContains[i][matrix[i][j]] = true;
				
				// check column only once
				if (!columnFlag[j] && columnContains[j][matrix[i][j]]) {
					columnFlag[j] = true;
					++equalColumns;
				}
				columnContains[j][matrix[i][j]] = true;
			}
		}
		
		out.printf("Case #%d: %d %d %d\n", t, trace, equalRows, equalColumns);
	}
}
