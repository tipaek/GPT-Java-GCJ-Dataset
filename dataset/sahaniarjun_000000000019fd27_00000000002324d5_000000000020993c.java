import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

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
			for (int j = 0; j < n; j++) {
				matrix[j] = split(br.readLine(), n);
				trace += matrix[j][diag++];
				if (distinctSize(matrix[j]) != n)
					row ++;
				for (int k = 0; k < n; k++) {
					matrixIn[k][j] = matrix[j][k];
				}
			}
			for (int j = 0; j < n; j++) {
				if (distinctSize(matrixIn[j]) != n)
					col ++;
			}

			System.out.println("Case #" + i + ": " + trace + " " + row + " " + col);

		}

	}

	private static int distinctSize(int[] array) {
		HashSet<Integer> set = new HashSet<Integer>();
		for (int i : array) {
			set.add(i);
		}
		return set.size();
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
