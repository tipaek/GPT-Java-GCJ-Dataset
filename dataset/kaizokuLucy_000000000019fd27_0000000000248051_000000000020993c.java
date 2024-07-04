import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {

			int T = sc.nextInt();
			for (int t = 1; t <= T; t++) {

				int N = sc.nextInt();
				Integer[][] matrix = new Integer[N][N];

				for (int r = 0; r < N; r++) {
					for (int c = 0; c < N; c++) {
						matrix[r][c] = sc.nextInt();
					}
				}
				
				System.out.println("Case #" + t + ": " + trace(matrix) + " " + repeatedRowNum(matrix) + " " + repeatedColumnNum(matrix));
			}

		} 
	}
	
	private static int repeatedColumnNum(Integer[][] matrix) {
		int cNum = 0;
		for (int i = 0; i < matrix.length; i++) {
			Set<Integer> cSet = new HashSet<>();
			for (int j = 0; j < matrix.length; j++) {
				cSet.add(matrix[j][i]);
			}
			if (cSet.size() != matrix.length) {
				cNum++;
			}
		}
		return cNum;
	}

	private static int repeatedRowNum(Integer[][] matrix) {
		int rNum = 0;
		for (int i = 0; i < matrix.length; i++) {
			Set<Integer> rSet = new HashSet<>(Arrays.asList(matrix[i]));
			if (rSet.size() != matrix.length) {
				rNum++;
			}
		}
		return rNum;
	}

	private static void printMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static int trace(Integer[][] matrix) {
		int sum = 0;
		for (int i = 0; i < matrix.length; i++) {
			sum += matrix[i][i];
		}
		return sum;
	}
}
