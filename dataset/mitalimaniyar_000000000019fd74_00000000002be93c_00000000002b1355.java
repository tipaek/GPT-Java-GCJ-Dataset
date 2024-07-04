import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		int t = s.nextInt();

		Long answers[] = new Long[t];
		for (int count = 0; count < t; count++) {
			int r = s.nextInt();
			int c = s.nextInt();

			long level = 0L;
			long initialLevel = 0L;

			int[][] arr = new int[r][c];
			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					int num = s.nextInt();
					arr[i][j] = num;
					initialLevel += num;
				}
			}
			level += initialLevel;

			long levl = initialLevel;
			while (true) {

				// Calculate neighboursAvg
				double[][] neighbours = new double[r][c];
				int[][] mark = new int[r][c];
				int anyElim = 0;
				for (int i = 0; i < r; i++) {
					for (int j = 0; j < c; j++) {
						if (arr[i][j] != -1) {
							neighbours[i][j] = calulateSum(arr, i, j, r, c);
							if (neighbours[i][j] > arr[i][j]) {
								anyElim = 1;
								levl = levl - arr[i][j];
								mark[i][j] = 1;
							}
						}
					}
				}

				if (anyElim == 0)
					break;
				else {
					level += levl;
					for (int i = 0; i < r; i++) {
						for (int j = 0; j < c; j++) {
							if (mark[i][j] == 1) {
								arr[i][j] = -1;
							}
						}
					}
				}
			}

			answers[count] = level;

		}

		for (int count = 0; count < t; count++) {
			System.out.println("Case #" + (count + 1) + ": " + answers[count]);
		}
	}

	private static double calulateSum(int[][] arr, int i, int j, int r, int c) {
		double sum = 0.0;
		int total = 0;
		for (int ii = i - 1; ii >= 0; ii--) {
			if (arr[ii][j] != -1) {
				sum += arr[ii][j];
				total++;
				break;
			}
		}

		for (int ii = i + 1; ii < r; ii++) {
			if (arr[ii][j] != -1) {
				sum += arr[ii][j];
				total++;
				break;
			}
		}

		for (int jj = j - 1; jj >= 0; jj--) {
			if (arr[i][jj] != -1) {
				sum += arr[i][jj];
				total++;
				break;
			}
		}

		for (int jj = j + 1; jj < c; jj++) {
			if (arr[i][jj] != -1) {
				sum += arr[i][jj];
				total++;
				break;
			}
		}

		return sum / (double) total;
	}

}