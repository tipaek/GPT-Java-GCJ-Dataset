import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = Integer.parseInt(sc.nextLine());

		for (int c = 1; c <= t; c++) {
			int n = Integer.parseInt(sc.nextLine());
			int[][] matrix = new int[n][n];
			int trace = 0, row = 0, col = 0;

			for (int i = 0; i < n; i++) {
				String[] val = sc.nextLine().split(" ");
				for (int j = 0; j < n; j++) {
					matrix[i][j] = Integer.parseInt(val[j]);
					if (i == j)
						trace += matrix[i][j];
				}
			}

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n - 1; j++) {
					int x = matrix[i][j];
					boolean repeat = false;
					for (int k = j + 1; k < n; k++) {
						if (x == matrix[i][k]) {
							row++;
							repeat = true;
							break;
						}
					}
					if (repeat)
						break;
				}
			}
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n - 1; j++) {
					int x = matrix[j][i];
					boolean repeat = false;
					for (int k = j + 1; k < n; k++) {
						if (x == matrix[k][i]) {
							col++;
							repeat = true;
							break;
						}
					}
					if (repeat)
						break;
				}
			}

			System.out.println("Case #" + c + ": " + trace + " " + row + " " + col);

		}

	}

}
