

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.HashSet;

public class Solution {

	void checkLatinSquares(int[][] arr, int caseNo) {
	    
		int n = arr.length;
		int trace = 0;
		int rowRepeated = 0, colRepeated = 0;

		for (int i = 0; i < n; i++) {
			HashSet<Integer> colSet = new HashSet<>();
			HashSet<Integer> rowSet = new HashSet<>();
			for (int j = 0; j < n; j++) {
				if (i == j)
					trace = trace + arr[i][j];
				colSet.add(arr[j][i]);
				rowSet.add(arr[i][j]);
			}
			if (colSet.size() < n)
				colRepeated++;
			if (rowSet.size() < n)
				rowRepeated++;
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
