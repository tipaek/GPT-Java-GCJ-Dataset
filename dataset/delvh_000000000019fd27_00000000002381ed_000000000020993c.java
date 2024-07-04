import static java.lang.System.out;

import java.util.Scanner;

public class Solution {

	private void solve(Scanner in) throws Exception {
		int		matrixSize	= in.nextInt();
		int		trace		= 0, rowRepeated = 0, columnRepeated = 0;
		int[][]	matrix		= new int[matrixSize][matrixSize];
		// works
		for (int i = 0; i < matrixSize; i++)
			for (int j = 0; j < matrixSize; j++) {
				matrix[i][j] = in.nextInt();
				if (i == j) trace += matrix[i][j];
			}
		System.out.print(trace);

		for (int[] row : matrix)
			outer:
			for (int i = 0; i < row.length; i++)
				for (int j = i + 1; j < row.length; j++)
					if (row[i] == row[j]) {
						rowRepeated++;
						break outer;
					}
		System.out.print(" " + rowRepeated);

		for (int i = 0; i < matrix.length; i++) {
			int[] col = new int[matrix.length];
			for (int j = 0; j < matrix.length; j++)
				col[j] = matrix[j][i];
			outer:
			for (int j = 0; j < col.length - 1; j++)
				for (int k = j + 1; k < col.length; k++)
					if (col[j] == col[k]) {
						columnRepeated++;
						break outer;
					}
		}
		System.out.print(" " + columnRepeated + "\n");

	}

	private void run() throws Exception {
		Scanner	in	= new Scanner(System.in);
		int		t	= in.nextInt();
		for (int i = 1; i <= t; ++i) {
			out.printf("Case #%d: ", i);
			solve(in);
		}
		in.close();
	}

	public static void main(String[] args) throws Exception { new Solution().run(); }
}