import java.util.Scanner;

class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int testAmount = scan.nextInt();

		for (int test = 1; test < testAmount; test++) {

			int n = scan.nextInt();

			int[][] matrix = new int[n][n];

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					matrix[i][j] = scan.nextInt();
				}
			}

			int trace = 0;

			for (int i = 0; i < n; i++) {
				trace += matrix[i][i];
			}

			int rowsDouble = 0;
			int columnsDouble = 0;
			
			for (int i = 0; i < n; i++) {
				boolean[] seen = new boolean[n+1];
				for (int j = 0; j < n; j++) {
					if (seen[matrix[i][j]]) {
						rowsDouble++;
						break;
					}
					seen[j] = true;
				}
			}

			for (int col = 0; col < n; col++) {
				boolean[] seen = new boolean[n+1];
				for (int row = 0; row < n; row++) {
					if (seen[matrix[row][col]]) {
						columnsDouble++;
						break;
					}
					seen[row] = true;
				}
			}

			System.out.println("Case #" + test + ": " + trace + " " + rowsDouble + " " + columnsDouble);
		}
	}
}