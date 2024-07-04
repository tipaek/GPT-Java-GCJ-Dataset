

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.TreeMap;
 

public class Solution {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(System.out, false);

	public static void main(String[] args) throws Exception {
		int T = Integer.parseInt(br.readLine());
		for (int i = 1; i <= T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			if (k % n == 0) {
				// proceed with calculation
				int[][] matrix = new int[n][n];
				int[] subMatrix = new int[n];
				for (int j = 1; j <= n; j++) {
					subMatrix[j - 1] = j;
				}
				int diagNums = k / n;
				int index = Arrays.binarySearch(subMatrix, diagNums);
				if (index < 0) {
					pw.println("Case #" + i + ": IMPOSSIBLE");
				} else {
					pw.println("Case #" + i + ": POSSIBLE");

					generate(matrix, n, subMatrix, k, index);
					print(matrix, n);
				}

			} else {
				pw.println("Case #" + i + ": IMPOSSIBLE");
			}

		}
		pw.flush();
	}

	private static void generate(int[][] matrix, int n, int[] subMatrix, int k, int index) {

		int e = index;
		for (int i = 0; i < n; i++) {
			e = (index - i) % n;
			if (e < 0) {
				e = n + e;
			}
			for (int j = 0; j < n; j++, e++) {
				e = e % n;
				matrix[i][j] = subMatrix[e];

			}
		}

	}

private static void print(int[][] matrix, int n) {
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n; j++) {
				pw.print(matrix[i][j] + " ");
			}
			pw.println();
		}
		for (int j = 0; j < n - 1; j++) {
			pw.print(matrix[n - 1][j] + " ");
		}
		pw.print(matrix[n - 1][n - 1]);
		pw.println();
	}
}
