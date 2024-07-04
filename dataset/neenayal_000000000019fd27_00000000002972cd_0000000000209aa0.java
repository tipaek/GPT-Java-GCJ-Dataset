import java.util.*;
import java.io.*;

public class Solution {

	private static int[][] getMatrix(int n, int pivot) {
		int[][] matrix = new int[n][n];
		for (int row = 0; row < n; row++) {
			int count = pivot;
			int start = row;
			for (int col = 0; col < n; col++) {
				matrix[row][start % n] = count++;
				start++;
			}
		}
		return matrix;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int tc = in.nextInt();
		for (int test = 1; test <= tc; ++test) {
			int num = in.nextInt();
			int trace = in.nextInt();

			int start = 0;
			boolean resultFound = false;
			for (int idx = 1; idx <= num; idx++) {
				if (idx * num == trace) {
					start = idx;
					resultFound = true;
				}
			}
			if (resultFound) {
				System.out.println("Case #" + test + ": POSSIBLE");
				printMatrix(getMatrix(num, start), num);
			} else {
				System.out.println("Case #" + test + ": IMPOSSIBLE");
			}
		}
	}

	private static void printMatrix(int[][] matrix, int num) {
		for (int row = 0; row < num; row++) {
			StringBuilder builder = new StringBuilder();
			for (int col = 0; col < num; col++) {
				builder.append(matrix[row][col]).append(" ");
			}
			System.out.println(builder.toString().trim());
		}
	}

}