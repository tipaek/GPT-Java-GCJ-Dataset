import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			int row = 0;
			int col = 0;
			int trace = 0;
			int diag = 0;
			int n = Integer.parseInt(br.readLine());
			int[][] matrix = new int[n][n];
			int[][] matrixIn = new int[n][n];
			int[] ideal = new int[n];
			for (int j = 0; j < n; j++) {
				ideal[j] = j + 1;
			}
			for (int j = 0; j < n; j++) {
				matrix[j] = split(br.readLine(), n);
				trace += matrix[j][diag++];
				if (isInvalid(matrix[j], ideal))
					row++;
				for (int k = 0; k < n; k++) {
					matrixIn[k][j] = matrix[j][k];
				}
			}
			for (int j = 0; j < n; j++) {
				if (isInvalid(matrixIn[j], ideal))
					col++;
			}

			System.out.println("Case #" + i + ": " + trace + " " + row + " " + col);

		}

	}

	private static boolean isInvalid(int[] array, int[] ideal) {
		int[] copy=array.clone();
		Arrays.sort(copy);
		for (int i = 0; i < ideal.length; i++) {
			if (copy[i] != ideal[i])
				return true;
		}
		return false;
	}

	static int[] split(String line, int n) {
		int[] intArray = new int[n];
		line = line.trim();

		int posInd = 0, endInd, ind = 0;
		while ((endInd = line.indexOf(' ', posInd)) >= 0) {
			intArray[ind++] = Integer.parseInt(line.substring(posInd, endInd));
			posInd = endInd + 1;
		}
		intArray[n - 1] = Integer.parseInt(line.substring(posInd, line.length()));
		return intArray;
	}
}
