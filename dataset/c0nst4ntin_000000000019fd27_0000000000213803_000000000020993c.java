import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		for (int _t = 1; _t <= t; ++_t) {
			int n = in.nextInt();

			// Load Matrix
			int[][] matrix = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					matrix[i][j] = in.nextInt();
				}
			}

			// Trace
			int trace = 0;
			for (int i = 0; i < n; i++) {
				trace += matrix[i][i];
			}

			int duplicateRows = 0;
			int duplicateCols = 0;
			for (int i = 0; i < n; i++) {
				int[] row = new int[n];
				for (int j = 0; j < n; j++) {
					row[j] = matrix[i][j];
				}
				if (duplicates(row)) duplicateRows++;
			}
			for (int i = 0; i < n; i++) {
				int[] col = new int[n];
				for (int j = 0; j < n; j++) {
					col[j] = matrix[j][i];
				}
				if (duplicates(col)) duplicateCols++;
			}

			System.out.println("Case #" + _t + ": " + trace + " " + duplicateRows + " " + duplicateCols);
		}
	}

	private static boolean duplicates (int[] list) {
		ArrayList<Integer> log = new ArrayList<Integer>();
		for (int i = 0; i < list.length; i++) {
			if (log.contains(list[i]))
				return true;
			log.add(list[i]);
		}
		return false;
	}

}
