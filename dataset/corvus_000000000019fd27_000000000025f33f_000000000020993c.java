import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		for (int i = 1; i <= t; ++i) {
			int n = in.nextInt();
			int[][] arr = new int[n][n];
			for (int r = 0; r < n; r++) {
				for (int c = 0; c < n; c++) {
					arr[r][c] = in.nextInt();
				}
			}
			int row = 0, col = 0;
			int trace = 0;
			for (int r = 0; r < n; r++) {
				for (int c = 0; c < n - 1; c++) {
					for (int j = c; j < n - 1; j++) {
						if (arr[r][c] == arr[r][j + 1]) {
							row++;
							c = n;
							break;
						}
					}
				}
			}

			for (int c = 0; c < n; c++) {
				trace +=arr[c][c];
				for (int r = 0; r < n-1; r++) {
					for (int j = r; j < n - 1; j++) {
						if (arr[r][c] == arr[j + 1][c]) {
							col++;
							r = n;
							break;
						}
					}
				}
			}

			System.out.println(String.format("Case #%d: %d %d %d", i, trace, row, col));
		}
	}
}
