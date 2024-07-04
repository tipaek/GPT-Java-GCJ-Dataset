import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		in.nextLine();
		for (int i = 1; i <= t; ++i) {

			// read input
			int n = in.nextInt();
			in.nextLine();

			int[][] matrix = new int[n][n];

			for (int r = 0; r < n; r++) {
				for (int c = 0; c < n; c++) {
					matrix[r][c] = in.nextInt();
				}
				in.nextLine();
			}

			int k = computeTrace(matrix, n);
			int r = computeRows(matrix, n);
			int c = computeCols(matrix, n);

			System.out.println("Case #" + i + ": " + k + " " + r + " " + c);
		}
	}

	public static int computeTrace(int[][] matrix, int n) {
		int trace = 0;
		for(int i = 0; i < n; i++) {
			trace += matrix[i][i];
		}
		
		return trace;
	}

	public static int computeRows(int[][] matrix, int n) {
		int countRows = 0;
		for(int i = 0; i < n; i++) {
			Set<Integer> s = new HashSet<>();
			for(int j = 0; j < n; j++) {
				s.add(matrix[i][j]);
			}
			if(s.size() < n) {
				countRows += 1;
			}
		}
		
		return countRows;
	}

	public static int computeCols(int[][] matrix, int n) {
		int countColumns = 0;
		for(int i = 0; i < n; i++) {
			Set<Integer> s = new HashSet<>();
			for(int j = 0; j < n; j++) {
				s.add(matrix[j][i]);
			}
			if(s.size() < n) {
				countColumns += 1;
			}
		}
		
		return countColumns;
	}

}