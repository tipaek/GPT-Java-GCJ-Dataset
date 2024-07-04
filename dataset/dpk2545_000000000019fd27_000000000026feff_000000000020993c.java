import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.io.*;

public class Solution {
	public static void main(String[] args) {
		Scanner in = null;
		try {
			in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
			int t = in.nextInt();
			while (t > 0) {
				int n = in.nextInt();
				int[][] mat = new int[n][n];
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						mat[i][j] = in.nextInt();
					}
				}
				checkMatrix(mat);
				t--;
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}

	public static void checkMatrix(int[][] mat) {
		if (mat == null || mat.length == 0)
			System.out.println(0 + " " + 0 + " " + 0);
		int row = 0;
		int col = 0;
		int k = 0;
		boolean rowFlag = false;
		boolean colFlag = false;
		Set<Integer> set = null;
		for (int i = 0; i < mat.length; i++) {
			set = new HashSet<Integer>();
			rowFlag = false;
			for (int j = 0; j < mat[0].length; j++) {
				if (i == j) {
					k += mat[i][j];
				}
				if (set.contains(mat[i][j]) && !rowFlag) {
					rowFlag = true;
					row++;
				} else {
					set.add(mat[i][j]);
				}
			}
		}

		for (int i = 0; i < mat[0].length; i++) {
			set = new HashSet<Integer>();
			colFlag = false;
			for (int j = 0; j < mat.length; j++) {
				if (set.contains(mat[j][i]) && !colFlag) {
					col++;
					colFlag = true;
				} else {
					set.add(mat[j][i]);
				}
			}
		}

		System.out.println(k + " " + row + " " + col);
	}
}