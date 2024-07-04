import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.io.*;

public class Solution {
	
	Scanner sc;

	public static void main(String[] args) {
		new Solution().findSolution();
	}
	
	private void findSolution() {
		StringBuilder op = new StringBuilder();
// 		try {
			sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
			int testCases = sc.nextInt();
			for(int i = 0; i < testCases; i++) {
				op.append("Case #").append(i).append(": ");
				//read the matrix
				int n = sc.nextInt();
				if(0 == n) {
					op.append("0 0 0").append("\n");
					continue;
				}
				int[][]matrix = new int[n][n];
				readMatrix(matrix, n);
				int trace = findTrace(matrix, n);
				op.append(trace).append(" ");
				int repr = findRepRows(matrix, n);
				op.append(repr).append(" ");
				int repc = findRepCol(matrix, n);
				op.append(repc).append("\n");
				System.out.println(op.toString());
				op.setLength(0);
			}
			sc.close();
// 		} catch (FileNotFoundException e) {
// 			e.printStackTrace();
// 		}
	}
	
	private void readMatrix(int[][] mat, int n) {
		sc.nextLine();
		for(int r = 0; r < n; r++) {
			String line = sc.nextLine();
			String[] numbers = line.split(" ");
			for(int c = 0; c < n; c++) {
				mat[r][c] = Integer.parseInt(numbers[c]);
			}
		}
		return;
	}

	private int findTrace(int[][] mat, int n) {
		int trace = 0;
		for (int i = 0; i < n; i++) {
			trace += mat[i][i];
		}
		return trace;
	}
	
	private int findRepRows(int[][] mat, int n) {
		int count = 0;
		Set<Integer> rows = new HashSet<Integer>();
		for(int r = 0; r < n; r++) {
			for(int c= 0; c< n; c++) {
				if(rows.contains(mat[r][c])) {
					count++;
					break;
				} else {
					rows.add(mat[r][c]);
				}
			}
			rows.clear();
		}
		return count;
	}
	
	private int findRepCol(int[][] mat, int n) {
		int count = 0;
		Set<Integer> rows = new HashSet<Integer>();
		for(int c = 0; c < n; c++) {
			for(int r= 0; r< n; r++) {
				if(rows.contains(mat[r][c])) {
					count++;
					break;
				} else {
					rows.add(mat[r][c]);
				}
			}
			rows.clear();
		}
		return count;
	}
	
}
