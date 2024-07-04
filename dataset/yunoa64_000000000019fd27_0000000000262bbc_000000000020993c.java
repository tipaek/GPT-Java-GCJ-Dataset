import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
	static int findTrace(int[][] matrix, int size) {
		int sum = 0;
		for (int i = 0; i < size; i++) {
			sum += matrix[i][i];
		}
		return sum;
	}

	static int findRow(int[][] matrix, int size) {
		int result = 0;
		boolean flag = false;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size - 1; j++) {
				for (int k = j + 1; k < size; k++) {
					if (matrix[i][j] == matrix[i][k]) {
						flag = true;
						break;
					}
				}
				if (flag)
					break;
			}
			if (flag)
				result++;
			flag = false;
		}
		return result;
	}

	static int findColumn(int[][] matrix, int size) {
		int result = 0;
		boolean flag = false;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size - 1; j++) {
				for (int k = j + 1; k < size; k++) {
					if (matrix[j][i] == matrix[k][i]) {
						flag = true;
						break;
					}
				}
				if (flag)
					break;
			}
			if (flag)
				result++;
			flag = false;
		}
		return result;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int n = in.nextInt();

		for (int i = 0; i < n; i++) {
			int size = in.nextInt();
			int[][] matrix = new int[size][size];
			for (int j = 0; j < size; j++) {
				for (int k = 0; k < size; k++) {
					matrix[j][k] = in.nextInt();
				}
			}
			System.out.printf("Case #%d: %d %d %d", (i + 1), findTrace(matrix, size), findRow(matrix, size),
					findColumn(matrix, size));
			System.out.println();
		}
	}
}