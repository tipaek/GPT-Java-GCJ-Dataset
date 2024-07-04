import java.util.HashSet;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			int n = sc.nextInt();
			int[][] matrix = new int[n][n];
			for(int j = 0; j < n; j++) {
				for(int k = 0; k < n; k++) {
					matrix[j][k]= sc.nextInt();
				}	
			}
			solve(i + 1, n, matrix);
		}
	}

	private static void solve(int i, int n, int[][] matrix) {
		int repRows = 0;
		int trace = 0;
		for (int row = 0; row < n; row++) {
			if (isDup(n, matrix, row)) {
				repRows++;
			};
			trace+=matrix[row][row];
		}
		
		int repCols = 0;
		for (int col = 0; col < n; col++) {
			if (isDupCol(n, matrix, col)) {
				repCols++;
			};
		}
		
		System.out.println("Case #"+i+":"+trace+" "+repRows+" "+repCols);
	}

	private static boolean isDup(int n, int[][] matrix, int row) {
		HashSet<Integer> elems = new HashSet<>();
		for (int col = 0; col < n; col++) {
			if (elems.contains(matrix[row][col])) {
				return true;
			}
			elems.add(matrix[row][col]);
		}
		return false;
	}
	private static boolean isDupCol(int n, int[][] matrix, int col) {
		HashSet<Integer> elems = new HashSet<>();
		for (int row = 0; row < n; row++) {
			if (elems.contains(matrix[row][col])) {
				return true;
			}
			elems.add(matrix[row][col]);
		}
		return false;
	}
}
