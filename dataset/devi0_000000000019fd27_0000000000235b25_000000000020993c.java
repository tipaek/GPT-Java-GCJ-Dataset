import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in), 32768);
		PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		int t = Integer.parseInt(reader.readLine());
		for (int x = 1; x <= t; x++) {
			solve(x, reader, writer);
		}
		reader.close();
		writer.close();
	}

	private static void solve(int x, BufferedReader reader, PrintWriter writer)
			throws NumberFormatException, IOException {
		int n = Integer.parseInt(reader.readLine());
		int[][] matrix = new int[n][n];
		int[] colChecker = new int[n];
		Arrays.fill(colChecker, 0);
		boolean[] duplicateCol = new boolean[n];
		Arrays.fill(duplicateCol, false);
		int k = 0;
		int r = 0;
		int c = 0;
		for (int i = 0; i < n; i++) {
			String[] m = reader.readLine().split(" ");
			int checker = 0;
			boolean duplicateRow = false;
			for (int j = 0; j < n; j++) {
				matrix[i][j] = Integer.parseInt(m[j]);
				if (i == j) {
					k += matrix[i][j];
				}
				if (!duplicateRow && (checker & (1 << matrix[i][j])) > 0) {
					r++;
					duplicateRow = true;
				}
				if (!duplicateCol[j] && (colChecker[j] & (1 << matrix[i][j])) > 0) {
					c++;
					duplicateCol[j] = true;
				}
				colChecker[j] |= (1 << matrix[i][j]);
				checker |= (1 << matrix[i][j]);
			}
		}
		writer.println("Case #" + x + ": " + k + " " + r + " " + c);
	}
}
