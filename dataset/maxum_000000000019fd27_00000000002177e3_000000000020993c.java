import java.util.*;
import java.io.*;


public class Solution {

	public static void compute(int[][] arr, int testCase) {
		int tr = 0, rows = 0, cols = 0;

		boolean[] colDup = new boolean[arr.length];
		List<Set<Integer>> colList = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			colList.add(new HashSet<Integer>());
		}


		for (int i = 0; i < arr.length; i++) {
			Set<Integer> rowSet = new HashSet<>();
			boolean hasDuplicates = false;
			for (int j = 0; j < arr.length; j++) {
				/* handle row checking */
				if (rowSet.contains(arr[i][j])) {
					hasDuplicates = true;
				} else {
					rowSet.add(arr[i][j]);
				}

				/* handle column checking */
				if (colList.get(j).contains(arr[i][j])) {
					colDup[j] = true;
				} else {
					colList.get(j).add(arr[i][j]);
				}

			}

			if (hasDuplicates) {
				rows++;
			}

			tr += arr[i][i];

		}


		for (int i = 0; i < arr.length; i++) {
			if (colDup[i]) {
				cols++;
			}
		}


		System.out.println("Case #" + testCase + ": " +
				tr + " " + rows + " " + cols);


	}



	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(
					new InputStreamReader(System.in)));

		int T = in.nextInt();

		for (int i = 1; i <= T; i++) {

			int n = in.nextInt();
			int[][] arr = new int[n][n];
			for (int l = 0; l < n; l++) {
				for (int m = 0; m < n; m++) {
					arr[l][m] = in.nextInt();
				}
			}

			compute(arr, i);


		}



	}

}
