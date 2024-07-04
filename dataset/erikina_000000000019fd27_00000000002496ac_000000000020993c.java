package codejam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int cases = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int i = 1; i <= cases; ++i) {
			int dim = in.nextInt();
			int[][] matrix = new int[dim][dim];
			int rows = 0;
			int columns = 0;
			int trace = 0;
			for (int m = 0; m < dim; m++) {
				List<Integer> row = new ArrayList<Integer>();
				for (int n = 0; n < dim; n++) {
					int element = in.nextInt();
					matrix[m][n] = element;
					if (!row.contains(element)) {
						row.add(element);
					}
					if (n == m) {
						trace += element;
					}
				}

				if (row.size() != dim) {
					rows++;
				}

			}

			for (int n = 0; n < dim; n++) {
				List<Integer> col = new ArrayList<Integer>();
				for (int m = 0; m < dim; m++) {
					if (!col.contains(matrix[m][n])) {
						col.add(matrix[m][n]);
					}
				}
				if (col.size() != dim) {
					columns++;
				}

			}
			System.out.println("Case #" + i + ": " + trace + " " + rows + " " + columns);

		}

	}
}
