

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;


public class Solution {

	void checkLatinSquares(int[][] arr, int caseNo) {
		int n = arr.length;
		int xor = 0;

		for (int i = 1; i <= n; i++)
			xor = xor ^ i;

		int trace = 0;
		int rowRepeated = 0, colRepeated = 0;
		int curXor = 0;
		for (int i = 0; i < n; i++) {
			curXor = 0;
			for (int j = 0; j < n; j++) {
				if (i == j)
					trace = trace + arr[i][j];
				curXor = curXor ^ arr[i][j];
			}
			if (curXor != xor)
				rowRepeated++;
		}

		for (int col = 0; col < n; col++) {
			curXor = 0;
			for (int row = 0; row < n; row++) {
				curXor = curXor ^ arr[row][col];
			}
			if (curXor != xor)
				colRepeated++;
		}

		System.out.println("Case #" + caseNo + ": " + trace + " " + rowRepeated
				+ " " + colRepeated);
	}

	public static void main(String[] args) {
		Solution obj = new Solution();
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(
				System.in)));
		int t = in.nextInt();
		for (int i = 1; i <= t; ++i) {
			int n = in.nextInt();
			int[][] arr = new int[n][n];
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					arr[j][k] = in.nextInt();
				}
			}
			obj.checkLatinSquares(arr, i);
		}
	}
}
