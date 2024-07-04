import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

		int t = in.nextInt();
		for (int i = 1; i <= t; ++i) {
			solve(in, i);
		}

		in.close();
	}

	private static void solve(Scanner in, int num) {
		int size = in.nextInt();
		int[][] matrix = new int[size][size];

		for (int r = 0; r < size; r++) {
			for (int c = 0; c < size; c++) {
				matrix[r][c] = in.nextInt();
			}
		}

        int trace = 0;
		int repeatColumn = 0;
		int repeatRow = 0;

		for (int i = 0; i < size; i++) {
			trace += matrix[i][i];
		}

		boolean[] check = new boolean[size];
		
		for (int r = 0; r < size; r++) {
			Arrays.fill(check, false);
			for (int c = 0; c < size; c++) {
				if (check[matrix[r][c] - 1]) {
					repeatRow++;
					break;
				} else {
					check[matrix[r][c] - 1] = true;
				}
			}
		}

		for (int c = 0; c < size; c++) {
			Arrays.fill(check, false);
			for (int r = 0; r < size; r++) {
				if (check[matrix[r][c] - 1]) {
					repeatColumn++;
					break;
				} else {
					check[matrix[r][c] - 1] = true;
				}
			}
		}

		System.out.println("Case #" + num + ": " + trace + " " + repeatRow + " " + repeatColumn);
	}
}