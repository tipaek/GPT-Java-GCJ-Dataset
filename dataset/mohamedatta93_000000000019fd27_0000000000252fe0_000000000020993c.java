package problems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class problem1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int i = 1; i <= t; ++i) {
			int n = in.nextInt();
			int[][] matrix = new int[n][n];
			List<Set<Integer>> rowsNumbers = new ArrayList<Set<Integer>>();
			for (int j = 0; j < n; j++)
				rowsNumbers.add(new HashSet<Integer>());
			List<Set<Integer>> columnsNumbers = new ArrayList<Set<Integer>>();
			for (int j = 0; j < n; j++)
				columnsNumbers.add(new HashSet<Integer>());

			int sum = 0;
			for (int j = 0; j < n; j++)
				for (int k = 0; k < n; k++) {

					matrix[j][k] = in.nextInt();
					rowsNumbers.get(j).add(matrix[j][k]);
					columnsNumbers.get(k).add(matrix[j][k]);
					if (k == j)
						sum += matrix[j][k];
				}
			int nRows = 0;
			int nColumns = 0;
			for (int j = 0; j < n; j++) {
				if (rowsNumbers.get(j).size() != n)
					nRows++;
				if (columnsNumbers.get(j).size() != n)
					nColumns++;

			}

			System.out.println("Case #" + i + ": " + (sum) + " " + (nRows) + " " + nColumns);
		}
	}

}
